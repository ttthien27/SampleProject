package com.example.sampleproject.model;

public class Contact {
    private String name;
    private String numberPhone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public Contact(String name, String numberPhone) {
        this.name = name;
        this.numberPhone = numberPhone;
    }

}
