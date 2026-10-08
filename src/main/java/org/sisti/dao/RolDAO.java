package org.sisti.dao;

import java.util.List;

import org.sisti.model.Rol;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RolDAO {

    private EntityManagerFactory emf;

    public RolDAO() {
        emf = Persistence.createEntityManagerFactory("sistiPU");
    }

    public List<Rol> listar() {

        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery(
                    "SELECT r FROM Rol r",
                    Rol.class
            ).getResultList();

        } finally {
            em.close();
        }
    }

    public Rol buscar(int id) {

        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Rol.class, id);

        } finally {
            em.close();
        }
    }

    public void registrar(Rol rol) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(rol);

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

    public void actualizar(Rol rol) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.merge(rol);

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

            Rol rol = em.find(Rol.class, id);

            if (rol != null) {
                em.remove(rol);
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