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
@Table(name = "STANOWISKA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stanowiska.findAll", query = "SELECT s FROM Stanowiska s"),
    @NamedQuery(name = "Stanowiska.findByIdStanowiska", query = "SELECT s FROM Stanowiska s WHERE s.idStanowiska = :idStanowiska"),
    @NamedQuery(name = "Stanowiska.findByGornaGranicaPensji", query = "SELECT s FROM Stanowiska s WHERE s.gornaGranicaPensji = :gornaGranicaPensji"),
    @NamedQuery(name = "Stanowiska.findByDolnaGranicaPensji", query = "SELECT s FROM Stanowiska s WHERE s.dolnaGranicaPensji = :dolnaGranicaPensji")})
public class Stanowiska implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_STANOWISKA")
    private Integer idStanowiska;
    @Column(name = "GORNA_GRANICA_PENSJI")
    private Integer gornaGranicaPensji;
    @Column(name = "DOLNA_GRANICA_PENSJI")
    private Integer dolnaGranicaPensji;
    @OneToMany(mappedBy = "idStanowiska")
    private Collection<Pracownicy> pracownicyCollection;

    public Stanowiska() {
    }

    public Stanowiska(Integer idStanowiska) {
        this.idStanowiska = idStanowiska;
    }

    public Integer getIdStanowiska() {
        return idStanowiska;
    }

    public void setIdStanowiska(Integer idStanowiska) {
        this.idStanowiska = idStanowiska;
    }

    public Integer getGornaGranicaPensji() {
        return gornaGranicaPensji;
    }

    public void setGornaGranicaPensji(Integer gornaGranicaPensji) {
        this.gornaGranicaPensji = gornaGranicaPensji;
    }

    public Integer getDolnaGranicaPensji() {
        return dolnaGranicaPensji;
    }

    public void setDolnaGranicaPensji(Integer dolnaGranicaPensji) {
        this.dolnaGranicaPensji = dolnaGranicaPensji;
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
        hash += (idStanowiska != null ? idStanowiska.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stanowiska)) {
            return false;
        }
        Stanowiska other = (Stanowiska) object;
        if ((this.idStanowiska == null && other.idStanowiska != null) || (this.idStanowiska != null && !this.idStanowiska.equals(other.idStanowiska))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Stanowiska[ idStanowiska=" + idStanowiska + " ]";
    }
    
}
