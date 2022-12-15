package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.query.Query;
import org.hibernate.tuple.entity.EntityBasedAssociationAttribute;
import org.hibernate.Session;

import context.HibernateUtil;
import entity.DangKy;
import entity.DeTai;
import entity.Inforaccount;

public class DaoDangKy extends IDAO<DangKy>{
	@Override
	public List<DangKy> findAllLimit(String queryString, int offset, int amount) {
		// TODO Auto-generated method stub
		return super.findAllLimit(queryString, offset, amount);
	}
	@Override
	public DangKy findSingleWithParams(String queryName, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return super.findSingleWithParams(queryName, params);
	}
	
	@Override
	public DangKy findSingle(Class<DangKy> type, Object key) {
		// TODO Auto-generated method stub
		return super.findSingle(type, key);
	}
	
	@Override
	public DangKy update(DangKy entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}
	
	@Override
	public void nativeQuery(String HQL, Map<String, Object> params) {
		// TODO Auto-generated method stub
		super.nativeQuery(HQL, params);
	}
	
	@Override
	public List<DangKy> findWithParams(String queryString, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return super.findWithParams(queryString, params);
	}
}
