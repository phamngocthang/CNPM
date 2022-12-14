package dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import context.HibernateUtil;
import entity.Account;

public class DaoUser{

//	@Override
//	public Account findSingle(Class<Account> type, Object key) {
//		// TODO Auto-generated method stub
//		return super.findSingle(type, key);
//	}

	public void insert(Account user) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.save(user);

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	public void update(Account user) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.update(user);

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	public void delete(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			Account user = session.get(Account.class, id);
			if (user != null) {
				session.delete(user);
			}

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
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

	public Account get(int id) {
		Account user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			user = session.get(Account.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public Account get(String username) {
		Account user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			user = session.get(Account.class, username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public Account findUserCreated(String username) {
		Account user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			user = session.get(Account.class, username);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
