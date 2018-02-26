package DMB.PRJ.MusicBack.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import DMB.PRJ.MusicBack.dao.ArtistDAO;
import DMB.PRJ.MusicBack.dto.Artist;

@Repository("artdao")
@Transactional
public class ArtistDAOImpl implements ArtistDAO {
	@Autowired
	private SessionFactory sf;
	@Override
	public List<Artist> listActiveArtists() {
		String select = "FROM Artist WHERE active = :active";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("active", true);
		return q.getResultList();
	}
	@Override
	public List<Artist> listAllArtists() {
		String select = "FROM Artist";
		Query q = sf.getCurrentSession().createQuery(select);
		return q.getResultList();
	}
	@Override
	public Artist get(String name) {
		return sf.getCurrentSession().get(Artist.class, String.valueOf(name));
	}
	@Override
	public boolean add(Artist a) {
		a.setPic("artist-"+a.getName().toLowerCase()+".jpg");
		try {
			sf.getCurrentSession().persist(a);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean update(Artist a) {
		try {
			sf.getCurrentSession().update(a);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	@Override
	public boolean delete(Artist a) {
		a.setActive(false);
		try {
			sf.getCurrentSession().delete(a);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public String topArtistPic() {
		String select = "SELECT pic FROM Artist WHERE view = (SELECT MAX(view) FROM Artist WHERE active = :active)";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("active", true);
		List l = q.list();
		return (String) l.get(0);
	}
	@Override
	public String topArtist() {
		String select = "SELECT name FROM Artist WHERE view = (SELECT MAX(view) FROM Artist WHERE active = :active)";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("active", true);
		List l = q.list();
		return (String) l.get(0);
	}
}
