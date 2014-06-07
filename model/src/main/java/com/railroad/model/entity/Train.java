package com.railroad.model.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Elena on 6/7/2014.
 */
@Entity
public class Train {
    private int idtrain;
    private String numbertrain;
    private String nametrain;
    private Integer maxcountwagons;
    private Collection<Route> routesByIdtrain;
    private Collection<Wagon> wagonsByIdtrain;

    @Id
    @Column(name = "IDTRAIN")
    public int getIdtrain() {
        return idtrain;
    }

    public void setIdtrain(int idtrain) {
        this.idtrain = idtrain;
    }

    @Basic
    @Column(name = "NUMBERTRAIN")
    public String getNumbertrain() {
        return numbertrain;
    }

    public void setNumbertrain(String numbertrain) {
        this.numbertrain = numbertrain;
    }

    @Basic
    @Column(name = "NAMETRAIN")
    public String getNametrain() {
        return nametrain;
    }

    public void setNametrain(String nametrain) {
        this.nametrain = nametrain;
    }

    @Basic
    @Column(name = "MAXCOUNTWAGONS")
    public Integer getMaxcountwagons() {
        return maxcountwagons;
    }

    public void setMaxcountwagons(Integer maxcountwagons) {
        this.maxcountwagons = maxcountwagons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Train train = (Train) o;

        if (idtrain != train.idtrain) return false;
        if (maxcountwagons != null ? !maxcountwagons.equals(train.maxcountwagons) : train.maxcountwagons != null)
            return false;
        if (nametrain != null ? !nametrain.equals(train.nametrain) : train.nametrain != null) return false;
        if (numbertrain != null ? !numbertrain.equals(train.numbertrain) : train.numbertrain != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idtrain;
        result = 31 * result + (numbertrain != null ? numbertrain.hashCode() : 0);
        result = 31 * result + (nametrain != null ? nametrain.hashCode() : 0);
        result = 31 * result + (maxcountwagons != null ? maxcountwagons.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "trainByIdtrain")
    public Collection<Route> getRoutesByIdtrain() {
        return routesByIdtrain;
    }

    public void setRoutesByIdtrain(Collection<Route> routesByIdtrain) {
        this.routesByIdtrain = routesByIdtrain;
    }

    @OneToMany(mappedBy = "trainByIdtrain")
    public Collection<Wagon> getWagonsByIdtrain() {
        return wagonsByIdtrain;
    }

    public void setWagonsByIdtrain(Collection<Wagon> wagonsByIdtrain) {
        this.wagonsByIdtrain = wagonsByIdtrain;
    }
}
