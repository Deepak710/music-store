package DMB.PRJ.MusicFront.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import DMB.PRJ.MusicBack.dao.AlbumDAO;
import DMB.PRJ.MusicBack.dao.ArtistDAO;
import DMB.PRJ.MusicBack.dao.GenreDAO;
import DMB.PRJ.MusicBack.dao.SongDAO;
import DMB.PRJ.MusicBack.dto.Album;
import DMB.PRJ.MusicBack.dto.Artist;
import DMB.PRJ.MusicBack.dto.Genre;
import DMB.PRJ.MusicBack.dto.Song;

@Controller
@RequestMapping("/json/data")
public class JSONDataController {
	@Autowired
	private AlbumDAO albdao;
	@Autowired
	private ArtistDAO artdao;
	@Autowired
	private GenreDAO gdao;
	@Autowired
	private SongDAO sdao;
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
}
