	package poly.dao;

import java.util.List;

import poly.entity.Video;

public interface VideoDAO {
	
    /**
     * Truy vấn thực thể theo id
     * @param id là mã video
     * @return Video hoặc null nếu không tìm thấy
     */
    Video findById(String id);

    /**
     * Truy vấn tất cả các thực thể
     * @return List Video
     */
    List<Video> findAll();

    /**
     * Tạo mới thực thể
     * @param entity là Video
     * @return Video đã được tạo
     */
    Video create(Video entity);

    /**
     * Cập nhật thực thể
     * @param entity là Video
     */
    void update(Video entity);

    /**
     * Xóa thực thể theo id
     * @param id là mã video
     * @return Video đã bị xóa
     */
    Video deleteById(String id);
    
    /**
     * Tìm các video có title chứa từ khóa.
     * @param keyword Từ khóa
     * @return List Video
     */
    List<Video> findByTitle(String keyword);

    /**
     * Truy vấn 10 video được yêu thích nhiều nhất.
     * @return List 10 Video
     */
    List<Video> findTop10Liked();

    /**
     * Tìm các video không được ai thích (chưa có trong bảng Favorite).
     * @return List Video
     */
    List<Video> findUnliked();

    /**
     * Tìm video được chia sẻ trong năm.
     * @param year Năm
     * @return List Video
     */
    List<Video> findSharedByYear(int year);
    
    
}