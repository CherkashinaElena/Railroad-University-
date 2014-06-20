package com.railroad.model.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Elena on 6/7/2014.
 */
@Entity
public class Ticket {
    private int idticket;
    private int idrouteout;
    private int idroutein;
    private int idtrain;
    private Date datein;
    private Date dateout;
    private int idplace;
    private String nameclient;
    private String surnameclient;
    private String gender;
    private String document;
    private double price;
    private Collection<Booking> bookingsByIdticket;
    private Place placeByIdplace;
    private Route routeByIdroutein;
    private Route routeByIdrouteout;

    @Id
    @Column(name = "IDTICKET")
    public int getIdticket() {
        return idticket;
    }

    public void setIdticket(int idticket) {
        this.idticket = idticket;
    }

    @Basic
    @Column(name = "IDROUTEOUT")
    public int getIdrouteout() {
        return idrouteout;
    }

    public void setIdrouteout(int idrouteout) {
        this.idrouteout = idrouteout;
    }

    @Basic
    @Column(name = "IDROUTEIN")
    public int getIdroutein() {
        return idroutein;
    }

    public void setIdroutein(int idroutein) {
        this.idroutein = idroutein;
    }

    @Basic
    @Column(name = "IDTRAIN")
    public int getIdtrain() {
        return idtrain;
    }

    public void setIdtrain(int idtrain) {
        this.idtrain = idtrain;
    }

    @Basic
    @Column(name = "DATEIN")
    public Date getDatein() {
        return datein;
    }

    public void setDatein(Date datein) {
        this.datein = datein;
    }

    @Basic
    @Column(name = "DATEOUT")
    public Date getDateout() {
        return dateout;
    }

    public void setDateout(Date dateout) {
        this.dateout = dateout;
    }

    @Basic
    @Column(name = "IDPLACE")
    public int getIdplace() {
        return idplace;
    }

    public void setIdplace(int idplace) {
        this.idplace = idplace;
    }

    @Basic
    @Column(name = "NAMECLIENT")
    public String getNameclient() {
        return nameclient;
    }

    public void setNameclient(String nameclient) {
        this.nameclient = nameclient;
    }

    @Basic
    @Column(name = "SURNAMECLIENT")
    public String getSurnameclient() {
        return surnameclient;
    }

    public void setSurnameclient(String surnameclient) {
        this.surnameclient = surnameclient;
    }

    @Basic
    @Column(name = "GENDER")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "DOCUMENT")
    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    @Basic
    @Column(name = "PRICE")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (idplace != ticket.idplace) return false;
        if (idroutein != ticket.idroutein) return false;
        if (idrouteout != ticket.idrouteout) return false;
        if (idticket != ticket.idticket) return false;
        if (idtrain != ticket.idtrain) return false;
        if (Double.compare(ticket.price, price) != 0) return false;
        if (datein != null ? !datein.equals(ticket.datein) : ticket.datein != null) return false;
        if (dateout != null ? !dateout.equals(ticket.dateout) : ticket.dateout != null) return false;
        if (document != null ? !document.equals(ticket.document) : ticket.document != null) return false;
        if (gender != null ? !gender.equals(ticket.gender) : ticket.gender != null) return false;
        if (nameclient != null ? !nameclient.equals(ticket.nameclient) : ticket.nameclient != null) return false;
        if (surnameclient != null ? !surnameclient.equals(ticket.surnameclient) : ticket.surnameclient != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idticket;
        result = 31 * result + idrouteout;
        result = 31 * result + idroutein;
        result = 31 * result + idtrain;
        result = 31 * result + (datein != null ? datein.hashCode() : 0);
        result = 31 * result + (dateout != null ? dateout.hashCode() : 0);
        result = 31 * result + idplace;
        result = 31 * result + (nameclient != null ? nameclient.hashCode() : 0);
        result = 31 * result + (surnameclient != null ? surnameclient.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (document != null ? document.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "ticketByIdticket")
    public Collection<Booking> getBookingsByIdticket() {
        return bookingsByIdticket;
    }

    public void setBookingsByIdticket(Collection<Booking> bookingsByIdticket) {
        this.bookingsByIdticket = bookingsByIdticket;
    }

    @ManyToOne
    @JoinColumn(name = "IDPLACE", referencedColumnName = "IDPLACE", nullable = false, insertable = false, updatable = false)
    public Place getPlaceByIdplace() {
        return placeByIdplace;
    }

    public void setPlaceByIdplace(Place placeByIdplace) {
        this.placeByIdplace = placeByIdplace;
    }

    @ManyToOne
    @JoinColumn(name = "IDROUTEIN", referencedColumnName = "IDROUTE", nullable = false, insertable = false, updatable = false)
    public Route getRouteByIdroutein() {
        return routeByIdroutein;
    }

    public void setRouteByIdroutein(Route routeByIdroutein) {
        this.routeByIdroutein = routeByIdroutein;
    }

    @ManyToOne
    @JoinColumn(name = "IDROUTEOUT", referencedColumnName = "IDROUTE", nullable = false, insertable = false, updatable = false)
    public Route getRouteByIdrouteout() {
        return routeByIdrouteout;
    }

    public void setRouteByIdrouteout(Route routeByIdrouteout) {
        this.routeByIdrouteout = routeByIdrouteout;
    }
}
