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
import entity.DangKy;
import entity.DeTai;
import entity.Inforaccount;
import entity.LoaiDeTai;
import service.serviceDangKy;
import service.serviceDetai;
import service.serviceLoaiDeTai;



@WebServlet(urlPatterns = {"/GetDangKy"})
public class GetDangKy extends HttpServlet {
	

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		int idDeTai = Integer.parseInt(request.getParameter("idDeTai"));
		serviceDetai sv = new serviceDetai();
		serviceDangKy svdk = new serviceDangKy();
		DeTai resultD = sv.getDeTaiByID(idDeTai);
		DangKy resultDK = new DangKy();
		List<Inforaccount> listGV = sv.getAllGV();
		
		
		
		try {
			if(svdk.getDangKyByID(resultD.getIdDeTai()) != null) {
				resultDK = svdk.getDangKyByID(resultD.getIdDeTai());
			}
			else {
					resultDK = null;
			}
		} catch (Exception e) {
			resultDK = null;
		}
		
		request.setAttribute("resultD", resultD);
		request.setAttribute("resultDK", resultDK);
		request.setAttribute("listGV", listGV);
		
		
		Inforaccount GVPB = new Inforaccount();

		try {
			if(!sv.getInforByUserName(resultDK.getGVPhanBien()).getUserName().equals("")) {
				GVPB = sv.getInforByUserName(resultDK.getGVPhanBien());
			}
			else {
				GVPB = null;
			}
		} catch (Exception e) {
			GVPB = null;
		}

		
		
		
		
		request.setAttribute("GVPB", GVPB);
		
		request.getRequestDispatcher("TBM/UpdateGiangVien.jsp").forward(request, response);
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
