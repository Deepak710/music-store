package DMB.PRJ.MusicBack.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private String role;
	private String password;
	private boolean enabled = true;
	private String address;
	private long phone;
	@Id
	private String email;
	@OneToOne(mappedBy = "u", cascade = CascadeType.ALL)
	private Cart c;
	public Cart getC() {
		return c;
	}

	public void setC(Cart c) {
		this.c = c;
	}

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
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
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
				+ ", address=" + address + ", phone=" + phone + ", email=" + email + ", c=" + c + "]";
	}
	
}
