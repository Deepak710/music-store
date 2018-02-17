package DMB.PRJ.MusicBack.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@IdClass(AlbumPK.class)
public class Album implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@NotBlank(message = "Enter Album Name...")
	private String name;
	private String pic = "";
	@Id
	private String artist;
	private String genre;
	private String lang;
	private boolean active = true;
	@JsonIgnore
	private int view = 0;
	private int songs = 0;
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
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	public int getSongs() {
		return songs;
	}
	public void setSongs(int songs) {
		this.songs = songs;
	}
	@Override
	public String toString() {
		return "Album [name=" + name + ", pic=" + pic + ", artist=" + artist + ", genre=" + genre + ", lang=" + lang
				+ ", active=" + active + ", view=" + view + ", songs=" + songs + "]";
	}
}
