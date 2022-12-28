package controller.sinhvien;

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

import org.hibernate.service.spi.ServiceBinding.ServiceLifecycleOwner;

import entity.Account;
import service.serviceDangKy;
import service.serviceUser;

@WebServlet("/DangKy")
public class DKDeTai extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("userLogged");
		serviceDangKy svDangKy = new serviceDangKy();
		String mess = "";
		if(account == null) {
			response.sendRedirect("login.jsp");
        	return;
		}
		
		if(account.getLoaiTaiKhoan() == 2) { // Giang Vien
			mess = svDangKy.DKDeTaiGiangVien(id, account.getUsername());
		}
		else if(account.getLoaiTaiKhoan() == 1) { // Sinh Vien
			
			mess = svDangKy.DKDeTaiSinhVien(id, account.getUsername());
		}
		
		
		request.setAttribute("mess", mess);
		String url = "ChiTietDeTai?id="+id;
        request.getRequestDispatcher(url).forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		serviceUser userServiceLogin = new serviceUser(request,response);
        userServiceLogin.login();
	}

}
