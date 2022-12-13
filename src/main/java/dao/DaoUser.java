package dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;


import context.HibernateUtil;
import entity.Account;

public class DaoUser extends IDAO<Account> {
   
   
   @Override
	public Account findSingle(Class<Account> type, Object key) {
		// TODO Auto-generated method stub
		return super.findSingle(type, key);
	}
}
