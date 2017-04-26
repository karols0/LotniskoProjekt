/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Karol
 */
@Entity
@Table(name = "LOTY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loty.findAll", query = "SELECT l FROM Loty l"),
    @NamedQuery(name = "Loty.findByIdLotu", query = "SELECT l FROM Loty l WHERE l.idLotu = :idLotu"),
    @NamedQuery(name = "Loty.findByIloscBilet\u00f3w", query = "SELECT l FROM Loty l WHERE l.iloscBilet\u00f3w = :iloscBilet\u00f3w"),
    @NamedQuery(name = "Loty.findByLotniskoPoczatkowe", query = "SELECT l FROM Loty l WHERE l.lotniskoPoczatkowe = :lotniskoPoczatkowe"),
    @NamedQuery(name = "Loty.findByLotniskoDocelowe", query = "SELECT l FROM Loty l WHERE l.lotniskoDocelowe = :lotniskoDocelowe"),
    @NamedQuery(name = "Loty.findByDataOdprawy", query = "SELECT l FROM Loty l WHERE l.dataOdprawy = :dataOdprawy")})
public class Loty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_LOTU")
    private Integer idLotu;
    @Column(name = "ILOSC_BILET\u00d3W")
    private Integer iloscBiletów;
    @Size(max = 50)
    @Column(name = "LOTNISKO_POCZATKOWE")
    private String lotniskoPoczatkowe;
    @Size(max = 50)
    @Column(name = "LOTNISKO_DOCELOWE")
    private String lotniskoDocelowe;
    @Column(name = "DATA_ODPRAWY")
    @Temporal(TemporalType.DATE)
    private Date dataOdprawy;
    @JoinColumn(name = "ID_SAMOLOTU", referencedColumnName = "ID_SAMOLOTU")
    @ManyToOne(cascade = CascadeType.ALL)
    private Samoloty idSamolotu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLotu", orphanRemoval = true)
    private Collection<Bilety> biletyCollection;

    public Loty() {
    }
    
    public Loty(Integer idLotu) {
        this.idLotu = idLotu;
    }

    public Integer getIdLotu() {
        return idLotu;
    }

    public void setIdLotu(Integer idLotu) {
        this.idLotu = idLotu;
    }

    public Integer getIloscBiletów() {
        return iloscBiletów;
    }

    public void setIloscBiletów(Integer iloscBiletów) {
        this.iloscBiletów = iloscBiletów;
    }

    public String getLotniskoPoczatkowe() {
        return lotniskoPoczatkowe;
    }

    public void setLotniskoPoczatkowe(String lotniskoPoczatkowe) {
        this.lotniskoPoczatkowe = lotniskoPoczatkowe;
    }

    public String getLotniskoDocelowe() {
        return lotniskoDocelowe;
    }

    public void setLotniskoDocelowe(String lotniskoDocelowe) {
        this.lotniskoDocelowe = lotniskoDocelowe;
    }

    public Date getDataOdprawy() {
        return dataOdprawy;
    }

    public void setDataOdprawy(Date dataOdprawy) {
        this.dataOdprawy = dataOdprawy;
    }

    public Samoloty getIdSamolotu() {
        return idSamolotu;
    }

    public void setIdSamolotu(Samoloty idSamolotu) {
        this.idSamolotu = idSamolotu;
    }

    @XmlTransient
    public Collection<Bilety> getBiletyCollection() {
        return biletyCollection;
    }

    public void setBiletyCollection(Collection<Bilety> biletyCollection) {
        this.biletyCollection = biletyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLotu != null ? idLotu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loty)) {
            return false;
        }
        Loty other = (Loty) object;
        if ((this.idLotu == null && other.idLotu != null) || (this.idLotu != null && !this.idLotu.equals(other.idLotu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Loty[ idLotu=" + idLotu + " ]";
    }
    
}
