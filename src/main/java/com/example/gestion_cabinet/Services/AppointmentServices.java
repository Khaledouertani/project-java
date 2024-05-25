
package com.example.gestion_cabinet.Services;

import com.example.gestion_cabinet.Connexion.DAO.DAO;
import com.example.gestion_cabinet.Interface.CRUD;
import com.example.gestion_cabinet.Models.Patient;
import com.example.gestion_cabinet.Models.Appointment;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AppointmentServices implements CRUD<Appointment> {
    private Connection connection;



    public AppointmentServices() {
        connection= DAO.getInstance().getConnection();
    }
    @Override
    public void add(Appointment appointment) throws SQLException {
        String sql = "INSERT INTO appointment (noma,date,heure,cin) VALUES (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, appointment.getNoma());
        statement.setDate(2,Date.valueOf(appointment.getDate()));
        statement.setString(3, appointment.getHeure());
        statement.setString(4, appointment.getCin().getcin());
        statement.executeUpdate();
        System.out.println("Appointment added successfully !");
    }
    @Override
    public ArrayList<Appointment> getAll() throws SQLException {
        String sql = "SELECT a.*, p.* " +
                "FROM appointment a " +
                "INNER JOIN patient p ON a.cin = p.cin";

        Statement statement=connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<Appointment> appointmentList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while(resultSet.next()){
            Patient patient = new Patient(resultSet.getString("cin"),resultSet.getString("nomp"), resultSet.getString("agep"),resultSet.getString("telp"));
            appointmentList.add(new Appointment(resultSet.getString("noma"), LocalDate.parse(resultSet.getString("date"), formatter),resultSet.getString("heure"),patient));
        }
        return appointmentList;
    }






    public void update(Appointment appointment) throws SQLException {
        String sql="UPDATE appointment SET date=?, heure=? , cin=? WHERE noma=?";
        PreparedStatement statement=connection.prepareStatement(sql);

        statement.setDate(1, Date.valueOf(appointment.getDate()));
        statement.setString(2, appointment.getHeure());
        statement.setString(3, appointment.getCin().getcin());
        statement.setString(4,appointment.getNoma());
        statement.executeUpdate();
        System.out.println("Appointment updated successfully !");

    }
    @Override
    public void delete(String t) throws SQLException {
        String sql ="DELETE FROM appointment WHERE noma=?";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setString(1,t);
        statement.executeUpdate();
        System.out.println("Appointment deleted successfully !");

    }


}