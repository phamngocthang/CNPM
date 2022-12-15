package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.query.Query;
import org.hibernate.Session;

import context.HibernateUtil;
import entity.Inforaccount;
import entity.LoaiDeTai;

public class DaoLoaiDeTai extends IDAO<LoaiDeTai>{
	@Override
	public List<LoaiDeTai> findAll(String queryString) {
		// TODO Auto-generated method stub
		return super.findAll(queryString);
	}
	@Override
	public void nativeQuery(String HQL, Map<String, Object> params) {
		// TODO Auto-generated method stub
		super.nativeQuery(HQL, params);
	}
	
	@Override
	public LoaiDeTai create(LoaiDeTai entity) {
		// TODO Auto-generated method stub
		return super.create(entity);
	}
}
