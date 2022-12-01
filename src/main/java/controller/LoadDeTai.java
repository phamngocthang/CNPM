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



@WebServlet(name = "LoadDeTai", urlPatterns = {"/DanhSachDeTai"})
public class LoadDeTai extends HttpServlet {
	serviceDetai sv = new serviceDetai();
	private int getEndPage(int cn, int showPage) {

		int count = sv.getamountDTByCN(cn);

		int endP = count / showPage;
		if(count % showPage != 0)
		{
			endP++;
		}
		return endP;
	}
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		int index = Integer.parseInt(request.getParameter("index"));
		int cn =Integer.parseInt(request.getParameter("cn"));
		
		serviceDetai sv = new serviceDetai();
		List<Object[]> listD = sv.loadDetai(cn, index);
		List<Integer> listM = sv.getAmountMember(cn, index);
		int endP = getEndPage(cn, 5);
		request.setAttribute("listD", listD);
		request.setAttribute("listM", listM);
		request.setAttribute("tag", index);
		request.setAttribute("tagcn", cn);
		request.setAttribute("endP", endP);
		
		request.getRequestDispatcher("DSDeTai.jsp").forward(request, response);
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
