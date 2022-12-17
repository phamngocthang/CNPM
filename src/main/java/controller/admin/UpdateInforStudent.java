package controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoChuyenNganh;
import dao.DaoInforaccount;
import dao.DaoUser;
import entity.Account;
import entity.ChuyenNganh;
import entity.Inforaccount;

@WebServlet(name = "UpdateInfor", urlPatterns = {"/UpdateInforStudentAdmin"})
public class UpdateInforStudent extends HttpServlet{
	 	@Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	 		DaoUser daoUser = new DaoUser();
	 		List<Account> newlist = new ArrayList<Account>();
			for (Account x: daoUser.getAll()) {
				if (x.getLoaiTaiKhoan() == 1) {
					newlist.add(x);
				}
			}
			request.setAttribute("allstudent", newlist);
	 		DaoChuyenNganh daoChuyenNganh = new DaoChuyenNganh();
			request.setAttribute("allchuyennganh", daoChuyenNganh.getAll());
	 		request.getRequestDispatcher("Admin/UpdateInforStudent.jsp").forward(request, response);
	    }


	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	String chuyennganh = request.getParameter("chuyennganh");
	    	String username = request.getParameter("username");
	    	String fullname = request.getParameter("fullname");
	    	String email = request.getParameter("email");
	    	String phone = request.getParameter("phone");
	    	String address = request.getParameter("address");
	    	DaoUser daoUser = new DaoUser();
	    	Account updateaccount = new Account();
	    	for (Account x: daoUser.getAll()) {
	    		if (x.getUsername().equals(username)) {
	    			updateaccount = x;
	    		}
	    	}
	    	Inforaccount inforAccount = new Inforaccount();
	    	inforAccount = updateaccount.getInforaccount();
	    	DaoChuyenNganh daoChuyenNganh = new DaoChuyenNganh();
	    	if (!chuyennganh.isEmpty())
	    	for (ChuyenNganh x: daoChuyenNganh.getAll()) {
				if (Character.compare(x.getTenChuyenNganh().charAt(0), chuyennganh.charAt(0)) == 0)
					inforAccount.setChuyennganh(x);
			}
	    	if (!fullname.isEmpty()) inforAccount.setFullName(fullname);
	    	if (!email.isEmpty()) inforAccount.setEmail(email);
	    	if (!phone.isEmpty()) inforAccount.setPhonenumber(phone);
	    	if (!address.isEmpty()) inforAccount.setAddress(address);
	    	updateaccount.setInforaccount(inforAccount);
	    	DaoInforaccount daoInforaccount = new DaoInforaccount();
	    	daoInforaccount.update(inforAccount);
	    	daoUser.update(updateaccount);
	    	request.getRequestDispatcher("Admin/ManagerStudent.jsp").forward(request, response);
	    }
}
