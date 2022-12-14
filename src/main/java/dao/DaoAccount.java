package dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import context.HibernateUtil;
import entity.Account;
import entity.Inforaccount;

public class DaoAccount {
	public void insert(Inforaccount account) {
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

	public void update(Inforaccount account) {
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

			Inforaccount account = session.get(Inforaccount.class, username);
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

	public List<Inforaccount> getAll() {
		List<Inforaccount> accounts = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Inforaccount> criteriaQuery = builder.createQuery(Inforaccount.class);
			criteriaQuery.from(Inforaccount.class);
			accounts = session.createQuery(criteriaQuery).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accounts;
	}

	public Inforaccount get(int id) {
		Inforaccount account = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			account = session.get(Inforaccount.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}

	public Inforaccount get(String username) {
		Inforaccount account = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			account = session.get(Inforaccount.class, username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}

	public Inforaccount findUserCreated(String username) {
		Inforaccount account = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			account = session.get(Inforaccount.class, username);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}
}
