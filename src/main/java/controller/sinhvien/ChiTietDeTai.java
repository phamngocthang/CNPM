package controller.sinhvien;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Account;
import entity.DangKy;
import entity.DeTai;
import entity.Inforaccount;
import service.serviceDangKy;
import service.serviceDetai;



@WebServlet(name = "ChiTietDeTai", urlPatterns = {"/ChiTietDeTai"})
public class ChiTietDeTai extends HttpServlet {
	serviceDetai sv = new serviceDetai();

       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("userLogged");
		serviceDetai sv = new serviceDetai();
		serviceDangKy svdk = new serviceDangKy();
		if(account != null && account.getLoaiTaiKhoan() == 2) {
			DeTai result = sv.getDeTaiGV(id);
			DangKy dk = svdk.getDangKyByID(id);
			Inforaccount gvpb = null;
			try {
				gvpb = sv.getInforByUserName(dk.getGVPhanBien());
			} catch (Exception e) {
			}
			request.setAttribute("result", result);
			request.setAttribute("dk", dk);
			request.setAttribute("gvpb", gvpb);
		}
		else {
			DangKy result = sv.getChiTietDetai(id);
			
			List<Inforaccount> listInfo = new ArrayList<>();
			
			listInfo.add(sv.getInforByUserName(result.getTrNhom()));
			listInfo.add(sv.getInforByUserName(result.getThanhVien()));
			listInfo.add(sv.getInforByUserName(result.getGVPhanBien()));
			request.setAttribute("result", result);
			request.setAttribute("listInfo", listInfo);
		}
		//request.setAttribute("listName", listName);
		request.getRequestDispatcher("SinhVien/ChiTietDeTai.jsp").forward(request, response);
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
