package dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.query.Query;
import org.hibernate.Session;

import context.HibernateUtil;
import entity.DeTai;
import entity.Inforaccount;

public class DaoInforaccount extends IDAO<Inforaccount>{
	@Override
	public Inforaccount findSingle(Class<Inforaccount> type, Object key) {
		// TODO Auto-generated method stub
		return super.findSingle(type, key);
	}
}
