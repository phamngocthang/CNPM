package dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import context.HibernateUtil;
import entity.ChuyenNganh;

public class DaoChuyenNganh {

	public List<ChuyenNganh> getAll() {
	      List<ChuyenNganh> users = null;
	      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<ChuyenNganh> criteriaQuery = builder.createQuery(ChuyenNganh.class);
	         criteriaQuery.from(ChuyenNganh.class);
	         users = session.createQuery(criteriaQuery).getResultList();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return users;
	   }
}
