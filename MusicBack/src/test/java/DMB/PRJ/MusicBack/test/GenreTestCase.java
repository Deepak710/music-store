package DMB.PRJ.MusicBack.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import DMB.PRJ.MusicBack.dao.GenreDAO;
import DMB.PRJ.MusicBack.dto.Genre;

public class GenreTestCase {
	private static AnnotationConfigApplicationContext c;
	private static GenreDAO gdao;
	private Genre g; 
	@BeforeClass
	public static void init() {
		c=new AnnotationConfigApplicationContext();
		c.scan("DMB.PRJ.MusicBack");
		c.refresh();
		gdao=(GenreDAO)c.getBean("gdao");
	}
//	@Test
//	public void testAddGenre() {
//		g=new Genre();
//		g.setName("Jazz");
//		g.setDescription("blah");
//		assertEquals("Error while adding Genre",true,gdao.add(g));
//	}
//	@Test 
//	public void testGetGenre() {
//		g=gdao.get("Jazz");
//		assertEquals("Error while fetching a single Genre","genre-jazz.jpg",g.getPic());
//	}
//	@Test
//	public void testUpdateGenre() {
//		g=gdao.get("Jazz");
//		g.setDescription("bloop");
//		assertEquals("Error while updating a single Genre",true,gdao.update(g));
//	}
//	@Test
//	public void testDeleteGenre() {
//		g=gdao.get("Jazz");
//		assertEquals("Error while deleting a single Genre",true,gdao.delete(g));
//	}
//	@Test
//	public void testListGenre() {
//		assertEquals("Error while fetching List of Genres",1,gdao.list().size()); //because there is only genre and it is active. Change number to as many active genres in the table
//	}
//	@Test
//	public void testCRUDGenre() {
//		g=new Genre();
//		g.setName("Jazz");
//		g.setDescription("blah");
//		assertEquals("Error while adding Genre",true,gdao.add(g));
//		g=gdao.get("Jazz");
//		g.setDescription("bloop");
//		assertEquals("Error while updating a single Genre",true,gdao.update(g));
//		assertEquals("Error while fetching List of Genres",1,gdao.list().size());
//		assertEquals("Error while deleting a single Genre",true,gdao.delete(g));
//	}
}
