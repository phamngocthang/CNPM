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
import service.serviceLoaiDeTai;
import service.serviceUser;

@WebServlet("/ThemLoaiDeTai")
public class ThemLoaiDeTai extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String id = request.getParameter("tenLoai");
		String ngayBatDau = request.getParameter("ngayBatDau");
		String ngayKetThuc = request.getParameter("ngayKetThuc");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		java.util.Date date;
		java.sql.Date ngaybatdau=null;
		java.sql.Date ngayketthuc=null;
		try {
			date = format.parse(ngayBatDau);
			ngaybatdau = new java.sql.Date(date.getTime()); 
			java.util.Date dateend = format.parse(ngayKetThuc);
			ngayketthuc = new java.sql.Date(dateend.getTime());
		} catch (ParseException e) {
		}
		
		
		HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("userLogged");
		if(account != null) {
			serviceLoaiDeTai svloai = new serviceLoaiDeTai();
			svloai.ThemLoaiDeTai(id, ngaybatdau, ngayketthuc);
			
			request.setAttribute("messupdate", true);
			request.setAttribute("checkupdate", true);
		}
		else {
			response.sendRedirect("login.jsp");
        	return;
		}
        request.getRequestDispatcher("LoaiDeTaiAdmin").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
