package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dao.DaoDangKy;
import dao.DaoDeTai;
import entity.Account;
import entity.DangKy;
public class serviceDangKy {
	DaoDangKy daoDangKy = new DaoDangKy();
	
	public DangKy getDTByAccount(String userName) {
		String queryString = "From DangKy dk where dk.TrNhom = :trNhom OR dk.ThanhVien = :ThanhVien";
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
	
	public String DKDeTaiSinhVien(int id, String userName) {
		String mess = "";
		DangKy rs = daoDangKy.findSingle(DangKy.class, id);
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
}
