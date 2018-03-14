package DMB.PRJ.MusicBack.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import DMB.PRJ.MusicBack.dao.CartDAO;
import DMB.PRJ.MusicBack.dto.Cart;

@Repository("cdao")
@Transactional
public class CartDAOImpl implements CartDAO {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public boolean add(Cart c) {
		try {
			sf.getCurrentSession().persist(c);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Cart> listBoughtSongs(String email) {
		String select = "FROM Cart WHERE email = :email AND active = :active";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("email", email);
		q.setParameter("active", false);
		List<Cart> cl = q.getResultList();
		List<Cart> clist = q.getResultList();
		clist.clear();
		for(Cart c:cl)
			if (c.getPath().split("/").length - 1 == 2)
				clist.add(c);
		return clist;
	}

	@Override
	public List<Cart> listBoughtAlbums(String email) {
		String select = "FROM Cart WHERE email = :email AND active = :active";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("email", email);
		q.setParameter("active", false);
		List<Cart> cl = q.getResultList();
		List<Cart> clist = q.getResultList();
		clist.clear();
		for(Cart c:cl)
			if (c.getPath().split("/").length - 1 == 1)
				clist.add(c);
		return clist;
	}

	@Override
	public List<Cart> listSongs(String email) {
		String select = "FROM Cart WHERE email = :email AND active = :active";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("email", email);
		q.setParameter("active", true);
		List<Cart> cl = q.getResultList();
		List<Cart> clist = q.getResultList();
		clist.clear();
		for(Cart c:cl)
			if (c.getPath().split("/").length - 1 == 2)
				clist.add(c);
		return clist;
	}

	@Override
	public List<Cart> listAlbums(String email) {
		String select = "FROM Cart WHERE email = :email AND active = :active";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("email", email);
		q.setParameter("active", true);
		List<Cart> cl = q.getResultList();
		List<Cart> clist = q.getResultList();
		clist.clear();
		for(Cart c:cl)
			if (c.getPath().split("/").length - 1 == 1)
				clist.add(c);
		return clist;
	}

	@Override
	public Cart get(String email, String path) {
		String select = "FROM Cart WHERE email = :email AND path = :path";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("email", email);
		q.setParameter("path", path);
		return (Cart)q.getSingleResult();
	}

	@Override
	public boolean update(Cart c) {
		try {
			sf.getCurrentSession().update(c);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Cart c) {
		try {
			sf.getCurrentSession().delete(c);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Cart getActive(String email, String path) {
		String select = "FROM Cart WHERE email = :email AND path = :path AND active = :active";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("email", email);
		q.setParameter("path", path);
		q.setParameter("active", true);
		return (Cart)q.getSingleResult();
	}

	@Override
	public int priceTill(String datefrom, String dateto) {
		String select = "FROM Cart WHERE date > :datefrom AND date < :dateto AND active = :active";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("datefrom", datefrom);
		q.setParameter("dateto", dateto);
		q.setParameter("active", false);
		int rate = 0;
		List<Cart> clist = q.getResultList();
		for(Cart c:clist)
			rate += c.getTotal();
		return rate;
	}

}
