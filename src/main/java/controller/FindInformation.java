package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Account;
import entity.DeTai;
import service.serviceFindInformation;
import service.serviceUser;

@WebServlet("/TimKiem")
public class FindInformation extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String option = request.getParameter("param_option");
		String find = request.getParameter("param_textbox");
		String currentpage = request.getParameter("page");
		int size = 10;
		serviceFindInformation findInformation = new serviceFindInformation();
		List<Account> account_list = new ArrayList<Account>();
		List<DeTai> detai_list = new ArrayList<DeTai>();
		if (option.equals("timkiemdetai")) {
			String group = request.getParameter("group_loaidt");
			if (group.equals("1")) {
				detai_list = findInformation.findDeTai("Tiểu Luận Chuyên Ngành", 2014, find);
			} else if (group.equals("3")) {
				detai_list = findInformation.findDeTai("Đề tài tốt nghiệp", 2014, find);
			} else if (group.equals("4")) {
				detai_list = findInformation.findDeTai("Tiểu Luận Chuyên Ngành", 2017, find);
			} else
				detai_list = findInformation.findDeTai("Tiểu luận chuyên ngành", 2017, find);
			request.setAttribute("total", detai_list != null ? detai_list.size() : 0);
			int maxpage = detai_list.size()/size;
			if (detai_list.size() % size != 0) maxpage++;
			if (currentpage != null) {
				int current_page = Integer.parseInt(request.getParameter("page"));
				if (current_page > 1) {
					List<DeTai> detai_list_page = new ArrayList<DeTai>();
					for (int i = Math.min(maxpage-1,(current_page - 1)) * size; i < Math.min(detai_list.size(),(current_page * size)); i++) {
						detai_list_page.add(detai_list.get(i));
					}
					request.setAttribute("detai_list", detai_list_page);
					request.setAttribute("currentpage", current_page);
				} else {
					request.setAttribute("detai_list", detai_list);
					request.setAttribute("currentpage", 1);
				}
			} else {
				request.setAttribute("detai_list", detai_list);
				request.setAttribute("currentpage", 1);
			}
			List<Integer> page = new ArrayList<Integer>();
			for (int i = 1; i <= detai_list.size() / size; i++)
				page.add(i);
			if (detai_list.size() % size != 0) {
				page.add(detai_list.size() / size + 1);
			}
			request.setAttribute("option", option);
			request.setAttribute("group", group);
			request.setAttribute("text", find);
		} else {
			if (option.equals("timkiemsinhvien")) {
				account_list = findInformation.findUser(1, find);
				request.setAttribute("name", "Tên sinh viên");
				request.setAttribute("option", "timkiemsinhvien");
			} else {
				account_list = findInformation.findUser(2, find);
				request.setAttribute("name", "Tên giảng viên");
				request.setAttribute("option","timkiemgiangvien");
			}
			request.setAttribute("total", account_list != null ? account_list.size() : 0);
			int maxpage = account_list.size()/size;
			if (account_list.size() % size != 0) maxpage++;
			if (currentpage != null) {
				int current_page = Integer.parseInt(currentpage);
				if (current_page > 1) {
					List<Account> account_list_page = new ArrayList<Account>();
					for (int i = Math.min(maxpage-1,(current_page - 1)) * size; i < Math.min(detai_list.size(),(current_page * size)); i++) {
						account_list_page.add(account_list.get(i));
					}
					request.setAttribute("detai_list", account_list_page);
					request.setAttribute("currentpage", current_page);
				} else {
					request.setAttribute("account123", account_list);
					request.setAttribute("currentpage", 1);
				}
			} else {
				request.setAttribute("account123", account_list);
				request.setAttribute("currentpage", 1);
			}
			List<Integer> page = new ArrayList<Integer>();
			for (int i = 1; i <= account_list.size() / size; i++)
				page.add(i);
			if (account_list.size() % size != 0) {
				page.add(detai_list.size() / size + 1);
			}
			request.setAttribute("text", find);
			request.getRequestDispatcher("/Find.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/Find.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		serviceUser userServiceLogin = new serviceUser(request, response);
		userServiceLogin.login();
	}
}
