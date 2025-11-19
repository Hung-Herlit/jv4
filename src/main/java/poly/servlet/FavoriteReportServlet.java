package poly.servlet;


import poly.dao.FavoriteDAO;
import poly.dao.FavoriteDAOImpl;
import poly.entity.Favorite;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/favorite-report")
public class FavoriteReportServlet extends HttpServlet {
    private FavoriteDAO favoriteDAO;

    public void init() {
        this.favoriteDAO = new FavoriteDAOImpl(); // Bạn cần tạo FavoriteDAOImpl
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        // Lấy TẤT CẢ các lượt thích từ CSDL
        List<Favorite> favoriteList = favoriteDAO.findAll();

        // Đặt danh sách này vào request scope
        request.setAttribute("favorites", favoriteList);

        // Chuyển tiếp đến trang JSP
        request.getRequestDispatcher("/views/favorite-report.jsp").forward(request, response);
    }
}