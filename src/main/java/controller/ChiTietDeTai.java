package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.serviceDetai;



@WebServlet(name = "ChiTietDeTai", urlPatterns = {"/ChiTietDeTai"})
public class ChiTietDeTai extends HttpServlet {
	serviceDetai sv = new serviceDetai();

       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));

		serviceDetai sv = new serviceDetai();
		List<Object[]> listCT = sv.getChiTietDetai(id);
		List<String> listName = sv.getNameByID(id);
		int count = 0;
		if(!listName.get(0).equals("")) {
			count++;
		}
		if(!listName.get(1).equals("")) {
			count++;
		}
		request.setAttribute("listCT", listCT);
		request.setAttribute("listName", listName);
		request.setAttribute("count", count);
		request.setAttribute("id", id);
		request.getRequestDispatcher("ChiTietDeTai.jsp").forward(request, response);
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
