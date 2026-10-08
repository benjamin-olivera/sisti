package org.sisti.dao;

import java.util.List;

import org.sisti.model.Proveedor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProveedorDAO {

    private EntityManagerFactory emf;

    public ProveedorDAO() {
        emf = Persistence.createEntityManagerFactory("sistiPU");
    }

    public List<Proveedor> listar() {

        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery(
                    "SELECT p FROM Proveedor p",
                    Proveedor.class
            ).getResultList();

        } finally {
            em.close();
        }
    }

    public Proveedor buscar(int id) {

        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Proveedor.class, id);

        } finally {
            em.close();
        }
    }

    public void registrar(Proveedor proveedor) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(proveedor);

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

    public void actualizar(Proveedor proveedor) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.merge(proveedor);

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

            Proveedor proveedor = em.find(Proveedor.class, id);

            if (proveedor != null) {
                em.remove(proveedor);
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