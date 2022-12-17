package dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import context.HibernateUtil;
import entity.Inforaccount;

public class DaoInforaccount extends IDAO<Inforaccount>{
	@Override
	public Inforaccount findSingle(Class<Inforaccount> type, Object key) {
		// TODO Auto-generated method stub
		return super.findSingle(type, key);
	}
	public List<Inforaccount> getAll() {
	      List<Inforaccount> users = null;
	      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Inforaccount> criteriaQuery = builder.createQuery(Inforaccount.class);
	         criteriaQuery.from(Inforaccount.class);
	         users = session.createQuery(criteriaQuery).getResultList();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return users;
	   }
	public void delete(String username) {
	      Transaction transaction = null;
	      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	         transaction = session.beginTransaction();

	         Inforaccount cart = session.get(Inforaccount.class, username);
	         if (cart != null) {
	            session.delete(cart);
	         }

	         transaction.commit();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	   }
}
