package com.railroad.model.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Elena on 6/7/2014.
 */
@Entity
public class Typeofwagon {
    private int idtypeofwagon;
    private String type;
    private String myclass;
    private double price;
    private String note;
    private Collection<Wagon> wagonsByIdtypeofwagon;

    @Id
    @Column(name = "IDTYPEOFWAGON")
    public int getIdtypeofwagon() {
        return idtypeofwagon;
    }

    public void setIdtypeofwagon(int idtypeofwagon) {
        this.idtypeofwagon = idtypeofwagon;
    }

    @Basic
    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "MYCLASS")
    public String getMyclass() {
        return myclass;
    }

    public void setMyclass(String myclass) {
        this.myclass = myclass;
    }

    @Basic
    @Column(name = "PRICE")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "NOTE")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Typeofwagon that = (Typeofwagon) o;

        if (idtypeofwagon != that.idtypeofwagon) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (myclass != null ? !myclass.equals(that.myclass) : that.myclass != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idtypeofwagon;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (myclass != null ? myclass.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "typeofwagonByIdtypeofwagon")
    public Collection<Wagon> getWagonsByIdtypeofwagon() {
        return wagonsByIdtypeofwagon;
    }

    public void setWagonsByIdtypeofwagon(Collection<Wagon> wagonsByIdtypeofwagon) {
        this.wagonsByIdtypeofwagon = wagonsByIdtypeofwagon;
    }
}
