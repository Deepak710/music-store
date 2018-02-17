package DMB.PRJ.MusicFront.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import DMB.PRJ.MusicBack.dto.Album;

public class AlbumValidator implements Validator {
	@Override
	public boolean supports(Class<?> c) {
		return Album.class.equals(c);
	}
	@Override
	public void validate(Object target, Errors e) {
		Album a = (Album) target;
		if (a.getFile()==null || a.getFile().getOriginalFilename().equals("")) e.rejectValue("file", null, "An Album Art is Perfection...");
		else if (!a.getFile().getContentType().equals("image/jpeg")) e.rejectValue("file", null, "Select a JPEG Image only.");
	}
}
