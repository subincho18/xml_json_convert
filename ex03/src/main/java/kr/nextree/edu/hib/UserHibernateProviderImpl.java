package kr.nextree.edu.hib;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserHibernateProviderImpl implements UserProvider {
	public void insertUser(User user) {
		Session session = HibernateUtil.getsessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		session.persist(user);
		
		tx.commit();
		session.close();
	}

	public User findUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public User updateUser(String userId, String updateName) {
		// TODO Auto-generated method stub
		return null;
	}
}
