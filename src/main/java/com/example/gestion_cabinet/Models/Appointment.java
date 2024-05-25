package com.example.gestion_cabinet.Models;

import java.time.LocalDate;
import java.util.Date;

public class Appointment {
    private  String noma;
    private LocalDate date;
    private String heure;
    private  Patient cin;

    public String getNoma() {
        return noma;
    }

    public void setNoma(String noma) {
        this.noma = noma;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public Patient getCin() {
        return cin;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "noma='" + noma + '\'' +
                ", date=" + date +
                ", heure='" + heure + '\'' +
                ", cin=" + cin +
                '}';
    }

    public Appointment(String noma, LocalDate date, String heure, Patient cin) {
        this.noma = noma;
        this.date = date;
        this.heure = heure;
        this.cin = cin;
    }

    public void setCin(Patient cin) {
        this.cin = cin;
    }
}
