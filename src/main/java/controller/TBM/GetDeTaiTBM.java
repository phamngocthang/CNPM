package controller.TBM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.ChuyenNganh;
import entity.DeTai;
import entity.LoaiDeTai;
import service.serviceDetai;
import service.serviceLoaiDeTai;



@WebServlet(urlPatterns = {"/GetDeTaiTBM"})
public class GetDeTaiTBM extends HttpServlet {
	

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); 
		request.setCharacterEncoding("UTF-8");
		int idDeTai = Integer.parseInt(request.getParameter("idDeTai")) ;
		serviceDetai svdt = new serviceDetai();
		serviceLoaiDeTai svloai = new serviceLoaiDeTai();
		
		DeTai result = svdt.getDeTaiByID(idDeTai);
		List<LoaiDeTai> listLoai = svloai.getAllLoaiDeTai();
		List<ChuyenNganh> listCN = svdt.getAllChuyenNganh();
		request.setAttribute("result", result);
		request.setAttribute("listLoai", listLoai);
		request.setAttribute("listCN", listCN);
		request.getRequestDispatcher("TBM/UpdateDeTai.jsp").forward(request, response);
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
