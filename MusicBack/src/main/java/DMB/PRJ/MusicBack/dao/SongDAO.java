package DMB.PRJ.MusicBack.dao;

import java.util.List;

import DMB.PRJ.MusicBack.dto.Song;

public interface SongDAO {
	List<Song> listAlbumSongs(String album, String artist);
	Song get(String artsit, String album, int track);
	boolean add(Song s);
	boolean update(Song s);
}
