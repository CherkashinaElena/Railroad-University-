package com.railroad.model.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Elena on 6/7/2014.
 */
@Entity
public class Place {
    private int idplace;
    private int idwagon;
    private int idtrain;
    private int idtypeofwagon;
    private int placeno;
    private Wagon wagon;
    private Collection<Ticket> ticketsByIdplace;

    @Id
    @Column(name = "IDPLACE")
    public int getIdplace() {
        return idplace;
    }

    public void setIdplace(int idplace) {
        this.idplace = idplace;
    }

    @Basic
    @Column(name = "IDWAGON")
    public int getIdwagon() {
        return idwagon;
    }

    public void setIdwagon(int idwagon) {
        this.idwagon = idwagon;
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
    @Column(name = "IDTYPEOFWAGON")
    public int getIdtypeofwagon() {
        return idtypeofwagon;
    }

    public void setIdtypeofwagon(int idtypeofwagon) {
        this.idtypeofwagon = idtypeofwagon;
    }

    @Basic
    @Column(name = "PLACENO")
    public int getPlaceno() {
        return placeno;
    }

    public void setPlaceno(int placeno) {
        this.placeno = placeno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Place place = (Place) o;

        if (idplace != place.idplace) return false;
        if (idtrain != place.idtrain) return false;
        if (idtypeofwagon != place.idtypeofwagon) return false;
        if (idwagon != place.idwagon) return false;
        if (placeno != place.placeno) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idplace;
        result = 31 * result + idwagon;
        result = 31 * result + idtrain;
        result = 31 * result + idtypeofwagon;
        result = 31 * result + placeno;
        return result;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "IDWAGON", referencedColumnName = "IDWAGON", nullable = false, insertable = false, updatable = false), @JoinColumn(name = "IDTYPEOFWAGON", referencedColumnName = "IDTYPEOFWAGON", nullable = false, insertable = false, updatable = false), @JoinColumn(name = "IDTRAIN", referencedColumnName = "IDTRAIN", nullable = false, insertable = false, updatable = false)})
    public Wagon getWagon() {
        return wagon;
    }

    public void setWagon(Wagon wagon) {
        this.wagon = wagon;
    }

    @OneToMany(mappedBy = "placeByIdplace")
    public Collection<Ticket> getTicketsByIdplace() {
        return ticketsByIdplace;
    }

    public void setTicketsByIdplace(Collection<Ticket> ticketsByIdplace) {
        this.ticketsByIdplace = ticketsByIdplace;
    }
}
