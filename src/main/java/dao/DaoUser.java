package dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;


import context.HibernateUtil;
import entity.Account;
import entity.Inforaccount;

public class DaoUser extends IDAO<Account> {
   
	@Override
	public Account findSingle(Class<Account> type, Object key) {
		// TODO Auto-generated method stub
		return super.findSingle(type, key);
	}
	public List<Account> getAll() {
	      List<Account> users = null;
	      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Account> criteriaQuery = builder.createQuery(Account.class);
	         criteriaQuery.from(Account.class);
	         users = session.createQuery(criteriaQuery).getResultList();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return users;
	   }
	public void insert(Account account) {
	      Transaction transaction = null;
	      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	         transaction = session.beginTransaction();

	         session.save(account);

	         transaction.commit();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	   }

	   public void update1(Account account) {
	      Transaction transaction = null;
	      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	         transaction = session.beginTransaction();

	         session.update(account);

	         transaction.commit();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	   }

	   public void delete(String username) {
	      Transaction transaction = null;
	      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	         transaction = session.beginTransaction();

	         Account account = session.get(Account.class, username);
	         if (account != null) {
	            session.delete(account);
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
