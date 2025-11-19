package poly.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import poly.entity.Video;
import poly.util.JpaUtil;

import java.util.List;

public class VideoDAOImpl implements VideoDAO {

    @Override
    public Video findById(String id) {
        EntityManager em = JpaUtil.getEntityManager();
        return em.find(Video.class, id);
    }

    @Override
    public List<Video> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Video> query = em.createQuery("SELECT v FROM Video v", Video.class);
        return query.getResultList();
    }

    @Override
    public Video create(Video entity) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Lỗi khi thêm mới Video", e);
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Video entity) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity); // merge dùng để cập nhật
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Lỗi khi cập nhật Video", e);
        } finally {
            em.close();
        }
    }

    @Override
    public Video deleteById(String id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Video entity = em.find(Video.class, id); // Tìm thực thể
            if (entity != null) {
                em.remove(entity); // Xóa thực thể
            }
            em.getTransaction().commit();
            return entity; // Trả về thực thể đã bị xóa
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Lỗi khi xóa Video", e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Video> findByTitle(String keyword) {
        EntityManager em = JpaUtil.getEntityManager();
        String jpql = "SELECT v FROM Video v WHERE v.title LIKE :keyword";
        
        TypedQuery<Video> query = em.createQuery(jpql, Video.class);
        query.setParameter("keyword", "%" + keyword + "%"); // Thêm % để tìm kiếm
        
        return query.getResultList();
    }

    @Override
    public List<Video> findTop10Liked() {
        EntityManager em = JpaUtil.getEntityManager();
        // Sắp xếp các video dựa trên số lượng 'favorites', sau đó lấy 10
        String jpql = "SELECT f.video FROM Favorite f GROUP BY f.video ORDER BY COUNT(f.video) DESC";
        
        TypedQuery<Video> query = em.createQuery(jpql, Video.class);
        query.setMaxResults(10); // Giới hạn kết quả là 10
        
        return query.getResultList();
    }

    @Override
    public List<Video> findUnliked() {
        EntityManager em = JpaUtil.getEntityManager();
        // Dùng 'IS EMPTY' để kiểm tra collection 'favorites' có rỗng không
        String jpql = "SELECT v FROM Video v WHERE v.favorites IS EMPTY";
        
        TypedQuery<Video> query = em.createQuery(jpql, Video.class);
        return query.getResultList();
    }

    @Override
    public List<Video> findSharedByYear(int year) {
        EntityManager em = JpaUtil.getEntityManager();
        // Dùng hàm YEAR() (của JPQL) để trích xuất năm từ shareDate
        // Dùng DISTINCT để đảm bảo mỗi video chỉ xuất hiện 1 lần
        String jpql = "SELECT DISTINCT s.video FROM Share s "
                    + "WHERE YEAR(s.shareDate) = :year "
                    + "ORDER BY s.shareDate DESC"; // Sắp xếp theo yêu cầu
        
        TypedQuery<Video> query = em.createQuery(jpql, Video.class);
        query.setParameter("year", year);
        
        return query.getResultList();
    }
}