package com.example.crud.BasicCrud.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contact_tbt")
public class Contact {
    @Id
    @GeneratedValue
    private int id;

    private int phone;

    private String distict;

    public Contact(int id, int phone, String distict) {
        this.id = id;
        this.phone = phone;
        this.distict = distict;
    }

    public Contact() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone() {
        this.phone = phone;
    }

    public String getDistict() {
        return distict;
    }

    public void setDistict() {
        this.distict = distict;
    }
}