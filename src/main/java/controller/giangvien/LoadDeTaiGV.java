package controller.giangvien;

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
import service.serviceDangKy;
import service.serviceDetai;



@WebServlet(urlPatterns = {"/DSDetaiGV"})
public class LoadDeTaiGV extends HttpServlet {
	serviceDetai sv = new serviceDetai();
	private int getEndPage(int cn, int showPage, int idloai) {

		int count = sv.getamountDTGV(cn, idloai);

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
		int idloai =Integer.parseInt(request.getParameter("loai"));
		
		serviceDetai sv = new serviceDetai();
		serviceDangKy svdk = new serviceDangKy();
		List<DeTai> listD = sv.loadDetaiGV(cn, index, idloai);
		int endP = getEndPage(cn, 5, idloai);
		int totalD = sv.getamountDTGV(cn, idloai);
		
		List<DangKy> listGVHD = new ArrayList<>();
		for (DeTai deTai : listD) {
			try {
				if(!svdk.getDangKyByID(deTai.getIdDeTai()).getAccount().getUsername().equals("")) {
					listGVHD.add(svdk.getDangKyByID(deTai.getIdDeTai()));
				}
				else {
					listGVHD.add(null);
				}
			} catch (Exception e) {
				listGVHD.add(null);
			}
		}
		request.setAttribute("listD", listD);
		request.setAttribute("listGVHD", listGVHD);
		request.setAttribute("tag", index);
		request.setAttribute("tagcn", cn);
		request.setAttribute("endP", endP);
		request.setAttribute("totalD", totalD);
		request.setAttribute("loai", idloai);
		request.getRequestDispatcher("GiangVien/DSDeTai.jsp").forward(request, response);
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
