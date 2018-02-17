package DMB.PRJ.MusicBack.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

@Entity
@IdClass(SongPK.class)
public class Song implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotBlank(message = "Enter Song Name...")
	private String name;
	@Id
	private int track_no = 0;
	@Min(value = 1, message = "The Price cannot be less than Rs. 1/-")
	private int rate;
	private String preview = "";
	@Id
	private String album;
	@Id
	private String artist;
	private int rating=0;
	private int bought=0;
	@Transient
	private MultipartFile file; 
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTrack_no() {
		return track_no;
	}
	public void setTrack_no(int track_no) {
		this.track_no = track_no;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public String getPreview() {
		return preview;
	}
	public void setPreview(String preview) {
		this.preview = preview;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getBought() {
		return bought;
	}
	public void setBought(int bought) {
		this.bought = bought;
	}
	@Override
	public String toString() {
		return "Song [name=" + name + ", track_no=" + track_no + ", rate=" + rate + ", preview=" + preview + ", album="
				+ album + ", artist=" + artist + ", rating=" + rating + ", bought=" + bought + "]";
	}
}
