package dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.query.Query;
import org.hibernate.Session;

import context.HibernateUtil;
import entity.Inforaccount;

public class DaoDeTai {
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
	
	public Inforaccount getNameByID(String HQL, String id) {
		Inforaccount acc = new Inforaccount();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {


			acc =  session.get(Inforaccount.class, id);
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return acc;
	}
	
	public List<Object[]> getChiTietDetai(String HQL, int id) {
		List<Object[]> kq = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query query = session.createNativeQuery(HQL);
			query.setParameter("id", id);
			kq = query.getResultList();
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return kq;
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
