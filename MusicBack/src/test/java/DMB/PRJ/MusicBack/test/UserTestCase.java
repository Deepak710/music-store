package DMB.PRJ.MusicBack.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import DMB.PRJ.MusicBack.dao.UserDAO;
import DMB.PRJ.MusicBack.dto.Cart;
import DMB.PRJ.MusicBack.dto.User;

public class UserTestCase {
	private static AnnotationConfigApplicationContext c;
	private static UserDAO udao;
	private static User u;
	private static Cart cart; 
	@BeforeClass
	public static void init() {
		c=new AnnotationConfigApplicationContext();
		c.scan("DMB.PRJ.MusicBack");
		c.refresh();
		udao=(UserDAO)c.getBean("udao");
	}
//	@Test
//	public void test() {
//		u = new User();
//		u.setAddress("123");
//		u.setEmail("a");
//		u.setPassword("b");
//		u.setRole("USER");
//		u.setName("Deepak");
//		u.setPhone(123);
//		assertEquals("Failed to add User", true, udao.add(u));
//		cart = new Cart();
//		cart.setTotal(10);
//		assertEquals("Failed to add Cart", true, udao.addCart(cart));
//	}
	
}
