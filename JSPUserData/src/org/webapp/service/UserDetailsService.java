package org.webapp.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.webapp.data.Gender;
import org.webapp.data.UserDetails;

public class UserDetailsService {
	public static void createUserDetails(String username, Gender sex, int age, boolean active, String tags ) {
		UserDetails user = new UserDetails(username, sex, age, active, tags);
		
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns = session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			if (trns != null) {
				trns.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		
	}
}
