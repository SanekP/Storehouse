package sanekp.storehouse.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by sanek_000 on 6/10/2014.
 */
public abstract class DAO<T, PK extends Serializable> {
    @PersistenceContext(unitName = "StorehousePU")
    protected EntityManager entityManager;
    protected Class<T> type;

    public DAO() {
    }

    public DAO(Class<T> type) {
        this.type = type;
    }

    public void insert(T entity) {
        entityManager.persist(entity);
    }

    public T find(PK key) {
        return entityManager.find(type, key);
    }

    public List<T> list(String namedQuery) {
        return entityManager.createNamedQuery(namedQuery, type).getResultList();
    }

    public List<T> list(String namedQuery, int first, int max) {
        return entityManager.createNamedQuery(namedQuery,
                type).setFirstResult(first).setMaxResults(max).getResultList();
    }

    public T update(T entity) {
        return entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
