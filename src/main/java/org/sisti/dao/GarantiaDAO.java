package org.sisti.dao;

import java.util.List;

import org.sisti.model.Garantia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GarantiaDAO {

    private EntityManagerFactory emf;

    public GarantiaDAO() {
        emf = Persistence.createEntityManagerFactory("sistiPU");
    }

    public List<Garantia> listar() {

        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery(
                    "SELECT g FROM Garantia g",
                    Garantia.class
            ).getResultList();

        } finally {
            em.close();
        }
    }

    public Garantia buscar(int id) {

        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Garantia.class, id);

        } finally {
            em.close();
        }
    }

    public void registrar(Garantia garantia) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(garantia);

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

    public void actualizar(Garantia garantia) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.merge(garantia);

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

            Garantia garantia = em.find(Garantia.class, id);

            if (garantia != null) {
                em.remove(garantia);
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