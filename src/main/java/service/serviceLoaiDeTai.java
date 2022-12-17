package service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.DaoDangKy;
import dao.DaoDeTai;
import dao.DaoLoaiDeTai;
import entity.Account;
import entity.DangKy;
import entity.LoaiDeTai;
public class serviceLoaiDeTai {
	DaoLoaiDeTai daoLoaiDeTai = new DaoLoaiDeTai();
	
	public List<LoaiDeTai> getAllLoaiDeTai() {
		String queryString = "from LoaiDeTai";
		return daoLoaiDeTai.findAll(queryString);
	}
	
	public void ThemLoaiDeTai(String tenloai, java.sql.Date ngaybatdau, java.sql.Date ngayketthuc) {
		/*
		String queryString = "Insert Into(TenLoaiDeTai, NgayBatDau, NgayKetThuc) VALUES(:tenloai, :ngaybatdau, :ngayketthuc)";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tenloai", tenloai);
		params.put("ngaybatdau", ngaybatdau);
		params.put("ngayketthuc", ngayketthuc);
		daoLoaiDeTai.nativeQuery(queryString, params);
		*/
		LoaiDeTai loai = new LoaiDeTai();
		loai.setTenLoaiDeTai(tenloai);
		loai.setNgayBatDau(ngaybatdau);
		loai.setNgayKetThuc(ngayketthuc);
		daoLoaiDeTai.create(loai);
	}
}
