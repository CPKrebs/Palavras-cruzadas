package com.example.palavrascruzadas;

import java.io.Serializable;

public class BD_Class_AUX implements Serializable {

    private String UID;
    private String LOGIN;
    private String EMAIL;
    private String PONTO;


    public void setUID(String ID) {         this.UID = ID; }
    public String getUID() {                return UID; }

    public void setLOGIN(String Login) {    this.LOGIN = Login; }
    public String getLOGIN() {              return LOGIN; }

    public void setEMAIL(String Email) {    this.EMAIL = Email; }
    public String getEMAIL() {              return  EMAIL; }

    public void setPONTO(String Ponto) {    this.PONTO = Ponto; }
    public String getPONTO() {              return PONTO; }
}
