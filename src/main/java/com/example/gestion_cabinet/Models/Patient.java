package com.example.gestion_cabinet.Models;

import java.util.List;

public class Patient {
    private String cin ;
    private String nomp ;
    private String agep;
    private String telp ;

    private List<Appointment> servicesList;
    public Patient(){

    }
    public Patient(String cin, String nomp,String agep,String telp) {
        this.cin = cin;
        this.nomp = nomp;
        this.telp = telp;
        this.agep=agep;
    }



    public String getcin() {
        return cin;
    }

    public void setcin(String cin) {
        this.cin = cin;
    }

    public String getNomp() {
        return nomp;
    }

    public void setNomp(String nomp) {
        this.nomp = nomp;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getagep(){
        return agep;
    }
    public void setagep(){
        this.agep=agep;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "cin='" + cin + '\'' +
                ", nomp='" + nomp + '\'' +
                ", agep='" + agep + '\'' +
                ", telp='" + telp + '\'' +
                ", servicesList=" + servicesList +
                '}';
    }
}