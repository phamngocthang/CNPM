package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.query.Query;
import org.hibernate.Session;

import context.HibernateUtil;
import entity.DeTai;
import entity.Inforaccount;

public class DaoDeTai extends IDAO<DeTai>{
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
	
	@Override
	public int count(String queryName) {
		// TODO Auto-generated method stub
		return super.count(queryName);
	}
	
	public int getamountDTByCN(String HQL) {
		return count(HQL);
	}
	
	@Override
	public List<DeTai> findAllLimit(String queryString, int offset, int amount) {
		// TODO Auto-generated method stub
		return super.findAllLimit(queryString, offset, amount);
	}
	@Override
	public DeTai findSingle(Class<DeTai> type, Object key) {
		// TODO Auto-generated method stub
		return super.findSingle(type, key);
	}
}
