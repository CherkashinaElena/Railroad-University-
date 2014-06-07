package com.railroad.model.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Elena on 6/7/2014.
 */
@Entity
@IdClass(WagonPK.class)
public class Wagon {
    private int idwagon;
    private int idtypeofwagon;
    private int idtrain;
    private int countofplaces;
    private Collection<Place> places;
    private Train trainByIdtrain;
    private Typeofwagon typeofwagonByIdtypeofwagon;

    @Id
    @Column(name = "IDWAGON")
    public int getIdwagon() {
        return idwagon;
    }

    public void setIdwagon(int idwagon) {
        this.idwagon = idwagon;
    }

    @Id
    @Column(name = "IDTYPEOFWAGON")
    public int getIdtypeofwagon() {
        return idtypeofwagon;
    }

    public void setIdtypeofwagon(int idtypeofwagon) {
        this.idtypeofwagon = idtypeofwagon;
    }

    @Id
    @Column(name = "IDTRAIN")
    public int getIdtrain() {
        return idtrain;
    }

    public void setIdtrain(int idtrain) {
        this.idtrain = idtrain;
    }

    @Basic
    @Column(name = "COUNTOFPLACES")
    public int getCountofplaces() {
        return countofplaces;
    }

    public void setCountofplaces(int countofplaces) {
        this.countofplaces = countofplaces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wagon wagon = (Wagon) o;

        if (countofplaces != wagon.countofplaces) return false;
        if (idtrain != wagon.idtrain) return false;
        if (idtypeofwagon != wagon.idtypeofwagon) return false;
        if (idwagon != wagon.idwagon) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idwagon;
        result = 31 * result + idtypeofwagon;
        result = 31 * result + idtrain;
        result = 31 * result + countofplaces;
        return result;
    }

    @OneToMany(mappedBy = "wagon")
    public Collection<Place> getPlaces() {
        return places;
    }

    public void setPlaces(Collection<Place> places) {
        this.places = places;
    }

    @ManyToOne
    @JoinColumn(name = "IDTRAIN", referencedColumnName = "IDTRAIN", nullable = false, insertable = false, updatable = false)
    public Train getTrainByIdtrain() {
        return trainByIdtrain;
    }

    public void setTrainByIdtrain(Train trainByIdtrain) {
        this.trainByIdtrain = trainByIdtrain;
    }

    @ManyToOne
    @JoinColumn(name = "IDTYPEOFWAGON", referencedColumnName = "IDTYPEOFWAGON", nullable = false, insertable = false, updatable = false)
    public Typeofwagon getTypeofwagonByIdtypeofwagon() {
        return typeofwagonByIdtypeofwagon;
    }

    public void setTypeofwagonByIdtypeofwagon(Typeofwagon typeofwagonByIdtypeofwagon) {
        this.typeofwagonByIdtypeofwagon = typeofwagonByIdtypeofwagon;
    }
}
