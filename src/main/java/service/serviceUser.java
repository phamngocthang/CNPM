package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoUser;
import entity.Account;

public class serviceUser {
	private DaoUser userDAO;
	private serviceResult serviceResult;

	HttpServletResponse resp;
	HttpServletRequest req;

	public serviceUser(HttpServletRequest req, HttpServletResponse resp)
    {
        this.req = req;
        this.resp = resp;
        userDAO = new DaoUser();
    }

	public Account authenticate(String username, String password) {
		Account user = userDAO.get(username);
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
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			}
		}
	}

//	public void showProfile() throws ServletException, IOException {
//		resp.setContentType("text/html;charset=UTF-8");
//		req.getRequestDispatcher("/web/profile.jsp").forward(req, resp);
//	}
//
//	public void showEditUserProfile() throws ServletException, IOException {
//		resp.setContentType("text/html;charset=UTF-8");
//		req.getRequestDispatcher("/web/edit-profile.jsp").forward(req, resp);
//	}
//
//	public void editUserProfile(Account user) {
//		String fullName = req.getParameter("name");
//		String phone = req.getParameter("phone");
//		String gender = req.getParameter("sex");
//		String address = req.getParameter("address");
//
//		user.setName(fullName);
//		user.setPhone(phone);
//		user.setGender(gender);
//		user.setAddress(address);
//	}
//
//	public void editAdminProfile(User user) {
//		String username = req.getParameter("username");
//		String name = req.getParameter("name");
//		String password = req.getParameter("password");
//		String gender = req.getParameter("gender");
//		String phone = req.getParameter("phone");
//		String address = req.getParameter("address");
//
//		user.setName(name);
//		user.setUsername(username);
//		user.setPassword(password);
//		user.setPhone(phone);
//		user.setGender(gender);
//		user.setAddress(address);
//	}
//
//	public void updateUserProfile() throws ServletException, IOException {
//		resp.setContentType("text/html;charset=UTF-8");
//		User user = (User) req.getSession().getAttribute("userLogged");
//		editUserProfile(user);
//		userDAO.update(user);
//		showProfile();
//	}
//
//	public void updateAdminProfile() throws ServletException, IOException {
//		resp.setContentType("text/html;charset=UTF-8");
//		User user = (User) req.getSession().getAttribute("adminLogged");
//		editAdminProfile(user);
//		userDAO.update(user);
//		req.getRequestDispatcher("/admin/account-profile.jsp").forward(req, resp);
//	}

	public List<Account> getAllAccount() {
		List<Account> accounts = null;
		accounts = userDAO.getAll();
		return accounts;
	}
}
