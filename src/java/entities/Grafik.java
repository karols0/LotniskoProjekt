/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Karol
 */
@Entity
@Table(name = "GRAFIK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grafik.findAll", query = "SELECT g FROM Grafik g"),
    @NamedQuery(name = "Grafik.findByIdGrafiku", query = "SELECT g FROM Grafik g WHERE g.idGrafiku = :idGrafiku"),
    @NamedQuery(name = "Grafik.findByIloscGodzin", query = "SELECT g FROM Grafik g WHERE g.iloscGodzin = :iloscGodzin")})
public class Grafik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_GRAFIKU")
    private Integer idGrafiku;
    @Column(name = "ILOSC_GODZIN")
    private Integer iloscGodzin;
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "idGrafiku")
    private Collection<Pracownicy> pracownicyCollection;

    public Grafik() {
    }

    public Grafik(Integer idGrafiku) {
        this.idGrafiku = idGrafiku;
    }

    public Integer getIdGrafiku() {
        return idGrafiku;
    }

    public void setIdGrafiku(Integer idGrafiku) {
        this.idGrafiku = idGrafiku;
    }

    public Integer getIloscGodzin() {
        return iloscGodzin;
    }

    public void setIloscGodzin(Integer iloscGodzin) {
        this.iloscGodzin = iloscGodzin;
    }

    @XmlTransient
    public Collection<Pracownicy> getPracownicyCollection() {
        return pracownicyCollection;
    }

    public void setPracownicyCollection(Collection<Pracownicy> pracownicyCollection) {
        this.pracownicyCollection = pracownicyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrafiku != null ? idGrafiku.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grafik)) {
            return false;
        }
        Grafik other = (Grafik) object;
        if ((this.idGrafiku == null && other.idGrafiku != null) || (this.idGrafiku != null && !this.idGrafiku.equals(other.idGrafiku))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Grafik[ idGrafiku=" + idGrafiku + " ]";
    }
    
}
