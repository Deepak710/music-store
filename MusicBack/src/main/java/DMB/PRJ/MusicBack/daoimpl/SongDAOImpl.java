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

}
