package DMB.PRJ.MusicFront.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import DMB.PRJ.MusicBack.dto.Genre;

public class GenreValidator implements Validator {
	@Override
	public boolean supports(Class<?> c) {
		return Genre.class.equals(c);
	}
	@Override
	public void validate(Object target, Errors e) {
		Genre g = (Genre) target;
		if (g.getFile()==null || g.getFile().getOriginalFilename().equals("")) e.rejectValue("file", null, "A Pic to envision the Genre...");
		else if (!g.getFile().getContentType().equals("image/jpeg")) e.rejectValue("file", null, "Select a JPEG Image only.");
	}
}
