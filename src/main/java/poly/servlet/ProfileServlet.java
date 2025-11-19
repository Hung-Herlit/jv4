package poly.servlet;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import poly.dao.UserDAO;
import poly.dao.UserDAOImpl;
import poly.entity.User;

import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private UserDAO userDAO;

    public void init() {
        this.userDAO = new UserDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Giả sử bạn lấy userId từ session hoặc parameter
        // Ở đây ta hardcode "NVTeo" để test
        String userId = "NVTeo"; // Thay bằng logic lấy user id thật

        User user = userDAO.findById(userId);

        if (user != null) {
            // Đặt user vào request scope để JSP có thể lấy
            request.setAttribute("user", user);
        }

        // Chuyển tiếp đến trang JSP
        request.getRequestDispatcher("/views/profile.jsp").forward(request, response);
    }
}