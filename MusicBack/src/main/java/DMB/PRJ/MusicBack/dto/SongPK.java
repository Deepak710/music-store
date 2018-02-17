package DMB.PRJ.MusicBack.dto;

import java.io.Serializable;

public class SongPK implements Serializable {
	private static final long serialVersionUID = 1L;
	protected int track_no;
	protected String album;
	protected String artist;
	public SongPK() {	
	}
	public SongPK(int track_no, String album, String artist) {
		this.track_no=track_no;
		this.album=album;
		this.artist=artist;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((album == null) ? 0 : album.hashCode());
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + track_no;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SongPK other = (SongPK) obj;
		if (album == null) {
			if (other.album != null)
				return false;
		} else if (!album.equals(other.album))
			return false;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (track_no != other.track_no)
			return false;
		return true;
	}
}
