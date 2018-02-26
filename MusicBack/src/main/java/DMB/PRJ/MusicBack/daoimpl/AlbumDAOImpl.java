package DMB.PRJ.MusicBack.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import DMB.PRJ.MusicBack.dao.AlbumDAO;
import DMB.PRJ.MusicBack.dto.Album;

@Repository("albdao")
@Transactional
public class AlbumDAOImpl implements AlbumDAO {
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	public boolean add(Album a) {
		a.setPic("album-"+a.getName().toLowerCase()+"-"+a.getArtist().toLowerCase()+".jpg");
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
	public boolean update(Album a) {
		try {
			sf.getCurrentSession().update(a);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Album a) {
		a.setActive(false);
		try {
			sf.getCurrentSession().update(a);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Album> listAllAlbums() {
		String select = "FROM Album";
		Query q = sf.getCurrentSession().createQuery(select);
		return q.getResultList();
	}

	@Override
	public List<Album> listGenreAlbums(String genre) {
		String select = "FROM Album WHERE active = :active AND genre = :genre";
		return sf.getCurrentSession().createQuery(select, Album.class)
				.setParameter("active", true)
				.setParameter("genre", genre)
				.getResultList();
	}

	@Override
	public List<Album> listArtistAlbums(String artist) {
		String select = "FROM Album WHERE active = :active AND artist = :artist";
		return sf.getCurrentSession().createQuery(select, Album.class)
				.setParameter("active", true)
				.setParameter("artist", artist)
				.getResultList();
	}

	@Override
	public List<Album> listActiveAlbums() {
		String select = "FROM Album WHERE active = :active";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("active", true);
		return q.getResultList();
	}

	@Override
	public Album get(String artist, String album) {
		String select = "FROM Album WHERE artist = :artist AND name = :album";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("artist", artist);
		q.setParameter("album", album);
		return (Album)q.getSingleResult();
	}

	@Override
	public List<Album> listLangAlbums(String lang) {
		String select = "FROM Album WHERE active = :active AND lang = :lang";
		return sf.getCurrentSession().createQuery(select, Album.class)
				.setParameter("active", true)
				.setParameter("lang", lang)
				.getResultList();
	}

	@Override
	public String trendingAlbumPic() {
		String select = "SELECT pic FROM Album WHERE view = (SELECT MAX(view) FROM Album WHERE active = :active)";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("active", true);
		List l = q.list();
		return (String) l.get(0);
	}

	@Override
	public String trendingAlbumName() {
		String select = "SELECT name FROM Album WHERE view = (SELECT MAX(view) FROM Album WHERE active = :active)";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("active", true);
		List l = q.list();
		return (String) l.get(0);
	}

	@Override
	public String trendingAlbumArtist() {
		String select = "SELECT artist FROM Album WHERE view = (SELECT MAX(view) FROM Album WHERE active = :active)";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("active", true);
		List l = q.list();
		return (String) l.get(0);
	}
	
	@Override
	public String latestAlbumPic() {
		String select = "SELECT pic FROM Album WHERE date = (SELECT MAX(date) FROM Album WHERE active = :active)";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("active", true);
		List l = q.list();
		return (String) l.get(0);
	}

	@Override
	public String latestAlbumName() {
		String select = "SELECT name FROM Album WHERE date = (SELECT MAX(date) FROM Album WHERE active = :active)";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("active", true);
		List l = q.list();
		return (String) l.get(0);
	}

	@Override
	public String latestAlbumArtist() {
		String select = "SELECT artist FROM Album WHERE date = (SELECT MAX(date) FROM Album WHERE active = :active)";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("active", true);
		List l = q.list();
		return (String) l.get(0);
	}

}
