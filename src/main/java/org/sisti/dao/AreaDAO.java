package org.sisti.dao;

import java.util.List;

import org.sisti.model.Area;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AreaDAO {

    private EntityManagerFactory emf;

    public AreaDAO() {
        emf = Persistence.createEntityManagerFactory("sistiPU");
    }

    public List<Area> listar() {

        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery(
                    "SELECT a FROM Area a",
                    Area.class
            ).getResultList();

        } finally {
            em.close();
        }
    }

    public Area buscar(int id) {

        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Area.class, id);

        } finally {
            em.close();
        }
    }

    public void registrar(Area area) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(area);

            em.getTransaction().commit();

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            e.printStackTrace();

        } finally {
            em.close();
        }
    }

    public void actualizar(Area area) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.merge(area);

            em.getTransaction().commit();

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            e.printStackTrace();

        } finally {
            em.close();
        }
    }

    public void eliminar(int id) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Area area = em.find(Area.class, id);

            if (area != null) {
                em.remove(area);
            }

            em.getTransaction().commit();

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            e.printStackTrace();

        } finally {
            em.close();
        }
    }

    public void cerrar() {

        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}