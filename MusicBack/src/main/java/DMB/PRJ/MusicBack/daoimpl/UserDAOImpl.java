package DMB.PRJ.MusicBack.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import DMB.PRJ.MusicBack.dao.UserDAO;
import DMB.PRJ.MusicBack.dto.Cart;
import DMB.PRJ.MusicBack.dto.User;

@Repository("udao")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<User> list() {
		String select = "FROM User";
		Query q = sf.getCurrentSession().createQuery(select);
		return q.getResultList();
	}

	@Override
	public User get(String email) {
		String select = "FROM User WHERE email = :email";
		Query q = sf.getCurrentSession().createQuery(select);
		q.setParameter("email", email);
		return (User)q.getSingleResult();
	}

	@Override
	public boolean add(User u) {
		try {
			sf.getCurrentSession().persist(u);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(User u) {
		try {
			sf.getCurrentSession().update(u);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCart(Cart c) {
		try {
			sf.getCurrentSession().update(c);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
