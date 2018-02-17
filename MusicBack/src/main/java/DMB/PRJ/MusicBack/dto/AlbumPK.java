package DMB.PRJ.MusicBack.dto;

import java.io.Serializable;

public class AlbumPK implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String name;
	protected String artist;
	public AlbumPK() {
	}
	public AlbumPK(String name, String artist) {
		this.name=name;
		this.artist=artist;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		AlbumPK other = (AlbumPK) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
