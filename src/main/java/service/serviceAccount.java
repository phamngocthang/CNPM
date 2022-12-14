package service;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoAccount;
import dao.DaoUser;
import entity.Account;
import entity.Inforaccount;
import util.MessageUtil;

public class serviceAccount {
	private DaoAccount accountDAO;
	private DaoUser userDAO;
	private serviceResult serviceResult;
	private MessageUtil message;

	HttpServletResponse resp;
	HttpServletRequest req;
	
	public serviceAccount(HttpServletRequest req, HttpServletResponse resp)
    {
        this.req = req;
        this.resp = resp;
        this.message = new MessageUtil();
        accountDAO = new DaoAccount();
        userDAO = new DaoUser();
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
	
	public void changePassword() throws ServletException, IOException
	{
		String username = req.getParameter("username");
        String oldPass = req.getParameter("oldPassword");
        String newPass = req.getParameter("newPassword");
        String passRetype = req.getParameter("confirmPassword");

        serviceUser userService = new serviceUser();
        Account user = userService.authenticate(username,oldPass);
        String messageBody, messageType;

        if(user == null){
            messageBody = "Mật khẩu cũ không đúng, vui lòng nhập lại!";
            messageType = "danger";
        }
        else {
            if(Objects.equals(oldPass, newPass)){
                messageBody = "Mật khẩu mới không được trùng với mật khẩu cũ!";
                messageType = "danger";
            }
            else if (!Objects.equals(newPass, passRetype)){
                messageBody = "Nhập lại mật khẩu không chính xác!";
                messageType = "danger";
            }
            else {
                resp.setContentType("text/html;charset=UTF-8");
                Account usernew = (Account) req.getSession().getAttribute("userLogged");
                usernew.setPassword(newPass);
                userDAO.update(usernew);
                
                messageBody = "Đổi mật khẩu thành công!";
                messageType = "success";
            }
        }
        message.setBody(messageBody);
        message.setType(messageType);

//        req.setAttribute("action", "add");
        req.setAttribute("message", message);
        resp.setContentType("text/html;charset=UTF-8");
		serviceAccount ServiceAccount = new serviceAccount(req,resp);
		Inforaccount account = ServiceAccount.getAccount();
		req.setAttribute("account", account);
        req.getRequestDispatcher("/change-pass.jsp").forward(req, resp);
	}
}
