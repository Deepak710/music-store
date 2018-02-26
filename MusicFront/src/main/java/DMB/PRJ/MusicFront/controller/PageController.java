package DMB.PRJ.MusicFront.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import DMB.PRJ.MusicBack.dao.CartDAO;
import DMB.PRJ.MusicBack.dao.GenreDAO;
import DMB.PRJ.MusicBack.dao.SongDAO;
import DMB.PRJ.MusicBack.dao.UserDAO;
import DMB.PRJ.MusicBack.dto.Album;
import DMB.PRJ.MusicBack.dto.Artist;
import DMB.PRJ.MusicBack.dto.Cart;
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
	@Autowired
	private CartDAO cdao;
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
		
		mv.addObject("trendingalbumpic", albdao.trendingAlbumPic());
		mv.addObject("trendingalbum", albdao.trendingAlbumArtist() + "\'s " + albdao.trendingAlbumName());
		mv.addObject("trendingalbumlink", "view/" + albdao.trendingAlbumArtist() + "/" + albdao.trendingAlbumName());
		mv.addObject("latestalbumpic", albdao.latestAlbumPic());
		mv.addObject("latestalbum", albdao.latestAlbumArtist() + "\'s " + albdao.latestAlbumName());
		mv.addObject("latestalbumlink", "view/" + albdao.latestAlbumArtist() + "/" + albdao.latestAlbumName());
		mv.addObject("trendingsongpic", "album-" + sdao.trendingSongAlbum().toLowerCase() + "-" + sdao.trendingSongArtist().toLowerCase() + ".jpg");
		mv.addObject("trendingsong", sdao.trendingSongNumber() + ". " + sdao.trendingSongName() + " from " + sdao.trendingSongArtist() + "\'s " + sdao.trendingSongAlbum());
		mv.addObject("trendingsonglink", "view/" + sdao.trendingSongArtist() + "/" + sdao.trendingSongAlbum());
		mv.addObject("latestsongpic", "album-" + sdao.latestSongAlbum().toLowerCase() + "-" + sdao.latestSongArtist().toLowerCase() + ".jpg");
		mv.addObject("latestsong", sdao.latestSongNumber() + ". " + sdao.latestSongName() + " from " + sdao.latestSongArtist() + "\'s " + sdao.latestSongAlbum());
		mv.addObject("latestsonglink", "view/" + sdao.latestSongArtist() + "/" + sdao.latestSongAlbum());
		mv.addObject("topartistpic", artdao.topArtistPic());
		mv.addObject("topartist", artdao.topArtist());
		mv.addObject("topartistlink", "artist/" + artdao.topArtist() + "/album");
		mv.addObject("topgenrepic", gdao.topGenrePic());
		mv.addObject("topgenre", gdao.topGenre());
		mv.addObject("topgenrelink", "genre/" + gdao.topGenre() + "/album");
		
		
		return mv;
	}
	@RequestMapping(value = {"/signout"})
	public ModelAndView signout() {
		ModelAndView mv = new ModelAndView("redirect:/home");
		mv.addObject("userClickHome", true);
		
		if(udao.loggedUser().equals("null")) {
			mv.addObject("logged", udao.loggedUser());
			return mv;
		}
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
	
	@RequestMapping(value="/cart")
	public ModelAndView cart() {
		l.info("Inside Cart Page; PageController.java cart() method - INFO");
		l.debug("Inside Cart Page; PageController.java cart() method - DEBUG");
		ModelAndView mv=new ModelAndView("page");
		if(udao.loggedUser().equals("null")) {
			mv.addObject("logged", udao.loggedUser());
			return new ModelAndView("redirect:/home");
		}
		else {
			User u = udao.get(udao.loggedUser());
			mv.addObject("logged", u.getName());
			mv.addObject("email", u.getEmail());
			mv.addObject("title", u.getName() + " Cart");
			mv.addObject("name", u.getName());
		}
		mv.addObject("role", udao.loggedUserRole());
		mv.addObject("userClickCart", true);
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
		mv.addObject("title", artist + " - " + album);
		mv.addObject("album", alb);
		mv.addObject("rate", alb.getRate());
		mv.addObject("userClickAlbum", true);

		if(udao.loggedUser().equals("null")) mv.addObject("logged", udao.loggedUser());
		else {
			User u = udao.get(udao.loggedUser());
			mv.addObject("logged", u.getName());
		}
		mv.addObject("role", udao.loggedUserRole());
		
		return mv;
	}
	@RequestMapping(value="/add/{artist}/{album}")
	public ModelAndView cartAlbum(@PathVariable("artist") String artist, @PathVariable("album") String album) throws EntityNotFoundException {
		ModelAndView mv=new ModelAndView("redirect:/view/" + artist + "/" + album);
		mv.addObject("userClickAlbum", true);

		if(udao.loggedUser().equals("null")) {
			mv.addObject("logged", udao.loggedUser());
			return mv;
		}
		else {
			User u = udao.get(udao.loggedUser());
			mv.addObject("logged", u.getName());
			Cart c = new Cart();
			c.setEmail(u.getEmail());
			c.setPath(artist + "/" + album);
			if (albdao.get(artist, album) == null) throw new EntityNotFoundException("Unspecified Album Parameters...");
			c.setTotal(albdao.get(artist, album).getRate());
			cdao.add(c);
		}
		mv.addObject("role", udao.loggedUserRole());
		
		return mv;
	}
	@RequestMapping(value="/add/{artist}/{album}/{track}")
	public ModelAndView cartSong(@PathVariable("artist") String artist, @PathVariable("album") String album, @PathVariable("track") int track) throws EntityNotFoundException {
		ModelAndView mv=new ModelAndView("redirect:/view/" + artist + "/" + album);
		mv.addObject("userClickAlbum", true);

		if(udao.loggedUser().equals("null")) {
			mv.addObject("logged", udao.loggedUser());
			return mv;
		}
		else {
			User u = udao.get(udao.loggedUser());
			mv.addObject("logged", u.getName());
			Cart c = new Cart();
			c.setEmail(u.getEmail());
			c.setPath(artist + "/" + album + "/" + track);
			if (sdao.get(artist, album, track) == null) throw new EntityNotFoundException("Unspecified Song Parameters...");
			c.setTotal(sdao.get(artist, album, track).getRate());
			cdao.add(c);
		}
		mv.addObject("role", udao.loggedUserRole());
		
		return mv;
	}
	@RequestMapping(value="/buy/{artist}/{album}")
	public ModelAndView buyAlbum(@PathVariable("artist") String artist, @PathVariable("album") String album) throws EntityNotFoundException {
		ModelAndView mv=new ModelAndView("redirect:/cart");
		mv.addObject("userClickCart", true);
		if(udao.loggedUser().equals("null")) {
			mv.addObject("logged", udao.loggedUser());
			return new ModelAndView("redirect:/view/" + artist + "/" + album);
		}
		else {
			User u = udao.get(udao.loggedUser());
			mv.addObject("logged", u.getName());
			Cart c = cdao.get(u.getEmail(), artist + "/" + album);
			c.setActive(false);
			if (albdao.get(artist, album) == null) throw new EntityNotFoundException("Unspecified Album Parameters...");
			List<Song> slist = sdao.listAlbumSongs(album, artist);
			for(Song s : slist) {
				s.setBought(s.getBought()+1);
				sdao.update(s);
			}
			c.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			c.setTotal(albdao.get(artist, album).getRate());
			cdao.update(c);
		}
		mv.addObject("role", udao.loggedUserRole());
		return mv;
	}
	@RequestMapping(value="/buy/all/albums")
	public ModelAndView buyAllAlbums() {
		ModelAndView mv=new ModelAndView("redirect:/cart");
		mv.addObject("userClickCart", true);
		if(udao.loggedUser().equals("null")) {
			mv.addObject("logged", udao.loggedUser());
			return new ModelAndView("redirect:/home");
		}
		else {
			User u = udao.get(udao.loggedUser());
			mv.addObject("logged", u.getName());
			List<Cart> clist = cdao.listAlbums(u.getEmail()); 
			for(Cart c:clist) {
				c.setActive(false);
				String [] strList = c.getPath().split("/");
				List<Song> slist = sdao.listAlbumSongs(strList[0], strList[1]);
				for(Song s : slist) {
					s.setBought(s.getBought()+1);
					sdao.update(s);
				}
				c.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
				c.setTotal(albdao.get(strList[0], strList[1]).getRate());
				cdao.update(c);
			}
		}
		mv.addObject("role", udao.loggedUserRole());
		return mv;
	}
	@RequestMapping(value="/remove/{artist}/{album}")
	public ModelAndView removeAlbum(@PathVariable("artist") String artist, @PathVariable("album") String album) throws EntityNotFoundException {
		ModelAndView mv=new ModelAndView("redirect:/cart");
		mv.addObject("userClickCart", true);
		if(udao.loggedUser().equals("null")) {
			mv.addObject("logged", udao.loggedUser());
			return new ModelAndView("redirect:/view/" + artist + "/" + album);
		}
		else {
			User u = udao.get(udao.loggedUser());
			mv.addObject("logged", u.getName());
			if (albdao.get(artist, album) == null) throw new EntityNotFoundException("Unspecified Album Parameters...");
			Cart c = cdao.get(u.getEmail(), artist + "/" + album);
			cdao.delete(c);
		}
		mv.addObject("role", udao.loggedUserRole());
		return mv;
	}
	@RequestMapping(value="/remove/all/albums")
	public ModelAndView removeAllAlbums() {
		ModelAndView mv=new ModelAndView("redirect:/cart");
		mv.addObject("userClickCart", true);
		if(udao.loggedUser().equals("null")) {
			mv.addObject("logged", udao.loggedUser());
			return new ModelAndView("redirect:/home");
		}
		else {
			User u = udao.get(udao.loggedUser());
			mv.addObject("logged", u.getName());
			List<Cart> clist = cdao.listAlbums(u.getEmail()); 
			for(Cart c:clist) cdao.delete(c);
		}
		mv.addObject("role", udao.loggedUserRole());
		return mv;
	}
	@RequestMapping(value="/buy/{artist}/{album}/{track}")
	public ModelAndView buySong(@PathVariable("artist") String artist, @PathVariable("album") String album, @PathVariable("track") int track) throws EntityNotFoundException {
		ModelAndView mv=new ModelAndView("redirect:/cart");
		mv.addObject("userClickCart", true);
		if(udao.loggedUser().equals("null")) {
			mv.addObject("logged", udao.loggedUser());
			new ModelAndView("redirect:/view/" + artist + "/" + album);
		}
		else {
			User u = udao.get(udao.loggedUser());
			mv.addObject("logged", u.getName());
			Cart c = cdao.get(u.getEmail(), artist + "/" + album + "/" + track);
			Song s = sdao.get(artist, album, track);
			s.setBought(s.getBought()+1);
			sdao.update(s);
			c.setActive(false);
			c.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			if (sdao.get(artist, album, track) == null) throw new EntityNotFoundException("Unspecified Song Parameters...");
			c.setTotal(sdao.get(artist, album, track).getRate());
			cdao.update(c);
		}
		mv.addObject("role", udao.loggedUserRole());
		return mv;
	}
	@RequestMapping(value="/buy/all/songs")
	public ModelAndView buyAllSongs() {
		ModelAndView mv=new ModelAndView("redirect:/cart");
		mv.addObject("userClickCart", true);
		if(udao.loggedUser().equals("null")) {
			mv.addObject("logged", udao.loggedUser());
			return new ModelAndView("redirect:/home");
		}
		else {
			User u = udao.get(udao.loggedUser());
			mv.addObject("logged", u.getName());
			List<Cart> clist = cdao.listSongs(u.getEmail()); 
			for(Cart c:clist) {
				String [] strList = c.getPath().split("/");
				Song s = sdao.get(strList[0], strList[1], Integer.parseInt(strList[2]));
				s.setBought(s.getBought()+1);
				sdao.update(s);
				c.setActive(false);
				c.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
				c.setTotal(sdao.get(strList[0], strList[1], Integer.parseInt(strList[2])).getRate());
				cdao.update(c);
			}
		}
		mv.addObject("role", udao.loggedUserRole());
		return mv;
	}
	@RequestMapping(value="/remove/{artist}/{album}/{track}")
	public ModelAndView removeSong(@PathVariable("artist") String artist, @PathVariable("album") String album, @PathVariable("track") int track) throws EntityNotFoundException {
		ModelAndView mv=new ModelAndView("redirect:/cart");
		mv.addObject("userClickCart", true);
		if(udao.loggedUser().equals("null")) {
			mv.addObject("logged", udao.loggedUser());
			return new ModelAndView("redirect:/view/" + artist + "/" + album);
		}
		else {
			User u = udao.get(udao.loggedUser());
			mv.addObject("logged", u.getName());
			if (sdao.get(artist, album, track) == null) throw new EntityNotFoundException("Unspecified Song Parameters...");
			Cart c = cdao.get(u.getEmail(), artist + "/" + album + "/" + track);
			cdao.delete(c);
		}
		mv.addObject("role", udao.loggedUserRole());
		return mv;
	}
	@RequestMapping(value="/remove/all/songs")
	public ModelAndView removeAllSongs() {
		ModelAndView mv=new ModelAndView("redirect:/cart");
		mv.addObject("userClickCart", true);
		if(udao.loggedUser().equals("null")) {
			mv.addObject("logged", udao.loggedUser());
			return new ModelAndView("redirect:/home");
		}
		else {
			User u = udao.get(udao.loggedUser());
			mv.addObject("logged", u.getName());
			List<Cart> clist = cdao.listSongs(u.getEmail()); 
			for(Cart c:clist) cdao.delete(c);
		}
		mv.addObject("role", udao.loggedUserRole());
		return mv;
	}
}