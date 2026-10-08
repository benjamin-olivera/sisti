package org.sisti.dao;

import java.util.List;

import org.sisti.model.Equipo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EquipoDAO {

    private EntityManagerFactory emf;

    public EquipoDAO() {
        emf = Persistence.createEntityManagerFactory("sistiPU");
    }

    public List<Equipo> listar() {

        EntityManager em = emf.createEntityManager();

        try {

            return em.createQuery(
                    "SELECT e FROM Equipo e",
                    Equipo.class
            ).getResultList();

        } finally {

            em.close();
        }
    }

    public Equipo buscar(int id) {

        EntityManager em = emf.createEntityManager();

        try {

            return em.find(Equipo.class, id);

        } finally {

            em.close();
        }
    }

    public void registrar(Equipo equipo) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();

            em.persist(equipo);

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

    public void actualizar(Equipo equipo) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();

            em.merge(equipo);

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

            Equipo equipo = em.find(Equipo.class, id);

            if (equipo != null) {
                em.remove(equipo);
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