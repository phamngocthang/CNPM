package controller.admin;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Account;
import entity.DangKy;
import entity.Inforaccount;
import service.serviceDangKy;
import service.serviceDetai;
import service.serviceLoaiDeTai;
import service.serviceUser;

@WebServlet("/ThemDeTai")
public class ThemDeTai extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); 
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int idLoai = (Integer)session.getAttribute("loai");
		String tenDeTai = request.getParameter("tendetai");
		int chuyenNganh = Integer.parseInt(request.getParameter("chuyennganh")); 
		String nienKhoa = request.getParameter("nienkhoa");
		String mucTieu = request.getParameter("muctieu");
		String yeuCau = request.getParameter("yeucau");
		String sanPham = request.getParameter("sanpham");
		
		serviceDetai svdt = new serviceDetai();
		
		svdt.ThemDeTai(tenDeTai, idLoai ,chuyenNganh, nienKhoa, mucTieu, yeuCau, sanPham);
		String url = "QuanLyDeTai?idloai="+idLoai;
        request.getRequestDispatcher(url).forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
