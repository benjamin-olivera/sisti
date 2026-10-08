package org.sisti.dao;

import java.util.List;

import org.sisti.model.TipoEquipo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TipoEquipoDAO {

    private EntityManagerFactory emf;

    public TipoEquipoDAO() {
        emf = Persistence.createEntityManagerFactory("sistiPU");
    }

    public List<TipoEquipo> listar() {

        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery(
                    "SELECT t FROM TipoEquipo t",
                    TipoEquipo.class
            ).getResultList();

        } finally {
            em.close();
        }
    }

    public TipoEquipo buscar(int id) {

        EntityManager em = emf.createEntityManager();

        try {
            return em.find(TipoEquipo.class, id);

        } finally {
            em.close();
        }
    }

    public void registrar(TipoEquipo tipoEquipo) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(tipoEquipo);

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

    public void actualizar(TipoEquipo tipoEquipo) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.merge(tipoEquipo);

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

            TipoEquipo tipoEquipo = em.find(TipoEquipo.class, id);

            if (tipoEquipo != null) {
                em.remove(tipoEquipo);
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