package DMB.PRJ.MusicBack.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import DMB.PRJ.MusicBack.dao.SongDAO;
import DMB.PRJ.MusicBack.dto.Song;

public class SongTestCase {
	private static AnnotationConfigApplicationContext c;
	private static SongDAO sdao;
	private static Song s;
	@BeforeClass
	public static void init() {
		c=new AnnotationConfigApplicationContext();
		c.scan("DMB.PRJ.MusicBack");
		c.refresh();
		sdao=(SongDAO)c.getBean("sdao");
	}
//	@Test
//	public void testCRUDSong() {
//		s = new Song();
//		s.setName("Love The Way You Lie");
//		s.setAlbum("Relapse");
//		s.setArtist("Eminem");
//		s.setRate(10);
//		s.setRating(5);
//		assertEquals("Error while adding Song",true,sdao.add(s));
//	}
}
