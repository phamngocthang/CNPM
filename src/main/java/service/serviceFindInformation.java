package service;

import java.util.ArrayList;
import java.util.List;

import dao.DaoDeTai;
import dao.DaoUser;
import entity.Account;
import entity.DeTai;

public class serviceFindInformation {
	private DaoUser userDAO = new DaoUser();
	
	public List<Account> findUser(int type, String text){
		List<Account> query = new ArrayList<Account>();
		List<Account> result = new ArrayList<Account>();
		query = userDAO.getAll();
		for (Account x: query) {
			if (x.getLoaiTaiKhoan() == type)
			{
				if (x.getInforaccount() != null)
				{
				if (x.getInforaccount().getChuyennganh().getTenChuyenNganh().toUpperCase().contains(text.toUpperCase()) ||
					x.getInforaccount().getFullName().toUpperCase().contains(text.toUpperCase()) || 
					x.getInforaccount().getEmail().toUpperCase().contains(text.toUpperCase()) || 
					x.getInforaccount().getAddress().toUpperCase().contains(text.toUpperCase()) ||
					x.getInforaccount().getPhonenumber().toUpperCase().contains(text.toUpperCase()) ||
					x.getInforaccount().getChuyennganh().getTenChuyenNganh().toUpperCase().contains(text.toUpperCase()))
				{
					result.add(x);
				}
				}
			}
		}
		return result;
	}
	public List<DeTai> findDeTai(String type, int year, String text){
		List <DeTai> query = new ArrayList<DeTai>();
		List <DeTai> result = new ArrayList<DeTai>();
		DaoDeTai daoDeTai = new DaoDeTai();
		query = daoDeTai.getAll();
		for (DeTai x: query) {
			if (x.getTenLoaiDeTai().equals(type) && x.getNienKhoa() == year) {
				if (x.getTenDeTai().toUpperCase().contains(text.toUpperCase()) ||
					x.getChuyennganh().getTenChuyenNganh().toUpperCase().contains(text.toUpperCase()) ||
					x.getMucTieu().toUpperCase().contains(text.toUpperCase()) || 
					x.getYeuCau().toUpperCase().contains(text.toUpperCase()) || 
					x.getSanPham().toUpperCase().contains(text.toUpperCase())) {
					result.add(x);
				}
			}
		}
		return result;
	}
}
