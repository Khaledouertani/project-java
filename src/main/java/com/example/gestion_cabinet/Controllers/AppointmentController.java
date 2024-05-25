package com.example.gestion_cabinet.Controllers;

import com.example.gestion_cabinet.Models.Appointment;
import com.example.gestion_cabinet.Models.Patient;
import com.example.gestion_cabinet.Services.AppointmentServices;
import com.example.gestion_cabinet.Services.PatientServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AppointmentController implements Initializable {

    @FXML
    private Button ajouter;

    @FXML
    private Button modifier;

    @FXML
    private TextField noma;

    @FXML
    private TextField date;

    @FXML
    private TextField heure;

    @FXML
    private Button supprimer;



    @FXML
    private TableView<Patient> tab;

    @FXML
    private TableColumn<Patient, String> NP;

    @FXML
    private TableColumn<Patient, String> Ntel;
    @FXML
    private TableColumn<Patient, String> Nage;
    @FXML
    private TableColumn<Patient, String> cin;
    @FXML
    private AnchorPane mainpane;


    @FXML
    void ajouterApppointmenr(ActionEvent event) throws SQLException {
        PatientServices patientServices = new PatientServices();
        Patient p = patientServices.getBycin(cin.getText());
        Appointment appointment = new Appointment(noma.getText(), LocalDate.parse(date.getText()),heure.getText(),p);
        AppointmentServices appointmentServices = new AppointmentServices();
        appointmentServices.add(appointment);
        cin.setText("");
        noma.setText("");
        date.setText("");
        heure.setText("");
        setData();

    }

    @FXML
    void modifierAppointment(ActionEvent event) throws SQLException {
        PatientServices patientServices = new PatientServices();
        Patient p = patientServices.getBycin(cin.getText());
        Appointment appointment = new Appointment(noma.getText(),LocalDate.parse(date.getText()),heure.getText(),p);
        AppointmentServices appointmentServices = new AppointmentServices();
        appointmentServices.update(appointment);
        setData();
        cin.setText("");
        noma.setText("");
        date.setText("");
        heure.setText("");

    }

    @FXML
    void suppAppointment(ActionEvent event) throws SQLException {
        AppointmentServices appointmentServices = new AppointmentServices();
        appointmentServices.delete(cin.getText());
        setData();
        cin.setText("");
        noma.setText("");
        date.setText("");
        heure.setText("");

    }


   public void initialize(URL url, ResourceBundle resourceBundle) {


        try {
            setData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tab.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                cin.setText(newSelection.getcin());
                noma.setText(newSelection.getNomp());
                date.setText(newSelection.getTelp());
                heure.setText(newSelection.getagep());
            }
        });
    }
    private void setData() throws SQLException {
        PatientServices patientServices = new PatientServices();
        ArrayList<Patient> dataList = patientServices.getAll();
        ObservableList<Patient> observabletable = FXCollections.observableArrayList(dataList);
        cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        NP.setCellValueFactory(new PropertyValueFactory<>("nomp"));
        Ntel.setCellValueFactory(new PropertyValueFactory<>("telp"));
        Nage.setCellValueFactory(new PropertyValueFactory<>("agec"));
        tab.setItems(observabletable);

    }

    @FXML
    void NaviguerVersServices(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/gestion_cabinet/com.example.gestion_cabinet.Services.fxml"));
            mainpane.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}