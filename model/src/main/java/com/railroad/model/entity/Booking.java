package com.railroad.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Elena on 6/7/2014.
 */
@Entity
public class Booking {
    private int idticket;
    private Timestamp dateofbooking;
    private double price;
    private int idbooking;
    private String status;
    private Ticket ticketByIdticket;

    @Basic
    @Column(name = "IDTICKET")
    public int getIdticket() {
        return idticket;
    }

    public void setIdticket(int idticket) {
        this.idticket = idticket;
    }

    @Basic
    @Column(name = "DATEOFBOOKING")
    public Timestamp getDateofbooking() {
        return dateofbooking;
    }

    public void setDateofbooking(Timestamp dateofbooking) {
        this.dateofbooking = dateofbooking;
    }

    @Basic
    @Column(name = "PRICE")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Id
    @Column(name = "IDBOOKING")
    public int getIdbooking() {
        return idbooking;
    }

    public void setIdbooking(int idbooking) {
        this.idbooking = idbooking;
    }

    @Basic
    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking booking = (Booking) o;

        if (idbooking != booking.idbooking) return false;
        if (idticket != booking.idticket) return false;
        if (Double.compare(booking.price, price) != 0) return false;
        if (dateofbooking != null ? !dateofbooking.equals(booking.dateofbooking) : booking.dateofbooking != null)
            return false;
        if (status != null ? !status.equals(booking.status) : booking.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idticket;
        result = 31 * result + (dateofbooking != null ? dateofbooking.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + idbooking;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "IDTICKET", referencedColumnName = "IDTICKET", nullable = false, insertable = false, updatable = false)
    public Ticket getTicketByIdticket() {
        return ticketByIdticket;
    }

    public void setTicketByIdticket(Ticket ticketByIdticket) {
        this.ticketByIdticket = ticketByIdticket;
    }
}
