package com.example.gestion_cabinet.Controllers;

import com.example.gestion_cabinet.Models.Patient;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PatientController implements Initializable {

    @FXML
    private Button ajouter;

    @FXML
    private Button modifier;

    @FXML
    private TextField nomc;

    @FXML
    private TextField agec;

    @FXML
    private TextField numcin;

    @FXML
    private Button supprimer;

    @FXML
    private TextField telc;

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
    void ajouterUtilisateur(ActionEvent event) throws SQLException {
        Patient patient = new Patient(numcin.getText(),nomc.getText(),telc.getText(),agec.getText());
        PatientServices patientServices = new PatientServices();
        patientServices.add(patient);
        numcin.setText("");
        nomc.setText("");
        telc.setText("");
        agec.setText("");
        setData();

    }

    @FXML
    void modifierUtilisateur(ActionEvent event) throws SQLException {
        Patient patient = new Patient(cin.getText(),nomc.getText(),telc.getText(),agec.getText());
        PatientServices patientServices = new PatientServices();
        patientServices.update(patient);
        setData();
        numcin.setText("");
        nomc.setText("");
        telc.setText("");
        agec.setText("");

    }

    @FXML
    void suppUtilisateur(ActionEvent event) throws SQLException {
        PatientServices patientServices = new PatientServices();
        patientServices.delete(cin.getText());
        setData();
        cin.setText("");
        nomc.setText("");
        telc.setText("");
        agec.setText("");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        try {
            setData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tab.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                cin.setText(newSelection.getcin());
                nomc.setText(newSelection.getNomp());
                telc.setText(newSelection.getTelp());
                agec.setText(newSelection.getagep());
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