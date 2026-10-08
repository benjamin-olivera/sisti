package org.sisti.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionJDBCTest {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/sisti?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String usuario = "root";
        String password = "mila";

        System.out.println("=================================");
        System.out.println("INICIANDO CONEXIÓN JDBC");
        System.out.println("=================================");

        try {
            Connection con = DriverManager.getConnection(url, usuario, password);

            System.out.println("CONEXIÓN EXITOSA");
            System.out.println("MySQL está funcionando correctamente.");
            System.out.println("Base de datos: sisti");

            con.close();

        } catch (Exception e) {

            System.out.println("ERROR DE CONEXIÓN");
            e.printStackTrace();
        }
    }
}