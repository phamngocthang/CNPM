package controller.sinhvien;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.DangKy;
import service.serviceDetai;



@WebServlet(name = "LoadDeTai", urlPatterns = {"/DanhSachDeTai"})
public class LoadDeTai extends HttpServlet {
	serviceDetai sv = new serviceDetai();
	private int getEndPage(int cn, int showPage, int idloai) {

		int count = sv.getamountDTByCN(cn, idloai);

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
		List<DangKy> listD = sv.loadDetai(cn, index, idloai);
		int endP = getEndPage(cn, 5, idloai);
		int totalD = sv.getamountDTByCN(cn, idloai);
		
		/*
		for (DangKy dangKy : listD) {
			System.out.println(dangKy.getTrNhom());
			System.out.println(dangKy.getThanhVien());
		}
		*/
		request.setAttribute("listD", listD);
		request.setAttribute("tag", index);
		request.setAttribute("tagcn", cn);
		request.setAttribute("endP", endP);
		request.setAttribute("totalD", totalD);
		request.setAttribute("loai", idloai);
		request.getRequestDispatcher("SinhVien/DSDeTai.jsp").forward(request, response);
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
