package org.sisti.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConexionTest {

    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            System.out.println("Iniciando conexión con MySQL...");

            emf = Persistence.createEntityManagerFactory("sistiPU");

            em = emf.createEntityManager();

            System.out.println("=================================");
            System.out.println("CONEXIÓN EXITOSA");
            System.out.println("Base de datos: sisti");
            System.out.println("JPA + Hibernate funcionando");
            System.out.println("=================================");

        } catch (Exception e) {

            System.out.println("=================================");
            System.out.println("ERROR DE CONEXIÓN");
            System.out.println("=================================");

            e.printStackTrace();

        } finally {

            if (em != null) {
                em.close();
            }

            if (emf != null) {
                emf.close();
            }
        }
    }
}