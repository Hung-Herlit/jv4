package poly.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import poly.dao.ShareDAO;
import poly.dao.ShareDAOImpl;
import poly.dto.ShareReport;

import java.io.IOException;
import java.util.List;

@WebServlet("/share-report")
public class ShareReportServlet extends HttpServlet {
	
    private ShareDAO shareDAO;

    public void init() {
        this.shareDAO = new ShareDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Gọi DAO để lấy dữ liệu báo cáo
        List<ShareReport> reportList = shareDAO.getShareReport();

        // 2. Đặt dữ liệu vào request scope
        request.setAttribute("reportList", reportList);

        // 3. Chuyển tiếp đến trang JSP
        request.getRequestDispatcher("/views/share-report.jsp").forward(request, response);
    }
}