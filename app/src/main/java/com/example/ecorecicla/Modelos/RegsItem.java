package com.example.ecorecicla.Modelos;

public class RegsItem {

    private final String SERIAL;

    private String month,element,idUser;

    private int quantity,price;

    public RegsItem(String SERIAL, String month, String element, String idUser, int quantity, int price) {
        this.SERIAL = SERIAL;
        this.month = month;
        this.element = element;
        this.idUser = idUser;
        this.quantity = quantity;
        this.price = price;
    }

    public String getSERIAL() {
        return SERIAL;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
