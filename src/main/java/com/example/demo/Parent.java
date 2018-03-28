package com.example.demo;

public class Parent {
    private int ParentID;
  private String Farsnavn;
  private String FEfternavn;
  private String Adresse;
  private String Opgang;
  private int Postnummer;
  private int Ftelefon;
  private String Morsnavn;
  private String Mefternavn;
  private String Morstelf;
  public Parent(){

  }

    public Parent(int ParentID, String Farsnavn, String FEfternavn, String Adresse, String Opgang, int Postnummer, int Ftelefon, String Morsnavn, String Mefternavn, String Morstelf) {
        this.ParentID = ParentID;
        this.Farsnavn = Farsnavn;
        this.FEfternavn = FEfternavn;
        this.Adresse = Adresse;
        this.Opgang = Opgang;
        this.Postnummer = Postnummer;
        this.Ftelefon = Ftelefon;
        this.Morsnavn = Morsnavn;
        this.Mefternavn = Mefternavn;
        this.Morstelf = Morstelf;
    }

    public int getParentID() {
        return ParentID;
    }

    public void setParentID(int ParentID) {
        this.ParentID = ParentID;
    }

    public String getFarsnavn() {
        return Farsnavn;
    }

    public void setFarsnavn(String farsnavn) {
        Farsnavn = farsnavn;
    }

    public String getFEfternavn() {
        return FEfternavn;
    }

    public void setFEfternavn(String FEfternavn) {
        this.FEfternavn = FEfternavn;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public String getOpgang() {
        return Opgang;
    }

    public void setOpgang(String opgang) {
        Opgang = opgang;
    }

    public int getPostnummer() {
        return Postnummer;
    }

    public void setPostnummer(int postnummer) {
        Postnummer = postnummer;
    }

    public int getFtelefon() {
        return Ftelefon;
    }

    public void setFtelefon(int ftelefon) {
        Ftelefon = ftelefon;
    }

    public String getMorsnavn() {
        return Morsnavn;
    }

    public void setMorsnavn(String morsnavn) {
        Morsnavn = morsnavn;
    }

    public String getMefternavn() {
        return Mefternavn;
    }

    public void setMefternavn(String mefternavn) {
        Mefternavn = mefternavn;
    }

    public String getMorstelf() {
        return Morstelf;
    }

    public void setMorstelf(String morstelf) {
        Morstelf = morstelf;
    }

    @Override
    public String toString() {
        return  ParentID + "#" + Farsnavn + "#" + FEfternavn +"#" + Adresse+"#" + Opgang+"#" + Postnummer +"#"+ Ftelefon +"#"+ Morsnavn +"#"+ Mefternavn+"#" +  Morstelf;
    }
}

