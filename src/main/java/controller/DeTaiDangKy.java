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

@WebServlet("/DeTaiDangKy")
public class DeTaiDangKy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("userLogged");
		if(account == null) {
			response.sendRedirect("login.jsp");
        	return;
		}
		serviceDangKy svDK = new serviceDangKy();
		serviceUser svUser = new serviceUser(request, response);
		DangKy result = svDK.getDTByAccount(account.getUsername());
		boolean state = true;
		int amountMem = 0;
		String cn = "";
		List<String> listMem = new ArrayList<>();
		if(result == null) {
			state = false;
		}	
		else {
			try {
				Inforaccount inf = svUser.getInfoUser(result.getTrNhom());
				if(inf.getFullName() != null) {
					listMem.add(inf.getFullName());
					amountMem++;
				}
				inf = svUser.getInfoUser(result.getThanhVien());
				if(inf.getFullName() != null) {
					listMem.add(inf.getFullName());
					amountMem++;	
				}
				listMem.add(result.getAccount().getInforaccount().getFullName());
			}
			catch (Exception e) {
				listMem.add("");
			}	
		}
		
		request.setAttribute("result", result);
		request.setAttribute("listMem", listMem);
		request.setAttribute("state", state);
		request.setAttribute("amount", amountMem);
        request.getRequestDispatcher("DeTaiDangKy.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		serviceUser userServiceLogin = new serviceUser(request,response);
        userServiceLogin.login();
	}

}
