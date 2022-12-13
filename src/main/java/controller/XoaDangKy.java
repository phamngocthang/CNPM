package controller;

import java.io.IOException;
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
import service.serviceUser;

@WebServlet("/XoaDangKy")
public class XoaDangKy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("userLogged");
		if(account == null) {
			response.sendRedirect("login.jsp");
        	return;
		}
		
		serviceDangKy svDangKy = new serviceDangKy();
		svDangKy.XoaDeTaiSinhVien(id, account.getUsername());
		
		request.setAttribute("state", false);
        request.getRequestDispatcher("DeTaiDangKy.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		serviceUser userServiceLogin = new serviceUser(request,response);
        userServiceLogin.login();
	}

}
