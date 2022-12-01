package service;

import java.util.List;

import dao.daoDetai;

import java.util.ArrayList;
import java.util.Iterator;
public class serviceDetai {
	daoDetai DaoDetai = new daoDetai();
	public List<Object[]> loadDetai(int cn, int indexP) {
		List<Object[]> list = new ArrayList<>();
		String HQL;
		if(cn == -1) {
			HQL = "Select dk.IdDangKy, d.TenDeTai, chuyennganh.TenChuyenNganh, i.FullName from dangky as dk INNER JOIN detai as d ON \r\n"
					+ "dk.IdDeTai = d.IdDeTai INNER JOIN chuyennganh on chuyennganh.IdChuyenNganh= d.ChuyenNganh INNER JOIN inforaccount as i on i.UserName = dk.GVHuongDan WHERE "
					+ "dk.GVHuongDan IS NOT NULL";
		}
		else {
			HQL = "Select dk.IdDangKy, d.TenDeTai, chuyennganh.TenChuyenNganh, i.FullName from dangky as dk INNER JOIN detai as d ON \r\n"
					+ "dk.IdDeTai = d.IdDeTai INNER JOIN chuyennganh on chuyennganh.IdChuyenNganh= d.ChuyenNganh INNER JOIN inforaccount as i on i.UserName = dk.GVHuongDan WHERE "
					+ "dk.GVHuongDan IS NOT NULL and chuyennganh.IdChuyenNganh="+cn;
		}
		

		list = DaoDetai.getDetai(HQL, (indexP-1)*5, 5);
		return list;
	}
	public int getamountDTByCN(int cn) {
		String HQL = "";
		if(cn == -1) {
			HQL = "select count(*) from dangky";
		}
		else {
			HQL = "select count(*) from dangky INNER JOIN detai on dangky.IdDeTai = detai.IdDeTai WHERE detai.ChuyenNganh = " + cn;
		}
		
		return DaoDetai.getamountDTByCN(HQL);
 	}
	public List<Integer> getAmountMember(int cn, int indexP) {
		List<Integer> list = new ArrayList<>();
		String HQL;
		if(cn == -1) {
			HQL = "SELECT TrNhom, ThanhVien FROM dangky INNER JOIN nhom on dangky.IdNhom = nhom.IdNhom WHERE dangky.GVHuongDan IS NOT NULL";
		}
		else {
			HQL = "SELECT TrNhom, ThanhVien, detai.ChuyenNganh FROM dangky INNER JOIN nhom on dangky.IdNhom = nhom.IdNhom  INNER JOIN detai on detai.IdDeTai = dangky.IdDeTai WHERE dangky.GVHuongDan IS NOT NULL and detai.ChuyenNganh="+ cn;
		}
		List<Object[]> listM = DaoDetai.getDetai(HQL, (indexP-1)*5, 5);
		for (Object[] objects : listM) {
			int count = 0;
			if(objects[0].toString() != null) {
				count++;
			}
			try {
				if(objects[1].toString() != null) {
					count++;
				}
			}
			catch (Exception e){
				
			}
			list.add(count);
		}
		return list;
	}
	
	
	public static void main(String[] args) {
		serviceDetai sv = new serviceDetai();
		System.out.println(sv.getamountDTByCN(1));
	}
}
