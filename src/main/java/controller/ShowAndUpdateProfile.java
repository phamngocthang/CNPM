package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoAccount;
import entity.Inforaccount;
import service.serviceAccount;

@WebServlet("/ShowAndUpdateProfile")
public class ShowAndUpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		serviceAccount ServiceAccount = new serviceAccount(req,resp);
		Inforaccount account = ServiceAccount.getAccount();
		req.setAttribute("account", account);
        req.getRequestDispatcher("/profile.jsp").forward(req,resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		serviceAccount ServiceAccount = new serviceAccount(req,resp);
		ServiceAccount.updateProfile();
		doGet(req, resp);
	}

}
