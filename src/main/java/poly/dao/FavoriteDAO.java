package poly.dao;

import java.util.List;

import poly.entity.Favorite;

public interface FavoriteDAO {
    /**
     * Truy vấn thực thể theo id
     * @param id là mã (Long) của Favorite
     * @return Favorite hoặc null nếu không tìm thấy
     */
    Favorite findById(Long id);

    /**
     * Truy vấn tất cả các thực thể
     * @return List Favorite
     */
    List<Favorite> findAll();

    /**
     * Tạo mới thực thể
     * @param entity là Favorite
     * @return Favorite đã được tạo
     */
    Favorite create(Favorite entity);

    /**
     * Cập nhật thực thể
     * @param entity là Favorite
     */
    void update(Favorite entity);

    /**
     * Xóa thực thể theo id
     * @param id là mã (Long) của Favorite
     * @return Favorite đã bị xóa
     */
    Favorite deleteById(Long id);
}