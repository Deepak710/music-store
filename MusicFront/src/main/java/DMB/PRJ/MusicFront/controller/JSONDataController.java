package DMB.PRJ.MusicFront.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import DMB.PRJ.MusicBack.dao.AlbumDAO;
import DMB.PRJ.MusicBack.dao.ArtistDAO;
import DMB.PRJ.MusicBack.dao.CartDAO;
import DMB.PRJ.MusicBack.dao.GenreDAO;
import DMB.PRJ.MusicBack.dao.SongDAO;
import DMB.PRJ.MusicBack.dto.Album;
import DMB.PRJ.MusicBack.dto.Artist;
import DMB.PRJ.MusicBack.dto.Cart;
import DMB.PRJ.MusicBack.dto.Genre;
import DMB.PRJ.MusicBack.dto.Song;

@Controller
@RequestMapping("/json/data")
public class JSONDataController {
	
	private static final Logger l = LoggerFactory.getLogger(JSONDataController.class);
	
	@Autowired
	private AlbumDAO albdao;
	@Autowired
	private ArtistDAO artdao;
	@Autowired
	private GenreDAO gdao;
	@Autowired
	private SongDAO sdao;
	@Autowired
	private CartDAO cdao;
	@RequestMapping("/all/album")
	@ResponseBody
	public List<Album> getAllAlbums() {
		List<Album> alist = albdao.listActiveAlbums();
		alist.clear();
		for (Album a: albdao.listActiveAlbums()) {
			Artist art = artdao.get(a.getArtist());
			Genre g = gdao.get(a.getGenre());
			if (art.isActive() && g.isActive())
				alist.add(a);
		}
		return alist;
	}
	@RequestMapping("/language/{name}/album")
	@ResponseBody
	public List<Album> getLanguageAlbums(@PathVariable String name) {
		List<Album> alist = albdao.listLangAlbums(name);
		alist.clear();
		for (Album a: albdao.listLangAlbums(name)) {
			Artist art = artdao.get(a.getArtist());
			Genre g = gdao.get(a.getGenre());
			if (art.isActive() && g.isActive())
				alist.add(a);
		}
		return alist;
	}
	@RequestMapping("/genre/{name}/album")
	@ResponseBody
	public List<Album> getGenreAlbums(@PathVariable String name) {
		List<Album> alist = albdao.listGenreAlbums(name);
		alist.clear();
		for (Album a: albdao.listGenreAlbums(name)) {
			Artist art = artdao.get(a.getArtist());
			Genre g = gdao.get(a.getGenre());
			if (art.isActive() && g.isActive())
				alist.add(a);
		}
		return alist;
	}
	@RequestMapping("/artist/{name}/album")
	@ResponseBody
	public List<Album> getArtistAlbums(@PathVariable String name) {
		List<Album> alist = albdao.listArtistAlbums(name);
		alist.clear();
		for (Album a: albdao.listArtistAlbums(name)) {
			Artist art = artdao.get(a.getArtist());
			Genre g = gdao.get(a.getGenre());
			if (art.isActive() && g.isActive())
				alist.add(a);
		}
		return alist;
	}
	@RequestMapping("/view/{artist}/{album}")
	@ResponseBody
	public List<Song> getAlbumSongs(@PathVariable("artist") String artist, @PathVariable("album") String album) {
		return sdao.listAlbumSongs(album, artist);
	}
	@RequestMapping("admin/all/album")
	@ResponseBody
	public List<Album> manageAlbums() {
		return albdao.listAllAlbums();
	}
	@RequestMapping("admin/all/artist")
	@ResponseBody
	public List<Artist> manageArtists() {
		return artdao.listAllArtists();
	}
	@RequestMapping("admin/all/genre")
	@ResponseBody
	public List<Genre> manageGenres() {
		return gdao.listAllGenres();
	}
	@RequestMapping("admin/{artist}/{album}")
	@ResponseBody
	public List<Song> manageAlbumSongs(@PathVariable("artist") String artist, @PathVariable("album") String album) {
		return sdao.listAlbumSongs(album, artist);
	}
	@RequestMapping("{email}/cart/bought/songs")
	@ResponseBody
	public List<Song> manageBoughtSongs(@PathVariable("email") String email) {
		List<Cart> clist = cdao.listBoughtSongs(email);
		List<Song> slist = sdao.listAllSongs();
		slist.clear();
		for(Cart c:clist) {
			String [] strList = c.getPath().split("/");
			Song s = sdao.get(strList[0], strList[1], Integer.parseInt(strList[2]));
			s.setDate(c.getDate());
			s.setRate(c.getTotal());
			slist.add(s);
		}
		return slist;
	}
	@RequestMapping("{email}/cart/bought/albums")
	@ResponseBody
	public List<Album> manageBoughtAlbums(@PathVariable("email") String email) {
		List<Cart> clist = cdao.listBoughtAlbums(email);
		List<Album> alist = albdao.listAllAlbums();
		alist.clear();
		for(Cart c:clist) {
			String [] strList = c.getPath().split("/");
			Album a = albdao.get(strList[0], strList[1]);
			a.setDate(c.getDate());
			a.setRate(c.getTotal());
			alist.add(a);
		}
		return alist;
	}
	@RequestMapping("{email}/cart/songs")
	@ResponseBody
	public List<Song> manageCartSongs(@PathVariable("email") String email) {
		List<Cart> clist =  cdao.listSongs(email);
		List<Song> slist = sdao.listAllSongs();
		slist.clear();
		for(Cart c:clist) {
			String [] strList = c.getPath().split("/");
			Song s = sdao.get(strList[0], strList[1], Integer.parseInt(strList[2]));
			Album a = albdao.get(strList[0], strList[1]);
			if (a.isActive() && artdao.get(a.getArtist()).isActive() && gdao.get(a.getGenre()).isActive())
				slist.add(s);
		}
		return slist;
	}
	@RequestMapping("{email}/cart/albums")
	@ResponseBody
	public List<Album> manageCartAlbums(@PathVariable("email") String email) {
		List<Cart> clist = cdao.listAlbums(email);
		List<Album> alist = albdao.listAllAlbums();
		alist.clear();
		for(Cart c:clist) {
			String [] strList = c.getPath().split("/");
			Album a = albdao.get(strList[0], strList[1]);
			if (a.isActive() && artdao.get(a.getArtist()).isActive() && gdao.get(a.getGenre()).isActive())
				alist.add(a);
		}
		return alist;
	}
	@RequestMapping("{email}/cart/{artist}/{album}")
	@ResponseBody
	public List<Album> manageCheckoutAlbum(@PathVariable("email") String email, @PathVariable("artist") String artist, @PathVariable("album") String album) {
		List<Album> alist = albdao.listAllAlbums();
		alist.clear();
		alist.add(albdao.get(artist, album));
		return alist;
	}
	@RequestMapping("{email}/cart/{artist}/{album}/{track}")
	@ResponseBody
	public List<Song> manageCheckoutSong(@PathVariable("email") String email, @PathVariable("artist") String artist, @PathVariable("album") String album, @PathVariable("track") int track) {
		List<Song> slist = sdao.listAllSongs();
		slist.clear();
		slist.add(sdao.get(artist, album, track));
		return slist;
	}
	class ralb {
		private String path;
		private String pic;
		private boolean active;
		private int monthSale, monthRate, allSale, allRate;
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}
		public String getPic() {
			return pic;
		}
		public void setPic(String pic) {
			this.pic = pic;
		}
		public boolean isActive() {
			return active;
		}
		public void setActive(boolean active) {
			this.active = active;
		}
		public int getMonthSale() {
			return monthSale;
		}
		public void setMonthSale(int monthSale) {
			this.monthSale = monthSale;
		}
		public int getMonthRate() {
			return monthRate;
		}
		public void setMonthRate(int monthRate) {
			this.monthRate = monthRate;
		}
		public int getAllSale() {
			return allSale;
		}
		public void setAllSale(int allSale) {
			this.allSale = allSale;
		}
		public int getAllRate() {
			return allRate;
		}
		public void setAllRate(int allRate) {
			this.allRate = allRate;
		}
		@Override
		public String toString() {
			return "ralb [path=" + path + ", pic=" + pic + ", active=" + active + ", monthSale=" + monthSale
					+ ", monthRate=" + monthRate + ", allSale=" + allSale + ", allRate=" + allRate + "]";
		}
		
	}
	@RequestMapping("report/albums")
	@ResponseBody
	public List<ralb> reportAlbums() {
		List<ralb> rlist = new ArrayList<ralb>();
		rlist.clear();
		List<Album> alist = albdao.listAllAlbums();
		for(Album a : alist) {
			ralb r = new ralb();
			r.setPath(a.getArtist() + "/" + a.getName());
			r.setPic(a.getPic());
			if (a.isActive() && artdao.get(a.getArtist()).isActive() && gdao.get(a.getGenre()).isActive())
				r.setActive(true);
			else r.setActive(false);
			r.setMonthRate(cdao.priceTill(r.getPath(), new SimpleDateFormat("yyyy-MM-dd").format(Date.from(LocalDate.now().plusMonths(-1).atStartOfDay(ZoneId.systemDefault()).toInstant())), new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
			r.setMonthSale(cdao.numberSold(r.getPath(), new SimpleDateFormat("yyyy-MM-dd").format(Date.from(LocalDate.now().plusMonths(-1).atStartOfDay(ZoneId.systemDefault()).toInstant())), new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
			r.setAllRate(cdao.priceTill(r.getPath(), "2018-01-13", new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
			r.setAllSale(cdao.numberSold(r.getPath(), "2018-01-13", new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
			r.setPath(a.getArtist() + " - " + a.getName());
			rlist.add(r);
		}
		return rlist;
	}
	class rsong {
		private String path;
		private String preview;
		private boolean active;
		private int monthSale, monthRate, allSale, allRate;
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}
		public String getPreview() {
			return preview;
		}
		public void setPreview(String preview) {
			this.preview = preview;
		}
		public boolean isActive() {
			return active;
		}
		public void setActive(boolean active) {
			this.active = active;
		}
		public int getMonthSale() {
			return monthSale;
		}
		public void setMonthSale(int monthSale) {
			this.monthSale = monthSale;
		}
		public int getMonthRate() {
			return monthRate;
		}
		public void setMonthRate(int monthRate) {
			this.monthRate = monthRate;
		}
		public int getAllSale() {
			return allSale;
		}
		public void setAllSale(int allSale) {
			this.allSale = allSale;
		}
		public int getAllRate() {
			return allRate;
		}
		public void setAllRate(int allRate) {
			this.allRate = allRate;
		}
		@Override
		public String toString() {
			return "rsong [path=" + path + ", preview=" + preview + ", active=" + active + ", monthSale=" + monthSale
					+ ", monthRate=" + monthRate + ", allSale=" + allSale + ", allRate=" + allRate + "]";
		}
	}
	@RequestMapping("report/songs")
	@ResponseBody
	public List<rsong> reportSongs() {
		List<rsong> rlist = new ArrayList<rsong>();
		rlist.clear();
		List<Song> slist = sdao.listAllSongs();
		for(Song s : slist) {
			rsong r = new rsong();
			r.setPath(s.getArtist() + "/" + s.getAlbum() + "/" + s.getTrack_no());
			r.setPreview(s.getPreview());
			Album a = albdao.get(s.getArtist(), s.getAlbum());
			if (a.isActive() && artdao.get(a.getArtist()).isActive() && gdao.get(a.getGenre()).isActive())
				r.setActive(true);
			else r.setActive(false);
			r.setMonthRate(cdao.priceTill(r.getPath(), new SimpleDateFormat("yyyy-MM-dd").format(Date.from(LocalDate.now().plusMonths(-1).atStartOfDay(ZoneId.systemDefault()).toInstant())), new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
			r.setMonthSale(cdao.numberSold(r.getPath(), new SimpleDateFormat("yyyy-MM-dd").format(Date.from(LocalDate.now().plusMonths(-1).atStartOfDay(ZoneId.systemDefault()).toInstant())), new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
			r.setAllRate(cdao.priceTill(r.getPath(), "2018-01-13", new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
			r.setAllSale(cdao.numberSold(r.getPath(), "2018-01-13", new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
			r.setPath(s.getArtist() + " - " + s.getAlbum() + " - " + s.getTrack_no() + "." + s.getName());
			rlist.add(r);
		}
		return rlist;
	}
}
