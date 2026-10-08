package org.sisti.dao;

import java.util.List;

import org.sisti.model.Mantenimiento;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MantenimientoDAO {

    private EntityManagerFactory emf;

    public MantenimientoDAO() {
        emf = Persistence.createEntityManagerFactory("sistiPU");
    }

    public List<Mantenimiento> listar() {

        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery(
                    "SELECT m FROM Mantenimiento m",
                    Mantenimiento.class
            ).getResultList();

        } finally {
            em.close();
        }
    }

    public Mantenimiento buscar(int id) {

        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Mantenimiento.class, id);

        } finally {
            em.close();
        }
    }

    public void registrar(Mantenimiento mantenimiento) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(mantenimiento);

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

    public void actualizar(Mantenimiento mantenimiento) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.merge(mantenimiento);

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

            Mantenimiento mantenimiento =
                    em.find(Mantenimiento.class, id);

            if (mantenimiento != null) {
                em.remove(mantenimiento);
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