package poly.dao;

import java.util.List;

import poly.dto.ShareReport;
import poly.entity.Share;

public interface ShareDAO {
    /**
     * Truy vấn thực thể theo id
     * @param id là mã (Long) của Share
     * @return Share hoặc null nếu không tìm thấy
     */
    Share findById(Long id);

    /**
     * Truy vấn tất cả các thực thể
     * @return List Share
     */
    List<Share> findAll();

    /**
     * Tạo mới thực thể
     * @param entity là Share
     * @return Share đã được tạo
     */
    Share create(Share entity);

    /**
     * Cập nhật thực thể
     * @param entity là Share
     */
    void update(Share entity);

    /**
     * Xóa thực thể theo id
     * @param id là mã (Long) của Share
     * @return Share đã bị xóa
     */
    Share deleteById(Long id);
    
    /**
     * Lấy báo cáo tổng hợp của các video đã được chia sẻ.
     * @return List của ShareReport
     */
    List<ShareReport> getShareReport();
}