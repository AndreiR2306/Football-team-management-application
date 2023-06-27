package com.example.appManagement.entity;

import jakarta.persistence.*;


@Entity
@Table(name="footballManagement")
public class TeamMembers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name", nullable = false)
    private String name;
    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "varsta")
    private int varsta;
    @Column(name = "nationalitate")
    private String nationalitate;
    @Column(name="pozitie")
    private String pozitie;
    @Column(name = "goluri")
    private int goluri;
    @Column(name="pase_decisive")
    private int paseDecisive;
    @Column(name = "minute_jucate")
    private int minuteJucate;
    @Column(name = "cartonase_galbene")
    private int cartonaseGalbene;

    @Column(name = "cartonase_rosi")
    private int cartonaseRosi;

    public TeamMembers(){

    }

    public TeamMembers( String name, String surname, int varsta, String nationalitate, String pozitie, int goluri, int paseDecisive, int minuteJucate, int cartonaseGalbene, int cartonaseRosi) {
        this.name = name;
        this.surname = surname;
        this.varsta = varsta;
        this.nationalitate = nationalitate;
        this.pozitie = pozitie;
        this.goluri = goluri;
        this.paseDecisive = paseDecisive;
        this.minuteJucate = minuteJucate;
        this.cartonaseGalbene = cartonaseGalbene;
        this.cartonaseRosi = cartonaseRosi;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getNationalitate() {
        return nationalitate;
    }

    public void setNationalitate(String nationalitate) {
        this.nationalitate = nationalitate;
    }

    public String getPozitie() {
        return pozitie;
    }

    public void setPozitie(String pozitie) {
        this.pozitie = pozitie;
    }

    public int getGoluri() {
        return goluri;
    }

    public void setGoluri(int goluri) {
        this.goluri = goluri;
    }

    public int getPaseDecisive() {
        return paseDecisive;
    }

    public void setPaseDecisive(int paseDecisive) {
        this.paseDecisive = paseDecisive;
    }

    public int getMinuteJucate() {
        return minuteJucate;
    }

    public void setMinuteJucate(int minuteJucate) {
        this.minuteJucate = minuteJucate;
    }

    public int getCartonaseGalbene() {
        return cartonaseGalbene;
    }

    public void setCartonaseGalbene(int cartonaseGalbene) {
        this.cartonaseGalbene = cartonaseGalbene;
    }

    public int getCartonaseRosi() {
        return cartonaseRosi;
    }

    public void setCartonaseRosi(int cartonaseRosi) {
        this.cartonaseRosi = cartonaseRosi;
    }
}
