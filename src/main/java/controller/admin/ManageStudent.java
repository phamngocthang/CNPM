package controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoAccount;
import dao.DaoChuyenNganh;
import dao.DaoInforaccount;
import dao.DaoUser;
import entity.Account;
import entity.ChuyenNganh;
import entity.Inforaccount;

@WebServlet(name = "ManageStudent", urlPatterns = {"/ManageStudent"})
public class ManageStudent extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String type = request.getParameter("type");
		if (type != null) {
			if (type.equals("delete")) {
				try {
					String username = request.getParameter("username");
					DaoInforaccount daoInforaccount = new DaoInforaccount();
					Inforaccount newinfor = new Inforaccount();
					for (Inforaccount x: daoInforaccount.getAll()) {
						if (x.getUserName().equals(username)) {
							newinfor = x;
						}
					}
					daoInforaccount.delete(username);
					DaoUser daoUser = new DaoUser();
					daoUser.delete(username);
					DaoChuyenNganh daoChuyenNganh = new DaoChuyenNganh();
					List<Account> newlist = new ArrayList<Account>();
					for (Account x: daoUser.getAll()) {
						if (x.getLoaiTaiKhoan() == 1) {
							newlist.add(x);
						}
					}
					request.setAttribute("allstudent", newlist);
					request.setAttribute("allchuyennganh", daoChuyenNganh.getAll());
					request.getRequestDispatcher("Admin/ManageStudent.jsp").forward(request, response);
				} catch (Exception e) {
					
				}
			}
		}
		else {
			DaoUser daoUser = new DaoUser();
			DaoChuyenNganh daoChuyenNganh = new DaoChuyenNganh();
			List<Account> newlist = new ArrayList<Account>();
			for (Account x: daoUser.getAll()) {
				if (x.getLoaiTaiKhoan() == 1) {
					newlist.add(x);
				}
			}
			request.setAttribute("allstudent", newlist);
			request.setAttribute("allchuyennganh", daoChuyenNganh.getAll());
			request.getRequestDispatcher("Admin/ManageStudent.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		if(type.equals("insert")) {
			try {
				String fullname = request.getParameter("fullname");
				String chuyennganh = request.getParameter("chuyennganh");
				String email = request.getParameter("email");
				String phone = request.getParameter("phone");
				String address = request.getParameter("address");
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				Account newaccount = new Account();
				newaccount.setUsername(username);
				newaccount.setPassword(password);
				newaccount.setLoaiTaiKhoan(1);
				newaccount.setDangkies(null);
				Inforaccount newinfor = new Inforaccount();
				newinfor.setAddress(address);
				DaoUser daoUser = new DaoUser();
				DaoChuyenNganh daoChuyenNganh = new DaoChuyenNganh();
				ChuyenNganh a = new ChuyenNganh();
				for (ChuyenNganh x: daoChuyenNganh.getAll()) {
					if (Character.compare(x.getTenChuyenNganh().charAt(0), chuyennganh.charAt(0)) == 0)
					newinfor.setChuyennganh(x);
				}
				//newinfor.setChuyennganh(a);
				newinfor.setEmail(email);
				newinfor.setFullName(fullname);
				newinfor.setPhonenumber(phone);
				newinfor.setUserName(username);
				newaccount.setInforaccount(newinfor);
				newinfor.setAccount(newaccount);
				DaoAccount daoAccount = new DaoAccount();
				daoUser.insert(newaccount);
				daoAccount.insert(newinfor);
				List<Account> newlist = new ArrayList<Account>();
				for (Account x: daoUser.getAll()) {
					if (x.getLoaiTaiKhoan() == 1) {
						newlist.add(x);
					}
				}
				request.setAttribute("allstudent", newlist);
				request.setAttribute("allchuyennganh", daoChuyenNganh.getAll());
				request.getRequestDispatcher("Admin/ManageStudent.jsp").forward(request, response);
			} catch (Exception e) {
				
			}
		}
	}
}
