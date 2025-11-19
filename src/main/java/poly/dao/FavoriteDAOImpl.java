package poly.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import poly.entity.Favorite;
import poly.util.JpaUtil;

import java.util.List;

public class FavoriteDAOImpl implements FavoriteDAO {

    @Override
    public Favorite findById(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        return em.find(Favorite.class, id);
    }

    @Override
    public List<Favorite> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Favorite> query = em.createQuery("SELECT f FROM Favorite f", Favorite.class);
        return query.getResultList();
    }

    @Override
    public Favorite create(Favorite entity) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Lỗi khi thêm mới Favorite", e);
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Favorite entity) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Lỗi khi cập nhật Favorite", e);
        } finally {
            em.close();
        }
    }

    @Override
    public Favorite deleteById(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Favorite entity = em.find(Favorite.class, id);
            if (entity != null) {
                em.remove(entity);
            }
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Lỗi khi xóa Favorite", e);
        } finally {
            em.close();
        }
    }
}