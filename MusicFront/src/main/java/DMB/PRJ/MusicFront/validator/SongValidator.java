package DMB.PRJ.MusicFront.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import DMB.PRJ.MusicBack.dto.Song;

public class SongValidator implements Validator {
	@Override
	public boolean supports(Class<?> c) {
		return Song.class.equals(c);
	}
	@Override
	public void validate(Object target, Errors e) {
		Song s = (Song) target;
		if (s.getFile()==null || s.getFile().getOriginalFilename().equals("")) e.rejectValue("file", null, "A Preview for the Ears...");
		else if (!s.getFile().getContentType().equals("audio/mp3")) e.rejectValue("file", null, "Select a MPEG Audio only.");
	}
}
