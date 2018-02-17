package DMB.PRJ.MusicFront.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import DMB.PRJ.MusicBack.dto.Artist;

public class ArtistValidator implements Validator {
	@Override
	public boolean supports(Class<?> c) {
		return Artist.class.equals(c);
	}
	@Override
	public void validate(Object target, Errors e) {
		Artist a = (Artist) target;
		if (a.getFile()==null || a.getFile().getOriginalFilename().equals("")) e.rejectValue("file", null, "Show the Beauty of the Artist...");
		else if (!a.getFile().getContentType().equals("image/jpeg")) e.rejectValue("file", null, "Select a JPEG Image only.");
	}
}
