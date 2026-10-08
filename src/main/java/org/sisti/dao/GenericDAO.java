package org.sisti.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GenericDAO<T> {

    private EntityManagerFactory emf;
    private Class<T> clase;

    public GenericDAO(Class<T> clase) {
        this.clase = clase;
        this.emf = Persistence.createEntityManagerFactory("sistiPU");
    }

    public void registrar(T objeto) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(objeto);

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

    public List<T> listar() {

        EntityManager em = emf.createEntityManager();

        try {

            return em.createQuery(
                    "SELECT x FROM " + clase.getSimpleName() + " x",
                    clase
            ).getResultList();

        } finally {
            em.close();
        }
    }

    public T buscar(int id) {

        EntityManager em = emf.createEntityManager();

        try {

            return em.find(clase, id);

        } finally {
            em.close();
        }
    }

    public void actualizar(T objeto) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();

            em.merge(objeto);

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

            T objeto = em.find(clase, id);

            if (objeto != null) {
                em.remove(objeto);
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