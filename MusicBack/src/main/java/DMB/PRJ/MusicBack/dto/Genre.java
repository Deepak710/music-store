package DMB.PRJ.MusicBack.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Genre {
	@Id
	@NotBlank(message = "Enter Genre Name...")
	private String name;
	private String pic = "";
	@NotBlank(message = "Enter Genre Description...")
	private String description;
	private boolean active = true;
	@JsonIgnore
	private int view = 0;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	@Override
	public String toString() {
		return "Genre [name=" + name + ", pic=" + pic + ", description=" + description + ", active=" + active
				+ ", view=" + view + "]";
	}
}
