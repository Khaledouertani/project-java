package com.example.gestion_cabinet;

import com.example.gestion_cabinet.Models.Appointment;
import com.example.gestion_cabinet.Models.Patient;
import com.example.gestion_cabinet.Services.AppointmentServices;
import com.example.gestion_cabinet.Services.PatientServices;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException {
        Patient patient = new Patient("09876543","aboura","25","27151838");
        PatientServices patientServices = new PatientServices();
       // patientServices.delete(patient.getcin());
        //patientServices.add(patient);
        //patientServices.update(patient);
        patientServices.getAll().forEach(System.out::println);
        //Appointment appointment = new Appointment("doctor", LocalDate.of(2024, 5, 12), "12", patient);AppointmentServices appointmentServices = new AppointmentServices();

      //  Appointment appointment1 = new Appointment("doctor", LocalDate.of(2024, 5, 12), "13", patient);
       // appointmentServices.update(appointment1);
        //appointmentServices.delete("doctor");
       AppointmentServices appointmentServices1 = new AppointmentServices();
        appointmentServices1.getAll().forEach(System.out::println);

    }
}
