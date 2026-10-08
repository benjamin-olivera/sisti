package org.sisti.dao;

import java.util.List;

import org.sisti.model.Marca;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MarcaDAO {

    private EntityManagerFactory emf;

    public MarcaDAO() {
        emf = Persistence.createEntityManagerFactory("sistiPU");
    }

    public List<Marca> listar() {

        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery(
                    "SELECT m FROM Marca m",
                    Marca.class
            ).getResultList();

        } finally {
            em.close();
        }
    }

    public Marca buscar(int id) {

        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Marca.class, id);

        } finally {
            em.close();
        }
    }

    public void registrar(Marca marca) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(marca);

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

    public void actualizar(Marca marca) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.merge(marca);

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

            Marca marca = em.find(Marca.class, id);

            if (marca != null) {
                em.remove(marca);
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