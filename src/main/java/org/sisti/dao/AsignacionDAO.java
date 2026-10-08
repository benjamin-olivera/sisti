package org.sisti.dao;

import java.util.List;

import org.sisti.model.Asignacion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AsignacionDAO {

    private EntityManagerFactory emf;

    public AsignacionDAO() {
        emf = Persistence.createEntityManagerFactory("sistiPU");
    }

    public List<Asignacion> listar() {

        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery(
                    "SELECT a FROM Asignacion a",
                    Asignacion.class
            ).getResultList();

        } finally {
            em.close();
        }
    }

    public Asignacion buscar(int id) {

        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Asignacion.class, id);

        } finally {
            em.close();
        }
    }

    public void registrar(Asignacion asignacion) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(asignacion);

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

    public void actualizar(Asignacion asignacion) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.merge(asignacion);

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

            Asignacion asignacion = em.find(Asignacion.class, id);

            if (asignacion != null) {
                em.remove(asignacion);
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