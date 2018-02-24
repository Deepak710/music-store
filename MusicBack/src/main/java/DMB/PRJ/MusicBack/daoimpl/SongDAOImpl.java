package DMB.PRJ.MusicBack.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import DMB.PRJ.MusicBack.dao.AlbumDAO;
import DMB.PRJ.MusicBack.dao.SongDAO;
import DMB.PRJ.MusicBack.dto.Album;
import DMB.PRJ.MusicBack.dto.Song;

@Repository("sdao")
@Transactional
public class SongDAOImpl implements SongDAO {
	@Autowired
	private AlbumDAO albdao;
	@Autowired
	private SessionFactory sf;

	@Override
	public boolean add(Song s) {
		String select = "FROM Song WHERE album = :album AND artist = :artist";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("album", s.getAlbum());
		q.setParameter("artist", s.getArtist());
		s.setTrack_no(q.getResultList().size()+1);
		s.setPreview(s.getArtist().toLowerCase()+"-"+s.getAlbum().toLowerCase()+"-"+Integer.toString(s.getTrack_no())+".mp3");
		Album alb = albdao.get(s.getArtist(), s.getAlbum());
		alb.setSongs(alb.getSongs()+1);
		albdao.update(alb);
		try {
			sf.getCurrentSession().persist(s);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Song s) {
		try {
			sf.getCurrentSession().update(s);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Song get(String artist, String album, int track) {
		String select = "FROM Song WHERE album = :album AND artist = :artist AND track_no = :track";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("album", album);
		q.setParameter("artist", artist);
		q.setParameter("track", track);
		return (Song)q.getSingleResult();
	}

	@Override
	public List<Song> listAlbumSongs(String album, String artist) {
		String select = "FROM Song WHERE album = :album AND artist = :artist";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("album", album);
		q.setParameter("artist", artist);
		return q.getResultList();
	}

	@Override
	public List<Song> listAllSongs() {
		String select = "FROM Song";
		Query q = sf.getCurrentSession().createQuery(select);
		return q.getResultList();
	}
	
	@Override
	public String trendingSongName() {
		String select = "SELECT name FROM Song WHERE bought = (SELECT MAX(bought) FROM Song S WHERE (SELECT active FROM Album WHERE name = S.album AND artist = S.artist) = :active)";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("active", true);
		List l = q.list();
		return (String) l.get(0);
	}

	@Override
	public String trendingSongAlbum() {
		String select = "SELECT album FROM Song WHERE bought = (SELECT MAX(bought) FROM Song S WHERE (SELECT active FROM Album WHERE name = S.album AND artist = S.artist) = :active)";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("active", true);
		List l = q.list();
		return (String) l.get(0);
	}

	@Override
	public String trendingSongArtist() {
		String select = "SELECT artist FROM Song WHERE bought = (SELECT MAX(bought) FROM Song S WHERE (SELECT active FROM Album WHERE name = S.album AND artist = S.artist) = :active)";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("active", true);
		List l = q.list();
		return (String) l.get(0);
	}
	
	@Override
	public String trendingSongNumber() {
		String select = "SELECT track_no FROM Song WHERE bought = (SELECT MAX(bought) FROM Song S WHERE (SELECT active FROM Album WHERE name = S.album AND artist = S.artist) = :active)";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("active", true);
		List l = q.list();
		return String.valueOf(l.get(0));
	}

	@Override
	public String latestSongName() {
		String select = "SELECT name FROM Song WHERE date = (SELECT MAX(date) FROM Song S WHERE (SELECT active FROM Album WHERE name = S.album AND artist = S.artist) = :active)";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("active", true);
		List l = q.list();
		return (String) l.get(0);
	}

	@Override
	public String latestSongArtist() {
		String select = "SELECT artist FROM Song WHERE date = (SELECT MAX(date) FROM Song S WHERE (SELECT active FROM Album WHERE name = S.album AND artist = S.artist) = :active)";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("active", true);
		List l = q.list();
		return (String) l.get(0);
	}
	
	@Override
	public String latestSongAlbum() {
		String select = "SELECT album FROM Song WHERE date = (SELECT MAX(date) FROM Song S WHERE (SELECT active FROM Album WHERE name = S.album AND artist = S.artist) = :active)";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("active", true);
		List l = q.list();
		return (String) l.get(0);
	}
	
	@Override
	public String latestSongNumber() {
		String select = "SELECT track_no FROM Song WHERE date = (SELECT MAX(date) FROM Song S WHERE (SELECT active FROM Album WHERE name = S.album AND artist = S.artist) = :active)";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("active", true);
		List l = q.list();
		return String.valueOf(l.get(0));
	}

}
