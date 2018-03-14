package DMB.PRJ.MusicFront.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
import DMB.PRJ.MusicFront.util.FileUploadUtility;
import DMB.PRJ.MusicFront.validator.AlbumValidator;
import DMB.PRJ.MusicFront.validator.ArtistValidator;
import DMB.PRJ.MusicFront.validator.GenreValidator;
import DMB.PRJ.MusicFront.validator.SongValidator;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	@Autowired
	private ArtistDAO artdao;
	@Autowired
	private GenreDAO gdao;
	@Autowired
	private AlbumDAO albdao;
	@Autowired
	private SongDAO sdao;
	@Autowired
	private UserDAO udao;
	
	@ModelAttribute("artists")
	public List<Artist> artlist() {
		return artdao.listAllArtists();
	}
	@ModelAttribute("genres")
	public List<Genre> genrelist() {
		return gdao.listAllGenres();
	}
	@ModelAttribute("albums")
	public List<Album> albumlist() {
		return albdao.listAllAlbums();
	}
	
	private static final Logger l = LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping(value="/albums", method=RequestMethod.GET)
	public ModelAndView manageAlbums(@RequestParam(name="operation", required=false) String o) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageAlbums", true);
		mv.addObject("title", "Manage Albums");
		Album a = new Album();
		mv.addObject("album", a);
		if (o!=null) 
			if (o.equals("album"))
				mv.addObject("message", "Album Submitted Successfully!");

		if(udao.loggedUser().equals("null") || udao.loggedUserRole().equals("USER")) {
			mv.addObject("logged", udao.loggedUser());
			return new ModelAndView("redirect:/home");
		}
		else {
			User u = udao.get(udao.loggedUser());
			mv.addObject("logged", u.getName());
		}
		mv.addObject("role", udao.loggedUserRole());
		
		return mv;
	}
	@RequestMapping(value="/albums", method=RequestMethod.POST)
	public String handleNewAlbum(@Valid @ModelAttribute("album") Album a, BindingResult r, Model m, HttpServletRequest req) {
		if(a.getPic().equals("")) new AlbumValidator().validate(a, r);
		else if(!a.getFile().getOriginalFilename().equals("")) new AlbumValidator().validate(a, r);
		if (r.hasErrors()) {
			m.addAttribute("userClickManageAlbums", true);
			m.addAttribute("title", "Manage Albums");
			m.addAttribute("message", "Album Release Failed!!!");

			if(udao.loggedUser().equals("null") || udao.loggedUserRole().equals("USER")) {
				m.addAttribute("logged", udao.loggedUser());
				return "redirect:/home";
			}
			else {
				User u1 = udao.get(udao.loggedUser());
				m.addAttribute("logged", u1.getName());
			}
			m.addAttribute("role", udao.loggedUserRole());
			
			return "page";
		}
		if(a.getPic().equals("")) albdao.add(a);
		else if (albdao.update(a) == false) {
			m.addAttribute("userClickManageAlbums", true);
			m.addAttribute("title", "Manage Albums");
			m.addAttribute("message", "Cannot Change Name [or] Artist of the Album");
			return "page";
		}
		if (!a.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadPic(req, a.getFile(), a.getPic());
		}
		l.info(a.toString());
		return "redirect:/manage/albums?operation=album";
	}
	@RequestMapping(value="/{artist}/{album}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String handleAlbumActivation(@PathVariable("artist") String artist, @PathVariable("album") String album) throws EntityNotFoundException {
		if(udao.loggedUser().equals("null") || udao.loggedUserRole().equals("USER")) {
			new ModelAndView("redirect:/home");
		}
		if (albdao.get(artist, album) == null) throw new EntityNotFoundException("Unspecified Album...");
		Album alb = albdao.get(artist, album);
		boolean active = alb.isActive();
		alb.setActive(!active);
		albdao.update(alb);
		return active ? artist + "'s " + album + " Was successfully Broken!" : artist + "'s " + album + " Was successfully Restored!" ;
	}
	@RequestMapping(value="/{artist}/{album}", method=RequestMethod.GET)
	public ModelAndView manageAlbum(@PathVariable("artist") String artist, @PathVariable("album") String album) throws EntityNotFoundException {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageAlbums", true);
		mv.addObject("title", "Manage " + artist + " " + album );
		if (albdao.get(artist, album) == null) throw new EntityNotFoundException("Unspecified Album...");
		Album alb = albdao.get(artist, album);
		mv.addObject("album", alb);

		if(udao.loggedUser().equals("null") || udao.loggedUserRole().equals("USER")) {
			mv.addObject("logged", udao.loggedUser());
			return new ModelAndView("redirect:/home");
		}
		else {
			User u = udao.get(udao.loggedUser());
			mv.addObject("logged", u.getName());
		}
		mv.addObject("role", udao.loggedUserRole());
		
		return mv;
	}
	
	@RequestMapping(value="/artists", method=RequestMethod.GET)
	public ModelAndView manageArtists(@RequestParam(name="operation", required=false) String o) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageArtists", true);
		mv.addObject("title", "Manage Artists");
		Artist a = new Artist();
		mv.addObject("artist", a);
		if (o!=null) 
			if (o.equals("artist"))
				mv.addObject("message", "Artist Submitted Successfully!");

		if(udao.loggedUser().equals("null") || udao.loggedUserRole().equals("USER")) {
			mv.addObject("logged", udao.loggedUser());
			return new ModelAndView("redirect:/home");
		}
		else {
			User u = udao.get(udao.loggedUser());
			mv.addObject("logged", u.getName());
		}
		mv.addObject("role", udao.loggedUserRole());
		
		return mv;
	}
	@RequestMapping(value="/artists", method=RequestMethod.POST)
	public String handleNewArtist(@Valid @ModelAttribute("artist") Artist a, BindingResult r, Model m, HttpServletRequest req) {
		if(a.getPic().equals("")) new ArtistValidator().validate(a, r);
		else if(!a.getFile().getOriginalFilename().equals("")) new ArtistValidator().validate(a, r);
		if (r.hasErrors()) {
			m.addAttribute("userClickManageArtists", true);
			m.addAttribute("title", "Manage Artists");
			m.addAttribute("message", "Artist Creation Failed!!!");

			if(udao.loggedUser().equals("null") || udao.loggedUserRole().equals("USER")) {
				m.addAttribute("logged", udao.loggedUser());
				return "redirect:/home";
			}
			else {
				User u1 = udao.get(udao.loggedUser());
				m.addAttribute("logged", u1.getName());
			}
			m.addAttribute("role", udao.loggedUserRole());
			
			return "page";
		}
		if(a.getPic().equals("")) artdao.add(a);
		else if (artdao.update(a) == false) {
			m.addAttribute("userClickManageArtists", true);
			m.addAttribute("title", "Manage Artists");
			m.addAttribute("message", "Cannot Change the Name of the Artist");
			return "page";
		}
		if (!a.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadPic(req, a.getFile(), a.getPic());
		}
		l.info(a.toString());
		return "redirect:/manage/artists?operation=artist";
	}
	@RequestMapping(value="/artist/{name}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String handleArtistActivation(@PathVariable("name") String name) throws EntityNotFoundException {
		if(udao.loggedUser().equals("null") || udao.loggedUserRole().equals("USER")) {
			return "redirect:/home";
		}
		if (artdao.get(name) == null) throw new EntityNotFoundException("Unspecified Artist...");
		Artist a = artdao.get(name);
		boolean active = a.isActive();
		a.setActive(!active);
		artdao.update(a);
		return active ? name + " Was successfully Killed!" : name + " Was successfully Re-Animated!" ;
	}
	@RequestMapping(value="/artist/{name}", method=RequestMethod.GET)
	public ModelAndView manageArtist(@PathVariable("name") String name) throws EntityNotFoundException {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageArtists", true);
		mv.addObject("title", "Manage " + name + " Artist");
		if (artdao.get(name) == null) throw new EntityNotFoundException("Unspecified Artist...");
		Artist a = artdao.get(name);
		mv.addObject("artist", a);

		if(udao.loggedUser().equals("null") || udao.loggedUserRole().equals("USER")) {
			mv.addObject("logged", udao.loggedUser());
			return new ModelAndView("redirect:/home");
		}
		else {
			User u = udao.get(udao.loggedUser());
			mv.addObject("logged", u.getName());
		}
		mv.addObject("role", udao.loggedUserRole());
		
		return mv;
	}
	
	@RequestMapping(value="/genres", method=RequestMethod.GET)
	public ModelAndView manageGenres(@RequestParam(name="operation", required=false) String o) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageGenres", true);
		mv.addObject("title", "Manage Genres");
		Genre g = new Genre();
		mv.addObject("genre", g);
		if (o!=null) 
			if (o.equals("genre"))
				mv.addObject("message", "Genre Submitted Successfully!");

		if(udao.loggedUser().equals("null") || udao.loggedUserRole().equals("USER")) {
			mv.addObject("logged", udao.loggedUser());
			return new ModelAndView("redirect:/home");
		}
		else {
			User u = udao.get(udao.loggedUser());
			mv.addObject("logged", u.getName());
		}
		mv.addObject("role", udao.loggedUserRole());
		
		return mv;
	}
	@RequestMapping(value="/genres", method=RequestMethod.POST)
	public String handleNewGenre(@Valid @ModelAttribute("genre") Genre g, BindingResult r, Model m, HttpServletRequest req) {
		if(g.getPic().equals("")) new GenreValidator().validate(g, r);
		else if(!g.getFile().getOriginalFilename().equals("")) new GenreValidator().validate(g, r);
		if (r.hasErrors()) {
			m.addAttribute("userClickManageGenres", true);
			m.addAttribute("title", "Manage Genres");
			m.addAttribute("message", "Genre Adddition Failed!!!");

			if(udao.loggedUser().equals("null") || udao.loggedUserRole().equals("USER")) {
				m.addAttribute("logged", udao.loggedUser());
				return "redirect:/home";
			}
			else {
				User u1 = udao.get(udao.loggedUser());
				m.addAttribute("logged", u1.getName());
			}
			m.addAttribute("role", udao.loggedUserRole());
			
			return "page";
		}
		if(g.getPic().equals("")) gdao.add(g);
		else if (gdao.update(g) == false) {
			m.addAttribute("userClickManageGenres", true);
			m.addAttribute("title", "Manage Genres");
			m.addAttribute("message", "Cannot Change the Name of the Genre");
			return "page";
		}
		if (!g.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadPic(req, g.getFile(), g.getPic());
		}
		l.info(g.toString());
		return "redirect:/manage/genres?operation=genre";
	}
	@RequestMapping(value="/genre/{name}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String handleGenreActivation(@PathVariable("name") String name) throws EntityNotFoundException {
		if (gdao.get(name) == null) throw new EntityNotFoundException("Unspecified Genre...");
		Genre g = gdao.get(name);
		boolean active = g.isActive();
		g.setActive(!active);
		gdao.update(g);
		return active ? name + " Was successfully Phased Out!" : name + " Was successfully Phased In!" ;
	}
	@RequestMapping(value="/genre/{name}", method=RequestMethod.GET)
	public ModelAndView manageGenre(@PathVariable("name") String name) throws EntityNotFoundException {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageGenres", true);
		mv.addObject("title", "Manage " + name + " Genre");
		if (gdao.get(name) == null) throw new EntityNotFoundException("Unspecified Genre...");
		Genre g = gdao.get(name);
		mv.addObject("genre", g);

		if(udao.loggedUser().equals("null") || udao.loggedUserRole().equals("USER")) {
			mv.addObject("logged", udao.loggedUser());
			return new ModelAndView("redirect:/home");
		}
		else {
			User u = udao.get(udao.loggedUser());
			mv.addObject("logged", u.getName());
		}
		mv.addObject("role", udao.loggedUserRole());
		
		return mv;
	}
	
	@RequestMapping(value="/{artist}/{album}/songs", method=RequestMethod.GET)
	public ModelAndView manageSongs(@RequestParam(name="operation", required=false) String o, @PathVariable("album") String album, @PathVariable("artist") String artist) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageSongs", true);
		mv.addObject("title", "Manage Songs");
		Song s = new Song();
		mv.addObject("song", s);
		mv.addObject("artist", artist);
		mv.addObject("album", album);
		if (o!=null) 
			if (o.equals("song"))
				mv.addObject("message", "Song Submitted Successfully!");

		if(udao.loggedUser().equals("null") || udao.loggedUserRole().equals("USER")) {
			mv.addObject("logged", udao.loggedUser());
			return new ModelAndView("redirect:/home");
		}
		else {
			User u = udao.get(udao.loggedUser());
			mv.addObject("logged", u.getName());
		}
		mv.addObject("role", udao.loggedUserRole());
		
		return mv;
	}
	@RequestMapping(value="/{artist}/{album}/songs", method=RequestMethod.POST)
	public String handleNewSong(@Valid @ModelAttribute("song") Song s, BindingResult r, Model m, HttpServletRequest req, @PathVariable("album") String album, @PathVariable("artist") String artist) throws EntityNotFoundException {
		if(s.getPreview().equals("")) new SongValidator().validate(s, r);
		else if(!s.getFile().getOriginalFilename().equals("")) new SongValidator().validate(s, r);
		if (r.hasErrors()) {
			m.addAttribute("userClickManageSongs", true);
			m.addAttribute("title", "Manage Songs");
			m.addAttribute("message", "Song Recording Failed!!!");

			if(udao.loggedUser().equals("null") || udao.loggedUserRole().equals("USER")) {
				m.addAttribute("logged", udao.loggedUser());
				return "redirect:/home";
			}
			else {
				User u1 = udao.get(udao.loggedUser());
				m.addAttribute("logged", u1.getName());
			}
			m.addAttribute("role", udao.loggedUserRole());
			
			return "page";
		}
		if(s.getPreview().equals("")) {
			if (albdao.get(artist, album) == null) throw new EntityNotFoundException("Unspecified Album...");
			s.setAlbum(album);
			s.setArtist(artist);
			sdao.add(s);
			List<Song> slist = sdao.listAlbumSongs(album, artist);
			int rate = 0;
			for(Song song : slist) {
				rate += song.getRate();
			}
			rate -= rate * 0.1;
			Album a = albdao.get(artist, album);
			a.setRate(rate);
			albdao.update(a);
		}
		else sdao.update(s);
		if (!s.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadSong(req, s.getFile(), s.getPreview());
		}
		l.info(s.toString());
		return "redirect:/manage/"+ artist +"/"+ album +"/songs?operation=song";
	}
	@RequestMapping(value="/{artist}/{album}/{track}", method=RequestMethod.GET)
	public ModelAndView manageAlbum(@PathVariable("artist") String artist, @PathVariable("album") String album, @PathVariable("track") int track) throws EntityNotFoundException {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageSongs", true);
		mv.addObject("title", "Manage " + artist + " " + album + " " + track + " Song");
		if (sdao.get(artist, album, track) == null) throw new EntityNotFoundException("Unspecified Song...");
		Song s = sdao.get(artist, album, track);
		mv.addObject("song", s);

		if(udao.loggedUser().equals("null") || udao.loggedUserRole().equals("USER")) {
			mv.addObject("logged", udao.loggedUser());
			return new ModelAndView("redirect:/home");
		}
		else {
			User u = udao.get(udao.loggedUser());
			mv.addObject("logged", u.getName());
		}
		mv.addObject("role", udao.loggedUserRole());
		
		return mv;
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public ModelAndView manageSignup(@RequestParam(name="operation", required=false) String o) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickSignup", true);
		mv.addObject("title", "Sign Up!!!");
		User u = new User();
		mv.addObject("user", u);
		if (o!=null) 
			if (o.equals("user"))
				mv.addObject("message", "User Created Successfully!");

		if(udao.loggedUserRole().equals("USER")) {
			mv.addObject("logged", udao.loggedUser());
			return new ModelAndView("redirect:/home");
		}
		else if(udao.loggedUser().equals("null")) mv.addObject("logged", udao.loggedUser());
		else {
			User u1 = udao.get(udao.loggedUser());
			mv.addObject("logged", u1.getName());
		}
		mv.addObject("role", udao.loggedUserRole());
		
		return mv;
	}
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String handleNewSignup(@Valid @ModelAttribute("user") User u, BindingResult r, Model m, HttpServletRequest req) {
		if (r.hasErrors()) {
			m.addAttribute("userClickSignup", true);
			m.addAttribute("title", "Sign Up!!!");
			m.addAttribute("message", "User Creation Failed!!!");
			
			if(udao.loggedUserRole().equals("USER")) {
				m.addAttribute("logged", udao.loggedUser());
				return "redirect:/home";
			}
			else if(udao.loggedUser().equals("null")) m.addAttribute("logged", udao.loggedUser());
			else {
				User u1 = udao.get(udao.loggedUser());
				m.addAttribute("logged", u1.getName());
			}
			m.addAttribute("role", udao.loggedUserRole());
			
			return "page";
		}
		if(udao.loggedUser().equals("null")) u.setRole("USER");
		l.info(u.toString());
		udao.add(u);
		return "redirect:/manage/signup?operation=user";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView manageLogin(@RequestParam(name="operation", required=false) String o) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickLogin", true);
		mv.addObject("title", "Log In");
		User u = new User();
		mv.addObject("user", u);
		if (o!=null) {
			User c = udao.get(o);
			c.setEnabled(true);
			udao.update(c);
			mv.addObject("message", c.getName() + " Logged in Successfully");
		}

		if(udao.loggedUserRole().equals("USER")||udao.loggedUserRole().equals("ADMIN")) {
			mv.addObject("logged", udao.loggedUser());
			return new ModelAndView("redirect:/home");
		}
		else if(udao.loggedUser().equals("null")) mv.addObject("logged", udao.loggedUser());
		else {
			User u1 = udao.get(udao.loggedUser());
			mv.addObject("logged", u1.getName());
		}
		mv.addObject("role", udao.loggedUserRole());
		
		return mv;
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String handleNewLogin(@Valid @ModelAttribute("user") User u, BindingResult r, Model m, HttpServletRequest req) {
		if(!u.getEmail().equals("")) {
			User c = udao.get(u.getEmail());
			if(u.getPassword().equals(c.getPassword()))	return "redirect:/manage/login?operation=" + u.getEmail();
			else {
				m.addAttribute("userClickLogin", true);
				m.addAttribute("title", "Log In");
				m.addAttribute("message", "Username or Password is Incorrect");
				
				if(udao.loggedUserRole().equals("USER")) {
					m.addAttribute("logged", udao.loggedUser());
					return "redirect:/home";
				}
				else if(udao.loggedUser().equals("null")) m.addAttribute("logged", udao.loggedUser());
				else {
					User u1 = udao.get(udao.loggedUser());
					m.addAttribute("logged", u1.getName());
				}
				m.addAttribute("role", udao.loggedUserRole());
				
				return "page";
			}
		}
		else {
			m.addAttribute("userClickLogin", true);
			m.addAttribute("title", "Log In");
			m.addAttribute("message", "Incorrect Login Credentials");
			
			if(udao.loggedUserRole().equals("USER")) {
				m.addAttribute("logged", udao.loggedUser());
				return "redirect:/home";
			}
			else if(udao.loggedUser().equals("null")) m.addAttribute("logged", udao.loggedUser());
			else {
				User u1 = udao.get(udao.loggedUser());
				m.addAttribute("logged", u1.getName());
			}
			m.addAttribute("role", udao.loggedUserRole());
			
			return "page";
		}
	}
}
