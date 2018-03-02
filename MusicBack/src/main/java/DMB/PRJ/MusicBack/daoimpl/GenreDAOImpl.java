package DMB.PRJ.MusicBack.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import DMB.PRJ.MusicBack.dao.GenreDAO;
import DMB.PRJ.MusicBack.dto.Genre;

@Repository("gdao")
@Transactional
public class GenreDAOImpl implements GenreDAO {
	@Autowired
	private SessionFactory sf;
	@Override
	public List<Genre> listActiveGenres() {
		String select = "FROM Genre WHERE active = :active";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("active", true);
		return q.getResultList();
	}
	@Override
	public List<Genre> listAllGenres() {
		String select = "FROM Genre";
		Query q = sf.getCurrentSession().createQuery(select);
		return q.getResultList();
	}
	@Override
	public Genre get(String name) {
		return sf.getCurrentSession().get(Genre.class, String.valueOf(name));
	}
	@Override
	public boolean add(Genre g) {
		g.setPic("genre-"+g.getName().toLowerCase()+".jpg");
		try {
			sf.getCurrentSession().persist(g);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean update(Genre g) {
		try {
			sf.getCurrentSession().update(g);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	@Override
	public boolean delete(Genre g) {
		g.setActive(false);
		try {
			sf.getCurrentSession().update(g);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public String topGenrePic() {
		String select = "SELECT pic FROM Genre WHERE view = (SELECT MAX(view) FROM Genre WHERE active = :active)";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("active", true);
		List l = q.list();
		return (String) l.get(0);
	}
	@Override
	public String topGenre() {
		String select = "SELECT name FROM Genre WHERE view = (SELECT MAX(view) FROM Genre WHERE active = :active)";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("active", true);
		List l = q.list();
		return (String) l.get(0);
	}
	@Override
	public String topGenreDescription() {
		String select = "SELECT description FROM Genre WHERE view = (SELECT MAX(view) FROM Genre WHERE active = :active)";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("active", true);
		List l = q.list();
		return (String) l.get(0);
	}
}