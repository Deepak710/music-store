package DMB.PRJ.MusicBack.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import DMB.PRJ.MusicBack.dao.ArtistDAO;
import DMB.PRJ.MusicBack.dto.Artist;

public class ArtistTestCase {
	private static AnnotationConfigApplicationContext c;
	private static ArtistDAO artdao;
	private static Artist a;
	@BeforeClass
	public static void init() {
		c=new AnnotationConfigApplicationContext();
		c.scan("DMB.PRJ.MusicBack");
		c.refresh();
		artdao=(ArtistDAO)c.getBean("artdao");
	}
//	@Test
//	public void testAddArtist() {
//		a=new Artist();
//		a.setName("Eminem");
//		a.setBio("bleep");
//		assertEquals("Error inserting an artist",true,artdao.add(a));
//	}
//	@Test 
//	public void testGetArtist() {
//		a=artdao.get("Eminem");
//		assertEquals("Error while fetching a single Artist","artist-eminem.jpg",a.getPic());
//	}
//	@Test
//	public void testUpdateArtist() {
//		a=artdao.get("Eminem");
//		g.setDescription("bloop");
//		assertEquals("Error while updating a single Artist",true,artdao.update(a));
//	}
//	@Test
//	public void testDeleteArtist() {
//		a=artdao.get("Eminem");
//		assertEquals("Error while deleting a single Artist",true,artdao.delete(a));
//	}
//	@Test
//	public void testListArtist() {
//		assertEquals("Error while fetching List of Artists",1,artdao.list().size()); //because there is only artist and it is active. Change number to as many active artists in the table
//	}
//	@Test
//	public void testCRUDArtist() {
//		a=new Artist();
//		a.setName("Eminem");
//		a.setBio("bleep");
//		assertEquals("Error while adding Artist",true,artdao.add(a));
//		a=artdao.get("Eminem");
//		a.setBio("bloop");
//		assertEquals("Error while updating a single Artist",true,artdao.update(a));
//		assertEquals("Error while fetching List of Artists",1,artdao.list().size());
//		assertEquals("Error while deleting a single Artist",true,artdao.delete(a));
//	}
}
