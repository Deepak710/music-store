package DMB.PRJ.MusicBack.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import DMB.PRJ.MusicBack.dao.AlbumDAO;
import DMB.PRJ.MusicBack.dto.Album;

public class AlbumTestCase {
	private static AnnotationConfigApplicationContext c;
	private static AlbumDAO albdao;
	private static Album a;
	@BeforeClass
	public static void init() {
		c=new AnnotationConfigApplicationContext();
		c.scan("DMB.PRJ.MusicBack");
		c.refresh();
		albdao=(AlbumDAO)c.getBean("albdao");
	}
//	@Test
//	public void testCRUDAlbum() {
//		a=new Album();
//		a.setName("Recovery");
//		a.setArtist("Eminem");
//		a.setGenre("Jazz");
//		a.setLang("English");
//		assertEquals("Error while adding Artist",true,albdao.add(a));
//		a=albdao.get("Recovery");
//		a.setLang("bloop");
//		assertEquals("Error while updating a single Artist",true,albdao.update(a));
//		assertEquals("Error while fetching List of Artists",1,albdao.listAllAlbums().size());
//		assertEquals("Error while deleting a single Artist",true,albdao.delete(a));
//	}
}
