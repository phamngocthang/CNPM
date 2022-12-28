package dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.query.Query;
import org.hibernate.Session;

import context.HibernateUtil;
import entity.ChuyenNganh;
import entity.Inforaccount;

public class DaoChuyenNganh extends IDAO<ChuyenNganh>{
	@Override
	public List<ChuyenNganh> findAll(String queryString) {
		// TODO Auto-generated method stub
		queryString = "from ChuyenNganh";
		return super.findAll(queryString);
	}
}
