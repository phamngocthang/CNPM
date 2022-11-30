package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.DeTai;
import entity.DangKy;
public class DaoDeTai {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<Integer> countAmountMember(String querySQL) {
    	List<Integer> list = new ArrayList<>();
        String query = "SELECT TrNhom, ThanhVien FROM dangky INNER JOIN nhom on dangky.IdNhom = nhom.IdNhom WHERE dangky.GVHuongDan IS NOT NULL;";
        
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
            	int count = 0;
            	if(rs.getString(1) != null) {
            		count++;
            	}
            	if(rs.getString(2) != null) {
            		count++;
            	}
            	list.add(count);
            }
            rs.close();
			ps.close();
			conn.close();
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
        return list;
    }
    
    public List<DangKy> SelectAll(int index, int cn) {
        List<DangKy> list = new ArrayList<>();
        String query;
        if(cn == -1) {
        	query = "Select dk.IdDangKy, d.TenDeTai, chuyennganh.TenChuyenNganh, i.FullName from dangky as dk INNER JOIN detai as d ON \r\n"
            		+ "dk.IdDeTai = d.IdDeTai INNER JOIN chuyennganh on chuyennganh.IdChuyenNganh= d.ChuyenNganh INNER JOIN inforaccount as i on i.UserName = dk.GVHuongDan WHERE dk.GVHuongDan IS NOT NULL "
            		+ "LIMIT 5 OFFSET ?";
        }
        else {
        	query = "Select dk.IdDangKy, d.TenDeTai, chuyennganh.TenChuyenNganh, i.FullName from dangky as dk INNER JOIN detai as d ON \r\n"
            		+ "dk.IdDeTai = d.IdDeTai INNER JOIN chuyennganh on chuyennganh.IdChuyenNganh= d.ChuyenNganh INNER JOIN inforaccount as i on i.UserName = dk.GVHuongDan WHERE dk.GVHuongDan IS NOT NULL "
            		+ "and chuyennganh.IdChuyenNganh=? LIMIT 5 OFFSET ?";
        }
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            if(cn == -1) {
            	ps.setInt(1, (index-1)*5);
            }
            else {
            	ps.setInt(1, cn);
            	ps.setInt(2, (index-1)*5);
            }
            ResultSet rs2 = ps.executeQuery();
            List<Integer> listSL = countAmountMember("");
            
            while (rs2.next()) {
            	list.add(new DangKy(rs2.getInt(1), rs2.getString(2), 2, rs2.getString(3), rs2.getString(4)));
            }
            rs2.close();
			ps.close();
			conn.close();
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
        return list;
    }
}
