package kr.nextree.edu.hib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

public class UserProviderTest {
	public static void main( String[] args )
	    {

	SessionFactory sessionFactory = HibernateUtil.getsessionFactory();
	User user = new User();
	user.setTitle("스프링 웹 프로젝트 팝니다.");
	user.setContent("Terry");
	user.setWriter("Cho");
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	session.save(user);
	session.getTransaction().commit();

	System.out.println("Insert completed");
	
	session.close();
	sessionFactory.close();
	    }
}
