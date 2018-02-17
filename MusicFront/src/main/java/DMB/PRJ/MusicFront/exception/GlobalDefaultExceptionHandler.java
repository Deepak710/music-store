package DMB.PRJ.MusicFront.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView noHandler() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("error", "Page is not Constructed!!");
		mv.addObject("description", "The Page you're looking for does not exist.. Yet");
		mv.addObject("title", "404 ERROR Page");
		return mv;
	}
	@ExceptionHandler(Exception.class)
	public ModelAndView global(Exception e) {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("error", "Houston!!! We've Got a Problem");
		mv.addObject("description", "Yikes!!! Something Went Wrong...  <br/>What we know is...<br/>" + e.toString());
		mv.addObject("title", "I Dont Know");
		return mv;
	}
	@ExceptionHandler(EntityNotFoundException.class)
	public ModelAndView noEntity(EntityNotFoundException e) {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("error", "Entity Not Avaliable");
		mv.addObject("description", "The Entity you're looking for does not exist.. Yet. <br/>Details - " + e.getM());
		mv.addObject("title", "Unavaliable Entity");
		return mv;
	}
}
