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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SAMOLOTY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Samoloty.findAll", query = "SELECT s FROM Samoloty s"),
    @NamedQuery(name = "Samoloty.findByIdSamolotu", query = "SELECT s FROM Samoloty s WHERE s.idSamolotu = :idSamolotu"),
    @NamedQuery(name = "Samoloty.findByIloscMiejsc", query = "SELECT s FROM Samoloty s WHERE s.iloscMiejsc = :iloscMiejsc")})
public class Samoloty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SAMOLOTU")
    private Integer idSamolotu;
    @Column(name = "ILOSC_MIEJSC")
    private Integer iloscMiejsc;
    @JoinColumn(name = "ID_PRZEWOZNIKA", referencedColumnName = "ID_PRZEWOZNIKA")
    @ManyToOne(cascade = CascadeType.ALL)
    private Przewoznicy idPrzewoznika;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSamolotu", orphanRemoval = true)
    private Collection<Loty> lotyCollection;

    public Samoloty() {
    }

    public Samoloty(Integer idSamolotu) {
        this.idSamolotu = idSamolotu;
    }

    public Integer getIdSamolotu() {
        return idSamolotu;
    }

    public void setIdSamolotu(Integer idSamolotu) {
        this.idSamolotu = idSamolotu;
    }

    public Integer getIloscMiejsc() {
        return iloscMiejsc;
    }

    public void setIloscMiejsc(Integer iloscMiejsc) {
        this.iloscMiejsc = iloscMiejsc;
    }

    public Przewoznicy getIdPrzewoznika() {
        return idPrzewoznika;
    }

    public void setIdPrzewoznika(Przewoznicy idPrzewoznika) {
        this.idPrzewoznika = idPrzewoznika;
    }

    @XmlTransient
    public Collection<Loty> getLotyCollection() {
        return lotyCollection;
    }

    public void setLotyCollection(Collection<Loty> lotyCollection) {
        this.lotyCollection = lotyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSamolotu != null ? idSamolotu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Samoloty)) {
            return false;
        }
        Samoloty other = (Samoloty) object;
        if ((this.idSamolotu == null && other.idSamolotu != null) || (this.idSamolotu != null && !this.idSamolotu.equals(other.idSamolotu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Samoloty[ idSamolotu=" + idSamolotu + " ]";
    }
    
}
