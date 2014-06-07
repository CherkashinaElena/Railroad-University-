package com.railroad.model.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Elena on 6/7/2014.
 */
@Entity
public class Station {
    private int idstation;
    private String namestation;
    private Collection<Route> routesByIdstation;

    @Id
    @Column(name = "IDSTATION")
    public int getIdstation() {
        return idstation;
    }

    public void setIdstation(int idstation) {
        this.idstation = idstation;
    }

    @Basic
    @Column(name = "NAMESTATION")
    public String getNamestation() {
        return namestation;
    }

    public void setNamestation(String namestation) {
        this.namestation = namestation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Station station = (Station) o;

        if (idstation != station.idstation) return false;
        if (namestation != null ? !namestation.equals(station.namestation) : station.namestation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idstation;
        result = 31 * result + (namestation != null ? namestation.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "stationByIdstation")
    public Collection<Route> getRoutesByIdstation() {
        return routesByIdstation;
    }

    public void setRoutesByIdstation(Collection<Route> routesByIdstation) {
        this.routesByIdstation = routesByIdstation;
    }
}
