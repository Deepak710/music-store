package DMB.PRJ.MusicFront.exception;

import java.io.Serializable;

public class EntityNotFoundException extends Exception implements Serializable{
	private static final long serialVersionUID = 1L;
	private String m;
	public EntityNotFoundException() {
		this("Entity is Not Avaliable");
	}
	public EntityNotFoundException(String m) {
		this.m = System.currentTimeMillis() + ": " + m;
	}
	public String getM() {
		return m;
	}
}
