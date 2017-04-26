/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "SEKTORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sektory.findAll", query = "SELECT s FROM Sektory s"),
    @NamedQuery(name = "Sektory.findByIdSektoru", query = "SELECT s FROM Sektory s WHERE s.idSektoru = :idSektoru"),
    @NamedQuery(name = "Sektory.findByPowierzchnia", query = "SELECT s FROM Sektory s WHERE s.powierzchnia = :powierzchnia"),
    @NamedQuery(name = "Sektory.findByIloscWyjscEwakuacyjnych", query = "SELECT s FROM Sektory s WHERE s.iloscWyjscEwakuacyjnych = :iloscWyjscEwakuacyjnych")})
public class Sektory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SEKTORU")
    private Integer idSektoru;
    @Column(name = "POWIERZCHNIA")
    private Integer powierzchnia;
    @Column(name = "ILOSC_WYJSC_EWAKUACYJNYCH")
    private Integer iloscWyjscEwakuacyjnych;
    @OneToMany(mappedBy = "idSektora")
    private Collection<Pracownicy> pracownicyCollection;

    public Sektory() {
    }

    public Sektory(Integer idSektoru) {
        this.idSektoru = idSektoru;
    }

    public Integer getIdSektoru() {
        return idSektoru;
    }

    public void setIdSektoru(Integer idSektoru) {
        this.idSektoru = idSektoru;
    }

    public Integer getPowierzchnia() {
        return powierzchnia;
    }

    public void setPowierzchnia(Integer powierzchnia) {
        this.powierzchnia = powierzchnia;
    }

    public Integer getIloscWyjscEwakuacyjnych() {
        return iloscWyjscEwakuacyjnych;
    }

    public void setIloscWyjscEwakuacyjnych(Integer iloscWyjscEwakuacyjnych) {
        this.iloscWyjscEwakuacyjnych = iloscWyjscEwakuacyjnych;
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
        hash += (idSektoru != null ? idSektoru.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sektory)) {
            return false;
        }
        Sektory other = (Sektory) object;
        if ((this.idSektoru == null && other.idSektoru != null) || (this.idSektoru != null && !this.idSektoru.equals(other.idSektoru))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Sektory[ idSektoru=" + idSektoru + " ]";
    }
    
}
