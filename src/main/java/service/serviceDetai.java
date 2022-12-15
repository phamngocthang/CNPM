package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.DaoDangKy;
import dao.DaoDeTai;
import dao.DaoInforaccount;
import entity.DangKy;
import entity.DeTai;
import entity.Inforaccount;
public class serviceDetai {
	DaoDeTai DaoDetai = new DaoDeTai();
	DaoDangKy daoDangKy = new DaoDangKy();
	DaoInforaccount daoInforaccount = new DaoInforaccount();
	public List<DangKy> loadDetai(int cn, int indexP, int idloai) {
		List<DangKy> list = new ArrayList<>();
		String HQL;
		if(cn == -1) {
			HQL = "from DangKy dk where dk.account != '' and dk.detai.loaidetai=" + idloai + " order by dk.idDangKy ASC";
		}
		else {
			HQL = "from DangKy dk where dk.account != '' and dk.detai.loaidetai=" + idloai + " and dk.detai.chuyennganh="+cn + " order by dk.idDangKy ASC";
		}
		
		list = daoDangKy.findAllLimit(HQL, (indexP-1)*5, 5);
		return list;
	}
	
	public int getamountDTByCN(int cn, int idloai) {
		String HQL = "";
		if(cn == -1) {
			HQL = "select count(*) from DangKy dk where dk.account != '' and dk.detai.loaidetai="+idloai;
		}
		else {
			HQL = "select count(*) from DangKy dk where dk.account != '' and dk.detai.chuyennganh="+cn+ " and dk.detai.loaidetai="+idloai;
		}
		
		return DaoDetai.getamountDTByCN(HQL);
 	}
	
	public int getamountDTGV(int cn, int idloai) {
		String HQL = "";
		if(cn == -1) {
			HQL = "select count(*) from DeTai d where d.loaidetai="+idloai;
		}
		else {
			HQL = "select count(*) from DeTai d where d.chuyennganh="+cn+ " and d.loaidetai="+idloai;
		}
		
		return DaoDetai.getamountDTByCN(HQL);
 	}
	
	public List<DeTai> loadDetaiGV(int cn, int indexP, int idloai) {
		List<DeTai> list = new ArrayList<>();
		String HQL;
		if(cn == -1) {
			HQL = "from DeTai d where d.loaidetai=" + idloai + " order by d.idDeTai ASC";
		}
		else {
			HQL = "from DeTai d where d.loaidetai=" + idloai + " and d.chuyennganh="+cn + " order by d.idDeTai ASC";
		}
		
		list = DaoDetai.findAllLimit(HQL, (indexP-1)*5, 5);
		return list;
	}
	
	public DangKy getChiTietDetai(int id) {
		String HQL = "From DangKy dk Where dk.idDangKy = :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		return daoDangKy.findSingleWithParams(HQL, params);
	}
	
	public DeTai getDeTaiGV(int id) {
		return DaoDetai.findSingle(DeTai.class, id);
	}
	
	public Inforaccount getInforByUserName(String userName) {
		return daoInforaccount.findSingle(Inforaccount.class, userName);
	}

	
	
}
