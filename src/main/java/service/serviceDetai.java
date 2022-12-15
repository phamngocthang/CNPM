package service;

import java.util.ArrayList;
import java.util.List;

import dao.DaoDeTai;
public class serviceDetai {
	DaoDeTai DaoDetai = new DaoDeTai();
	public List<Object[]> loadDetai(int cn, int indexP) {
		List<Object[]> list = new ArrayList<>();
		String HQL;
		if(cn == -1) {
			HQL = "Select dk.IdDangKy, d.TenDeTai, chuyennganh.TenChuyenNganh, i.FullName, TrNhom, ThanhVien from dangky as dk INNER JOIN detai as d ON \r\n"
					+ "dk.IdDeTai = d.IdDeTai INNER JOIN chuyennganh on chuyennganh.IdChuyenNganh= d.ChuyenNganh INNER JOIN inforaccount as i on i.UserName = dk.GVHuongDan WHERE "
					+ "dk.GVHuongDan IS NOT NULL";
		}
		else {
			HQL = "Select dk.IdDangKy, d.TenDeTai, chuyennganh.TenChuyenNganh, i.FullName, TrNhom, ThanhVien from dangky as dk INNER JOIN detai as d ON \r\n"
					+ "dk.IdDeTai = d.IdDeTai INNER JOIN chuyennganh on chuyennganh.IdChuyenNganh= d.ChuyenNganh INNER JOIN inforaccount as i on i.UserName = dk.GVHuongDan WHERE "
					+ "dk.GVHuongDan IS NOT NULL and chuyennganh.IdChuyenNganh="+cn;
		}
		

		list = DaoDetai.getDetai(HQL, (indexP-1)*5, 5);
		return list;
	}
	
	public List<Object[]> getChiTietDetai(int id) {
		List<Object[]> ctdt;
		String HQL = "select TenDeTai, MucTieu, YeuCau, SanPham, TenChuyenNganh, TenLoaiDeTai, NienKhoa, TrNhom, ThanhVien, GVHuongDan, GVPhanBien, Diem from dangky as dk INNER JOIN detai as d on dk.IdDeTai = d.IdDeTai INNER JOIN chuyennganh on chuyennganh.IdChuyenNganh = d.ChuyenNganh \r\n"
				+ "WHERE IdDangKy = :id";
		

		ctdt = DaoDetai.getChiTietDetai(HQL, id);
		return ctdt;
	}
	public List<String> getNameByID(int idDK) {
		List<String> ds = new ArrayList<>();
		String HQL = "select A.FullName from Inforaccount A where A.UserName=:id";
		List<Object[]> list = getChiTietDetai(idDK);
		for (Object[] objects : list) {
			for (int i = 7; i <= 10; i++) {
				try {
					ds.add(DaoDetai.getNameByID(HQL, objects[i].toString()).getFullName());
				} catch (Exception e) {
					ds.add("");
				}
			}
		}
		return ds;
		
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
	
	
	public List<Integer> getAmountMember(List<Object[]> listM) {
		List<Integer> list = new ArrayList<>();

		for (Object[] objects : listM) {
			int count = 0;
			if(objects[4].toString() != null) {
				count++;
			}
			try {
				if(!objects[5].toString().equals("")) {
					count++;
				}
			}
			catch (Exception e){
				
			}
			finally {
				list.add(count);
			}
		}
		return list;
	}
}
