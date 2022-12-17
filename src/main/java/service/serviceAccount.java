package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoAccount;
import entity.Account;
import entity.Inforaccount;

public class serviceAccount {
	private DaoAccount accountDAO;
	private serviceResult serviceResult;

	HttpServletResponse resp;
	HttpServletRequest req;
	
	public serviceAccount(HttpServletRequest req, HttpServletResponse resp)
    {
        this.req = req;
        this.resp = resp;
        accountDAO = new DaoAccount();
    }
	
	public Inforaccount getAccount() throws ServletException, IOException
	{
		Inforaccount account = new Inforaccount();
		resp.setContentType("text/html;charset=UTF-8");
        Account user = (Account) req.getSession().getAttribute("userLogged");
		account = accountDAO.get(user.getUsername());
		return account;
	}
	
	public void updateProfile() throws ServletException, IOException
	{
		Inforaccount account = new Inforaccount();
		resp.setContentType("text/html;charset=UTF-8");
        Account user = (Account) req.getSession().getAttribute("userLogged");
		account = accountDAO.get(user.getUsername());
		
		String fullName = req.getParameter("fullname");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		
		account.setFullName(fullName);
		account.setAddress(address);
		account.setPhonenumber(phone);
		
		accountDAO.update(account);
	}
}
