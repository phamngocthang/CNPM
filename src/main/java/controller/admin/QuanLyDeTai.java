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

import entity.DangKy;
import entity.DeTai;
import entity.Inforaccount;
import service.serviceDangKy;
import service.serviceDetai;
import service.serviceUser;



@WebServlet(name = "QuanLyDeTai", urlPatterns = {"/QuanLyDeTai"})
public class QuanLyDeTai extends HttpServlet {
	serviceDetai sv = new serviceDetai();
	serviceDangKy svdk = new serviceDangKy();
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		int idloai = Integer.parseInt(request.getParameter("idloai"));
		serviceDetai sv = new serviceDetai();
		List<DeTai> listD = sv.getLoaiDeTaiAdmin(idloai);
		List<DangKy> listDK = new ArrayList<>();
				
		for (DeTai deTai : listD) {
			try {
				if(svdk.getDangKyByID(deTai.getIdDeTai()) != null) {
					listDK.add(svdk.getDangKyByID(deTai.getIdDeTai()));
				}
				else {
					listDK.add(null);
				}
			} catch (Exception e) {
				listDK.add(null);
			}
		}
		request.setAttribute("listD", listD);
		request.setAttribute("listDK", listDK);
		session.setAttribute("loai", idloai);
		
		
		
		
		
		
		
		List<Inforaccount> listGVPB = new ArrayList<>();
		for (DangKy dangKy : listDK) {
			try {
				if(!sv.getInforByUserName(dangKy.getGVPhanBien()).getUserName().equals("")) {
					listGVPB.add(sv.getInforByUserName(dangKy.getGVPhanBien()));
				}
				else {
					listGVPB.add(null);
				}
			} catch (Exception e) {
				listGVPB.add(null);
			}
		}
		
		
		
		
		request.setAttribute("listGVPB", listGVPB);
		
		request.getRequestDispatcher("Admin/QuanLyDeTai.jsp").forward(request, response);
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
