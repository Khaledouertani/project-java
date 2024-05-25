package com.example.gestion_cabinet.Services;

import com.example.gestion_cabinet.Connexion.DAO.DAO;
import com.example.gestion_cabinet.Interface.CRUD;
import com.example.gestion_cabinet.Models.Patient;


import java.sql.*;
import java.util.ArrayList;

public class PatientServices implements CRUD<Patient> {
    private Connection connection;



    public PatientServices() {
        connection= DAO.getInstance().getConnection();
    }
    @Override
    public void add(Patient patient) throws SQLException {
        String sql = "INSERT INTO patient (cin,nomp,telp,agep) VALUES (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, patient.getcin());
        statement.setString(2,patient.getNomp());
        statement.setString(3, patient.getTelp());
        statement.setString(4, patient.getagep());
        statement.executeUpdate();
        System.out.println("User added successfully !");
    }
    @Override
    public ArrayList<Patient> getAll() throws SQLException {
        String sql="SELECT * FROM patient ";
        Statement statement=connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<Patient> patientsList = new ArrayList<>();
        while(resultSet.next()){
            patientsList.add(new Patient(resultSet.getString("cin"),resultSet.getString("nomp"),resultSet.getString("telp"),resultSet.getString("agep")));
        }
        return patientsList;
    }




    public Patient getBycin(String cin) throws SQLException {
        String sql = "SELECT * FROM patient WHERE cin = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, cin);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return new Patient(resultSet.getString("cin"), resultSet.getString("nomp"), resultSet.getString("telp"), resultSet.getString("age"));
        } else {
            // If no user found with the given cin, return null or throw an exception
            return null;
        }
    }

    public void update(Patient patient) throws SQLException {
        String sql="UPDATE patient SET nomp=?,telp=?, agep=? WHERE cin=?";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setString(1,patient.getNomp());
        statement.setString(2, patient.getTelp());
        statement.setString(3, patient.getagep());
        statement.setString(4, patient.getcin());
        statement.executeUpdate();
        System.out.println("User updated successfully !");

    }
    @Override
    public void delete(String t) throws SQLException {
        String sql ="DELETE FROM patient WHERE cin=?";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setString(1,t);
        statement.executeUpdate();
        System.out.println("User deleted successfully !");

    }
    public ArrayList<String> getAllcin() throws SQLException {
        String sql = "SELECT cin FROM patient";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<String> cinList = new ArrayList<>();
        while (resultSet.next()) {
            cinList.add(resultSet.getString("cin"));
        }
        return cinList;
    }

}