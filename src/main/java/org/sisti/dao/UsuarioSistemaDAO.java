package org.sisti.dao;

import java.util.List;

import org.sisti.model.UsuarioSistema;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UsuarioSistemaDAO {

    private EntityManagerFactory emf;

    public UsuarioSistemaDAO() {
        emf = Persistence.createEntityManagerFactory("sistiPU");
    }

    public List<UsuarioSistema> listar() {

        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery(
                    "SELECT u FROM UsuarioSistema u",
                    UsuarioSistema.class
            ).getResultList();

        } finally {
            em.close();
        }
    }

    public UsuarioSistema buscar(int id) {

        EntityManager em = emf.createEntityManager();

        try {
            return em.find(UsuarioSistema.class, id);

        } finally {
            em.close();
        }
    }

    public UsuarioSistema buscarPorUsername(String username) {

        EntityManager em = emf.createEntityManager();

        try {

            List<UsuarioSistema> resultados = em.createQuery(
                    "SELECT u FROM UsuarioSistema u " +
                    "WHERE u.username = :username",
                    UsuarioSistema.class
            )
            .setParameter("username", username)
            .getResultList();

            if (resultados.isEmpty()) {
                return null;
            }

            return resultados.get(0);

        } finally {
            em.close();
        }
    }

    public void registrar(UsuarioSistema usuario) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(usuario);

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

    public void actualizar(UsuarioSistema usuario) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.merge(usuario);

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

            UsuarioSistema usuario =
                    em.find(UsuarioSistema.class, id);

            if (usuario != null) {
                em.remove(usuario);
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