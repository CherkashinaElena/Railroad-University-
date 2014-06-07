package com.railroad.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Elena on 6/7/2014.
 */
public class WagonPK implements Serializable {
    private int idwagon;
    private int idtypeofwagon;
    private int idtrain;

    @Column(name = "IDWAGON")
    @Id
    public int getIdwagon() {
        return idwagon;
    }

    public void setIdwagon(int idwagon) {
        this.idwagon = idwagon;
    }

    @Column(name = "IDTYPEOFWAGON")
    @Id
    public int getIdtypeofwagon() {
        return idtypeofwagon;
    }

    public void setIdtypeofwagon(int idtypeofwagon) {
        this.idtypeofwagon = idtypeofwagon;
    }

    @Column(name = "IDTRAIN")
    @Id
    public int getIdtrain() {
        return idtrain;
    }

    public void setIdtrain(int idtrain) {
        this.idtrain = idtrain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WagonPK wagonPK = (WagonPK) o;

        if (idtrain != wagonPK.idtrain) return false;
        if (idtypeofwagon != wagonPK.idtypeofwagon) return false;
        if (idwagon != wagonPK.idwagon) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idwagon;
        result = 31 * result + idtypeofwagon;
        result = 31 * result + idtrain;
        return result;
    }
}
