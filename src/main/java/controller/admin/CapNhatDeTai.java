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

import entity.ChuyenNganh;
import entity.DeTai;
import entity.LoaiDeTai;
import service.serviceDetai;
import service.serviceLoaiDeTai;



@WebServlet(urlPatterns = {"/CapNhatDeTai"})
public class CapNhatDeTai extends HttpServlet {
	

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); 
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int idLoai = (Integer)session.getAttribute("loai");
		int idDeTai = Integer.parseInt(request.getParameter("idDeTai"));
		String tenDeTai = request.getParameter("tendetai");
		int loaiDeTai = Integer.parseInt(request.getParameter("loaidetai"));
		int nienKhoa =  Integer.parseInt(request.getParameter("nienkhoa"));
		int chuyenNganh = Integer.parseInt(request.getParameter("chuyennganh"));
		String mucTieu = request.getParameter("muctieu");
		String yeuCau = request.getParameter("yeucau");
		String sanPham = request.getParameter("sanpham");
		
		serviceDetai svdt = new serviceDetai();
		svdt.SuaDeTai(idDeTai, tenDeTai, loaiDeTai, nienKhoa, chuyenNganh, mucTieu, yeuCau, sanPham);
		
		
		request.getRequestDispatcher("LoaiDeTaiAdmin").forward(request, response);
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
