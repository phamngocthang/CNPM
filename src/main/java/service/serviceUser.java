package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoInforaccount;
import dao.DaoUser;
import entity.Account;
import entity.Inforaccount;

public class serviceUser {
	private DaoUser userDAO;
	private serviceResult serviceResult;
	DaoInforaccount daoInfo = new DaoInforaccount();
	HttpServletResponse resp;
	HttpServletRequest req;
	
	public serviceUser(HttpServletRequest req, HttpServletResponse resp)
    {
        this.req = req;
        this.resp = resp;
        userDAO = new DaoUser();
    }
	
	public Inforaccount getInfoUser(String userName) {
		return daoInfo.findSingle(Inforaccount.class, userName);
	}

	public Account authenticate(String username, String password) {
		Account user = userDAO.findSingle(Account.class, username);
		if (user != null) {
			if (password.equals(user.getPassword())) {
				return user;
			}
		}
		return null;
	}


	protected void saveRememberMe(HttpServletResponse response, String userName, String password) {
		Cookie username = new Cookie("username", userName);
		Cookie pass = new Cookie("password", password);
		username.setMaxAge(60 * 60 * 24 * 365 * 3);
		pass.setMaxAge(60 * 60 * 24 * 365 * 3);
		response.addCookie(username);
		response.addCookie(pass);
		response.setContentType("text/html");
	}

	public void login() throws IOException, ServletException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String remember = req.getParameter("remember");
		String errMessage = "";
		boolean hasErr = false;

		Account user = authenticate(username, password);
		boolean isRememberMe = "on".equals(remember);

		if (username == null || password == null || username.length() == 0 || password.length() == 0) {
			hasErr = true;
			errMessage = "Vui lòng nhập tên đăng nhập và mật khẩu";
		} else {
			try {
				if (user == null) {
					hasErr = true;
					errMessage = "Tên đăng nhập hoặc mật khẩu không đúng!";
				}
			} catch (Exception e) {
				e.printStackTrace();
				hasErr = true;
				errMessage = e.getMessage();
			}
		}
		if (hasErr) {
			req.setAttribute("message", errMessage);
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("userLogged", user);
			if (isRememberMe) {
				saveRememberMe(resp, username, password);
			}
			Object objRedirectURL = session.getAttribute("redirectURL");
			session.setMaxInactiveInterval(1000);
			if (objRedirectURL != null) {
				String redirectURL = (String) objRedirectURL;
				session.removeAttribute("redirectURL");
				resp.sendRedirect(redirectURL);
			} else {
				resp.setContentType("text/html;charset=UTF-8");
				req.getRequestDispatcher("/LoadLoaiDeTai").forward(req, resp);
			}
		}
	}


}
