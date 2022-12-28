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
import service.serviceDangKy;
import service.serviceDetai;
import service.serviceLoaiDeTai;



@WebServlet(urlPatterns = {"/PhanCongDeTai"})
public class PhanCongDeTai extends HttpServlet {
	

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); 
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		int idDeTai = Integer.parseInt(request.getParameter("idDeTai"));
		String gvpb = request.getParameter("gvpb");

		int diem = Integer.parseInt(request.getParameter("diem"));

		
		serviceDangKy svdk = new serviceDangKy();
		String mess = "";
		if(gvpb.equals("-1")) {
			mess = "Chưa chọn giảng viên phản biện";
			request.getRequestDispatcher("LoaiDeTaiTBM").forward(request, response);
		}
		else {
			mess = svdk.PhanCongDeTai(idDeTai, gvpb, diem);
			request.getRequestDispatcher("LoaiDeTaiTBM").forward(request, response);
		}
		
		
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
