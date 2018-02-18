package DMB.PRJ.MusicFront.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DMB.PRJ.MusicBack.dao.AlbumDAO;
import DMB.PRJ.MusicBack.dao.ArtistDAO;
import DMB.PRJ.MusicBack.dao.GenreDAO;
import DMB.PRJ.MusicBack.dao.SongDAO;
import DMB.PRJ.MusicBack.dao.UserDAO;
import DMB.PRJ.MusicBack.dto.Album;
import DMB.PRJ.MusicBack.dto.Artist;
import DMB.PRJ.MusicBack.dto.Genre;
import DMB.PRJ.MusicBack.dto.Song;
import DMB.PRJ.MusicBack.dto.User;
import DMB.PRJ.MusicFront.exception.EntityNotFoundException;

@Controller
public class PageController {
	private static final Logger l = LoggerFactory.getLogger(PageController.class);
	@Autowired
	private GenreDAO gdao;
	@Autowired
	private ArtistDAO artdao;
	@Autowired
	private AlbumDAO albdao;
	@Autowired
	private SongDAO sdao;
	@Autowired
	private UserDAO udao;
	@RequestMapping(value = {"/", "/home"})
	public ModelAndView home() {
		l.info("Inside Home Page; PageController.java home() method - INFO");
		l.debug("Inside Home Page; PageController.java home() method - DEBUG");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Browse Music Store");
		mv.addObject("userClickHome", true);
		mv.addObject("genres", gdao.listActiveGenres());
		mv.addObject("artists",artdao.listActiveArtists());
		
		if(udao.loggedUser().equals("null")) mv.addObject("logged", udao.loggedUser());
		else {
			User u = udao.get(udao.loggedUser());
			mv.addObject("logged", u.getName());
		}
		mv.addObject("role", udao.loggedUserRole());
		
		return mv;
	}
	@RequestMapping(value = {"/signout"})
	public ModelAndView signout() {
		ModelAndView mv = new ModelAndView("redirect:/home");
		mv.addObject("userClickHome", true);
		
		if(udao.loggedUser().equals("null")) mv.addObject("logged", udao.loggedUser());
		else {
			User u = udao.get(udao.loggedUser());
			mv.addObject("logged", u.getName());
		}
		mv.addObject("role", udao.loggedUserRole());
		
		User c = udao.get(udao.loggedUser());
		c.setEnabled(false);
		udao.update(c);
		
		return mv;
	}
	@RequestMapping(value="/all/album")
	public ModelAndView browse() {
		l.info("Inside Browse all Album Page; PageController.java browse() method - INFO");
		l.debug("Inside Browse all Album Page; PageController.java browse() method - DEBUG");
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Browse All Albums");
		mv.addObject("genres",gdao.listActiveGenres());
		mv.addObject("artists",artdao.listActiveArtists());
		mv.addObject("userClickBrowse", true);

		if(udao.loggedUser().equals("null")) mv.addObject("logged", udao.loggedUser());
		else {
			User u = udao.get(udao.loggedUser());
			mv.addObject("logged", u.getName());
		}
		mv.addObject("role", udao.loggedUserRole());
		
		return mv;
	}
	@RequestMapping(value="/language/{name}/album")
	public ModelAndView language(@PathVariable("name") String name) throws EntityNotFoundException {
		l.info("Inside Browse language Album Page; PageController.java language() method - INFO");
		l.debug("Inside Browse language Album Page; PageController.java language() method - DEBUG");
		if (!name.equals("English") && !name.equals("Hindi") && !name.equals("Tamil")) throw new EntityNotFoundException("Unspecified Language");
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Browse "+ name +" Albums");
		mv.addObject("genres",gdao.listActiveGenres());
		mv.addObject("artists",artdao.listActiveArtists());
		mv.addObject("lang", name);
		mv.addObject("userClickLanguage", true);

		if(udao.loggedUser().equals("null")) mv.addObject("logged", udao.loggedUser());
		else {
			User u = udao.get(udao.loggedUser());
			mv.addObject("logged", u.getName());
		}
		mv.addObject("role", udao.loggedUserRole());
		
		return mv;
	}
	@RequestMapping(value="/genre/{name}/album")
	public ModelAndView genreName(@PathVariable("name") String name) throws EntityNotFoundException {
		l.info("Inside Browse genre Album Page; PageController.java genreName() method - INFO");
		l.debug("Inside Browse genre Album Page; PageController.java genreName() method - DEBUG");
		ModelAndView mv=new ModelAndView("page");
		Genre g = gdao.get(name);
		if (g == null) throw new EntityNotFoundException("Unspecified Genre...");
		g.setView(g.getView()+1);
		gdao.update(g);
		mv.addObject("title","Browse "+g.getName());
		mv.addObject("genre", g);
		mv.addObject("genres",gdao.listActiveGenres());
		mv.addObject("artists",artdao.listActiveArtists());
		mv.addObject("userClickGenre", true);

		if(udao.loggedUser().equals("null")) mv.addObject("logged", udao.loggedUser());
		else {
			User u = udao.get(udao.loggedUser());
			mv.addObject("logged", u.getName());
		}
		mv.addObject("role", udao.loggedUserRole());
		
		return mv;
	}
	@RequestMapping(value="/artist/{name}/album")
	public ModelAndView artistName(@PathVariable("name") String name) throws EntityNotFoundException {
		l.info("Inside Browse artist Album Page; PageController.java artistName() method - INFO");
		l.debug("Inside Browse artist Album Page; PageController.java artistName() method - DEBUG");
		ModelAndView mv=new ModelAndView("page");
		Artist a=artdao.get(name);
		if (a == null) throw new EntityNotFoundException("Unspecified Album...");
		a.setView(a.getView()+1);
		artdao.update(a);
		mv.addObject("title","Browse "+a.getName());
		mv.addObject("artist",a);
		mv.addObject("genres",gdao.listActiveGenres());
		mv.addObject("artists",artdao.listActiveArtists());
		mv.addObject("userClickArtist", true);

		if(udao.loggedUser().equals("null")) mv.addObject("logged", udao.loggedUser());
		else {
			User u = udao.get(udao.loggedUser());
			mv.addObject("logged", u.getName());
		}
		mv.addObject("role", udao.loggedUserRole());
		
		return mv;
	}
	@RequestMapping(value="/view/{artist}/{album}")
	public ModelAndView album(@PathVariable("artist") String artist, @PathVariable("album") String album) throws EntityNotFoundException {
		l.info("Inside Browse single Album Page; PageController.java album() method - INFO");
		l.debug("Inside Browse single Album Page; PageController.java album() method - DEBUG");
		ModelAndView mv=new ModelAndView("page");
		Album alb = albdao.get(artist, album);
		if (alb == null) throw new EntityNotFoundException("Unspecified Album Parameters...");
		alb.setView(alb.getView()+1);
		albdao.update(alb);
		List<Song> slist = sdao.listAlbumSongs(album, artist);
		int rate = 0;
		for(Song s : slist) {
			rate += s.getRate();
		}
		rate -= rate * 0.1;
		mv.addObject("title", artist + " - " + album);
		mv.addObject("album", alb);
		mv.addObject("rate", rate);
		mv.addObject("userClickAlbum", true);

		if(udao.loggedUser().equals("null")) mv.addObject("logged", udao.loggedUser());
		else {
			User u = udao.get(udao.loggedUser());
			mv.addObject("logged", u.getName());
		}
		mv.addObject("role", udao.loggedUserRole());
		
		return mv;
	}
}