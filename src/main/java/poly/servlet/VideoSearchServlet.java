package poly.servlet;

import poly.dao.VideoDAO;
import poly.dao.VideoDAOImpl;
import poly.entity.Video;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/video-search")
public class VideoSearchServlet extends HttpServlet {
    
    private VideoDAO videoDAO = new VideoDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Lấy từ khóa từ form (nếu có)
        String keyword = request.getParameter("keyword");
        
        List<Video> videos;
        
        // 2. Nếu chưa nhập gì thì lấy tất cả, nếu có nhập thì tìm kiếm
        if (keyword != null && !keyword.isEmpty()) {
            videos = videoDAO.findByTitle(keyword);
        } else {
            videos = videoDAO.findAll(); // Hàm này bạn đã có ở Lab trước
        }
        
        // 3. Đẩy dữ liệu sang JSP
        request.setAttribute("videos", videos);
        request.setAttribute("keyword", keyword); // Giữ lại từ khóa để hiện trên ô input
        
        request.getRequestDispatcher("/views/video-search.jsp").forward(request, response);
    }
}