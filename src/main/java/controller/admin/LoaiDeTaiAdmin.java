package controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.LoaiDeTai;
import service.serviceDetai;
import service.serviceLoaiDeTai;



@WebServlet(name = "LoaiDeTaiAdmin", urlPatterns = {"/LoaiDeTaiAdmin"})
public class LoaiDeTaiAdmin extends HttpServlet {
	

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		serviceLoaiDeTai svloai = new serviceLoaiDeTai();
		List<LoaiDeTai> list = new ArrayList<>();
		list = svloai.getAllLoaiDeTai();
		request.setAttribute("list", list);
		request.getRequestDispatcher("Admin/LoaiDeTai.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
