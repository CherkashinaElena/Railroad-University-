package com.railroad.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Elena on 6/7/2014.
 */
@Entity
public class Route {
    private int idroute;
    private int idstation;
    private int idtrain;
    private Timestamp timein;
    private Timestamp timeout;
    private String minutes;
    private Double kilometers;
    private BigDecimal priority;
    private Station stationByIdstation;
    private Train trainByIdtrain;
    private Collection<Ticket> ticketsByIdroute;
    private Collection<Ticket> ticketsByIdroute_0;

    @Id
    @Column(name = "IDROUTE")
    public int getIdroute() {
        return idroute;
    }

    public void setIdroute(int idroute) {
        this.idroute = idroute;
    }

    @Basic
    @Column(name = "IDSTATION")
    public int getIdstation() {
        return idstation;
    }

    public void setIdstation(int idstation) {
        this.idstation = idstation;
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
    @Column(name = "TIMEIN")
    public Timestamp getTimein() {
        return timein;
    }

    public void setTimein(Timestamp timein) {
        this.timein = timein;
    }

    @Basic
    @Column(name = "TIMEOUT")
    public Timestamp getTimeout() {
        return timeout;
    }

    public void setTimeout(Timestamp timeout) {
        this.timeout = timeout;
    }

    @Basic
    @Column(name = "MINUTES")
    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    @Basic
    @Column(name = "KILOMETERS")
    public Double getKilometers() {
        return kilometers;
    }

    public void setKilometers(Double kilometers) {
        this.kilometers = kilometers;
    }

    @Basic
    @Column(name = "PRIORITY")
    public BigDecimal getPriority() {
        return priority;
    }

    public void setPriority(BigDecimal priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (idroute != route.idroute) return false;
        if (idstation != route.idstation) return false;
        if (idtrain != route.idtrain) return false;
        if (kilometers != null ? !kilometers.equals(route.kilometers) : route.kilometers != null) return false;
        if (minutes != null ? !minutes.equals(route.minutes) : route.minutes != null) return false;
        if (priority != null ? !priority.equals(route.priority) : route.priority != null) return false;
        if (timein != null ? !timein.equals(route.timein) : route.timein != null) return false;
        if (timeout != null ? !timeout.equals(route.timeout) : route.timeout != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idroute;
        result = 31 * result + idstation;
        result = 31 * result + idtrain;
        result = 31 * result + (timein != null ? timein.hashCode() : 0);
        result = 31 * result + (timeout != null ? timeout.hashCode() : 0);
        result = 31 * result + (minutes != null ? minutes.hashCode() : 0);
        result = 31 * result + (kilometers != null ? kilometers.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "IDSTATION", referencedColumnName = "IDSTATION", nullable = false, insertable = false, updatable = false)
    public Station getStationByIdstation() {
        return stationByIdstation;
    }

    public void setStationByIdstation(Station stationByIdstation) {
        this.stationByIdstation = stationByIdstation;
    }

    @ManyToOne
    @JoinColumn(name = "IDTRAIN", referencedColumnName = "IDTRAIN", nullable = false, insertable = false, updatable = false)
    public Train getTrainByIdtrain() {
        return trainByIdtrain;
    }

    public void setTrainByIdtrain(Train trainByIdtrain) {
        this.trainByIdtrain = trainByIdtrain;
    }

    @OneToMany(mappedBy = "routeByIdroutein")
    public Collection<Ticket> getTicketsByIdroute() {
        return ticketsByIdroute;
    }

    public void setTicketsByIdroute(Collection<Ticket> ticketsByIdroute) {
        this.ticketsByIdroute = ticketsByIdroute;
    }

    @OneToMany(mappedBy = "routeByIdrouteout")
    public Collection<Ticket> getTicketsByIdroute_0() {
        return ticketsByIdroute_0;
    }

    public void setTicketsByIdroute_0(Collection<Ticket> ticketsByIdroute_0) {
        this.ticketsByIdroute_0 = ticketsByIdroute_0;
    }
}
