package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.serviceUser;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        Cookie cookies[] = request.getCookies();
       if (cookies !=null){
           for(Cookie i: cookies){
               if(i.getName().equals("username")){
                   request.setAttribute("username",i.getValue());
               }
               if(i.getName().equals("password")){
                   request.setAttribute("password",i.getValue());
               }
           }
       }
        request.getRequestDispatcher("/login.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		serviceUser userServiceLogin = new serviceUser(request,response);
        userServiceLogin.login();
	}

}
