package controller.giangvien;

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

@WebServlet("/DTDangKyGV")
public class DTDangKyGV extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("userLogged");
		int amountDK = 0;
		if(account != null && account.getLoaiTaiKhoan() == 2) {
			serviceDangKy svDK = new serviceDangKy();
			List<DangKy> listDK = svDK.getDangKyByGV(account.getUsername());
			amountDK = listDK.size();
			request.setAttribute("listDK", listDK);
			request.setAttribute("amountDK", amountDK);
		}
		else {
			response.sendRedirect("login.jsp");
        	return;
		}
        request.getRequestDispatcher("GiangVien/DeTaiDangKy.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		serviceUser userServiceLogin = new serviceUser(request,response);
        userServiceLogin.login();
	}

}
