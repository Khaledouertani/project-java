package com.example.gestion_cabinet.Connexion.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DAO {
    final String URL = "jdbc:mysql://localhost:3306/gestion_cabinet";
    final String USER = "root";
    final String PASSWORD = "";
    private static Connection connection ;
    private static DAO instance  ;

    private DAO()  {
        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("connected");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("not connected");
        }
    }
    public static DAO getInstance(){
        if (instance == null){
            instance = new DAO();
        }
        return instance ;
    }
    public Connection getConnection() {
        return connection;
    }

}