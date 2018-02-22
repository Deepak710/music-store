package DMB.PRJ.MusicBack.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	@NotBlank(message = "Enter User Name...")
	private String name;
	private String role;
	@Size(min = 8, message = "Password must be at-least 8 characters")
	private String password;
	private boolean enabled = false;
	@NotBlank(message = "Enter Your Address...")
	private String address;
	@Pattern(regexp="\\d{10}", message = "Enter Valid Phone Number")
	private String phone;
	@Id
	@NotBlank(message = "Enter E-Mail Address...")
	@Email(message = "Enter Valid E-Mail Address")
	private String email;
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", role=" + role + ", password=" + password + ", enabled=" + enabled
				+ ", address=" + address + ", phone=" + phone + ", email=" + email + "]";
	}
	
}
