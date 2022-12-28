package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.DaoChuyenNganh;
import dao.DaoDangKy;
import dao.DaoDeTai;
import dao.DaoInforaccount;
import entity.ChuyenNganh;
import entity.DangKy;
import entity.DeTai;
import entity.Inforaccount;
import entity.LoaiDeTai;
public class serviceDetai {
	DaoDeTai DaoDetai = new DaoDeTai();
	DaoDangKy daoDangKy = new DaoDangKy();
	DaoInforaccount daoInforaccount = new DaoInforaccount();
	DaoChuyenNganh daoChuyenNganh = new DaoChuyenNganh();
	public DeTai getDeTaiByID(int id) {
		return DaoDetai.findSingle(DeTai.class, id);
	}
	
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
	

	
	public boolean KtraTGDangKy(int idDeTai) {
		Date today = new Date();
		DeTai dt = DaoDetai.findSingle(DeTai.class, idDeTai);
		if(today.getTime() >= dt.getLoaidetai().getNgayBatDau().getTime() && today.getTime() <= dt.getLoaidetai().getNgayKetThuc().getTime()) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
	
	public List<DeTai> getLoaiDeTaiAdmin(int idloai) {
		
		List<DeTai> list = new ArrayList<>();
		String HQL;
		HQL = "from DeTai d where d.loaidetai=" + idloai;
			
		list = DaoDetai.findAll(HQL);
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
	public List<ChuyenNganh> getAllChuyenNganh() {
		return daoChuyenNganh.findAll("");
	}
	public List<Inforaccount> getAllGV() {
		return daoInforaccount.findAll("");
	}
	
	public Inforaccount getInforByUserName(String userName) {
		return daoInforaccount.findSingle(Inforaccount.class, userName);
	}

	public void ThemDeTai(String tenDeTai, int idLoai, int chuyenNganh, String nienKhoa, String	mucTieu, String yeuCau, String sanPham) {
		String stringQuery = "INSERT INTO DeTai(TenDeTai, IdLoaiDeTai, NienKhoa, ChuyenNganh, MucTieu, YeuCau, SanPham) VALUES("
				+ ":tenDeTai, :idLoai, :nienKhoa, :chuyenNganh, :mucTieu, :yeuCau, :sanPham)";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tenDeTai", tenDeTai);
		params.put("idLoai", idLoai);
		params.put("nienKhoa", nienKhoa);
		params.put("chuyenNganh", chuyenNganh);
		params.put("mucTieu", mucTieu);
		params.put("yeuCau", yeuCau);
		params.put("sanPham", sanPham);
		DaoDetai.nativeQuery(stringQuery, params);
	}
	
	public void SuaDeTai(int idDeTai, String tenDeTai, int idLoai, int nienKhoa, int chuyenNganh, String mucTieu, String yeuCau, String sanPham) {
		DeTai dt = new DeTai();
		dt.setIdDeTai(idDeTai);
		dt.setTenDeTai(tenDeTai);
		dt.setLoaidetai(new LoaiDeTai(idLoai));
		dt.setNienKhoa(nienKhoa);
		dt.setChuyennganh(new ChuyenNganh(chuyenNganh));
		dt.setMucTieu(mucTieu);
		dt.setYeuCau(yeuCau);
		dt.setSanPham(sanPham);
		DaoDetai.update(dt);
	}
}
