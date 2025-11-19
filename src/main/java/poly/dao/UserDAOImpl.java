package poly.dao;



import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import poly.entity.User;
import poly.util.JpaUtil;

import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public User findById(String id) {
        EntityManager em = JpaUtil.getEntityManager();
        return em.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    public User create(User entity) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }

	@Override
	public void update(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User deleteById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
    public User findByIdOrEmail(String idOrEmail) {
        EntityManager em = JpaUtil.getEntityManager();
        String jpql = "SELECT u FROM User u WHERE u.id = :param OR u.email = :param";
        
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        query.setParameter("param", idOrEmail);
        
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null; // Không tìm thấy
        } finally {
            em.close();
        }
    }
    // ... Implement update() và deleteById() tương tự
}