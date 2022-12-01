package dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.query.Query;
import org.hibernate.Session;

import context.HibernateUtil;

public class daoDetai {
	public List<Object[]> getDetai(String HQL, int offset, int limit) {
		List<Object[]> list = new ArrayList<>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query query = session.createNativeQuery(HQL);

			list = (List<Object[]>)query.setFirstResult(offset).setMaxResults(limit).list();
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public int getamountDTByCN(String HQL) {
		int count = -1;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query query = session.createNativeQuery(HQL);

			count = Integer.parseInt(query.uniqueResult().toString()); 
			
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return count;
	}
}
