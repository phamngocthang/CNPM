package service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.DaoDangKy;
import dao.DaoDeTai;
import entity.Account;
import entity.DangKy;
import entity.DeTai;
public class serviceDangKy {
	DaoDangKy daoDangKy = new DaoDangKy();
	public List<DangKy> getDangKyByGV(String userName) {
		String stringQuery = "from DangKy dk where dk.account="+userName;
		HashMap<String, Object> params = new HashMap<String, Object>();
		return daoDangKy.findWithParams(stringQuery, params);
	}
	
	public DangKy getDTByAccount(String userName) {
		String queryString = "From DangKy dk where dk.trNhom = :trNhom OR dk.thanhVien = :ThanhVien";
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("trNhom", userName);
		params.put("ThanhVien", userName);
		return daoDangKy.findSingleWithParams(queryString, params);
	}
	
	public void XoaDeTaiSinhVien(int id, String userName) {
		DangKy rs = daoDangKy.findSingle(DangKy.class, id);
		if(rs.getThanhVien() == userName) {
			rs.setThanhVien("");
		}
		else { // Truong Nhom 
			rs.setTrNhom(rs.getThanhVien());
			rs.setThanhVien("");
		}
		daoDangKy.update(rs);
	}
	
	public void XoaDeTaiGiangVien(int id, String userName) {
		String stringQueryUpdate = "UPDATE DangKy SET GVHuongDan = :userName, TrNhom = '', ThanhVien='' WHERE IdDangKy = :id";
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("userName", userName);
		params.put("id", id);
		daoDangKy.nativeQuery(stringQueryUpdate, params);
	}
	
	public String PhanCongDeTai(int id, String GVPB, int diem) {
		String mess = "";
		String HQL = "from DangKy dk where dk.detai="+id;
		HashMap<String, Object> params = new HashMap<String, Object>();
		DangKy dk = daoDangKy.findSingleWithParams(HQL, params);
		if(dk == null) { // Chưa có đề tài trong đăng ký thì insert;
			String stringQueryInsert = "INSERT INTO DangKy(IdDeTai, TrNhom, ThanhVien, GVHuongDan, GVPhanBien, Diem) VALUES(:id, '', '', '', :GVPB, :diem)";
			params.put("id", id);
			params.put("GVPB", GVPB);
			params.put("diem", diem);
			daoDangKy.nativeQuery(stringQueryInsert, params);
			mess = "Cập nhật thành công";
			System.out.println("Vào Insert nè");
		}
		else {
			String stringQueryUpdate = "UPDATE DangKy SET GVPhanBien = :GVPB, Diem = :diem WHERE IdDeTai = :id";
			params.put("id", id);
			params.put("GVPB", GVPB);
			params.put("diem", diem);
			daoDangKy.nativeQuery(stringQueryUpdate, params);
			mess = "Cập nhật thành công";
		}
		return mess;
	}
	
	public String DKDeTaiGiangVien(int id, String userName) {
		String mess = "";
		String HQL = "from DangKy dk where dk.detai="+id;
		HashMap<String, Object> params = new HashMap<String, Object>();
		DangKy dk = daoDangKy.findSingleWithParams(HQL, params);
		serviceDetai svdt = new serviceDetai();
		if(!svdt.KtraTGDangKy(id)) {
			return "Không nằm trong thời gian đăng ký đề tài";
		}
		if(dk == null) { // Chua có đề tài trong đăng ký, thì insert
			String stringQueryInsert = "INSERT INTO DangKy(IdDeTai, TrNhom, ThanhVien, GVHuongDan, GVPhanBien, Diem) VALUES(:id, '', '', :userName, '', -1)";
			params.put("id", id);
			params.put("userName", userName);
			daoDangKy.nativeQuery(stringQueryInsert, params);
			mess = "Đăng ký đề tài thành công";
			
		}
		else {
			String stringQueryUpdate = "UPDATE DangKy SET GVHuongDan = :userName WHERE IdDeTai = :id";
			params.put("userName", userName);
			params.put("id", id);
			daoDangKy.nativeQuery(stringQueryUpdate, params);
			mess = "Đăng ký đề tài thành công";
		}
		return mess;
	}
	
	public String DKDeTaiSinhVien(int id, String userName) {
		String mess = "";
		DangKy rs = daoDangKy.findSingle(DangKy.class, id);
		serviceDetai svdt = new serviceDetai();
		
		if(!svdt.KtraTGDangKy(rs.getDetai().getIdDeTai())) {
			return "Không nằm trong thời gian đăng ký đề tài";
		}
		
		DangKy KtraDangKy = getDTByAccount(userName);
		if(KtraDangKy == null) {
			if(rs.getTrNhom().equals("")) {
				rs.setTrNhom(userName);
				mess = "Đăng ký đề tài thành công.";
			}
			else if(rs.getThanhVien().equals("")) { // Thanh Vien
				rs.setThanhVien(userName);
				mess = "Đăng ký đề tài thành công.";
			}
			else {
				mess = "Đề tài đã đủ người. Vui lòng chọn đề tài khác.";
			}
			daoDangKy.update(rs);
		}
		else {
			mess = "Bạn đã đăng ký đề tài rồi.";
		}
		return mess;
	}
	
	public DangKy getDangKyByID(int id) {
		String HQL = "from DangKy dk where dk.detai=" + id;
		Map<String, Object> params = new HashMap<String, Object>();
		return daoDangKy.findSingleWithParams(HQL, params);
	}
}
