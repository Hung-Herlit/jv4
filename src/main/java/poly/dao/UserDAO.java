package poly.dao;


import java.util.List;

import poly.entity.User;

public interface UserDAO {
    User findById(String id);
    List<User> findAll();
    User create(User entity);
    void update(User entity);
    User deleteById(String id);
    /**
     * Tìm User theo id hoặc email.
     * @param idOrEmail là Id hoặc Email của user
     * @return User hoặc null nếu không tìm thấy
     */
    User findByIdOrEmail(String idOrEmail);
    
    
}