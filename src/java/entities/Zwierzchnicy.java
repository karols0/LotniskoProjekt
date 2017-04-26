/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Karol
 */
@Entity
@Table(name = "ZWIERZCHNICY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zwierzchnicy.findAll", query = "SELECT z FROM Zwierzchnicy z"),
    @NamedQuery(name = "Zwierzchnicy.findByIdZwierzchnika", query = "SELECT z FROM Zwierzchnicy z WHERE z.idZwierzchnika = :idZwierzchnika"),
    @NamedQuery(name = "Zwierzchnicy.findByIloscPodwladnych", query = "SELECT z FROM Zwierzchnicy z WHERE z.iloscPodwladnych = :iloscPodwladnych"),
    @NamedQuery(name = "Zwierzchnicy.findByLogin", query = "SELECT z FROM Zwierzchnicy z WHERE z.login = :login"),
    @NamedQuery(name = "Zwierzchnicy.findByHaslo", query = "SELECT z FROM Zwierzchnicy z WHERE z.haslo = :haslo")})
public class Zwierzchnicy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ZWIERZCHNIKA")
    private Integer idZwierzchnika;
    @Column(name = "ILOSC_PODWLADNYCH")
    private Integer iloscPodwladnych;
    @Size(max = 25)
    @Column(name = "LOGIN")
    private String login;
    @Size(max = 25)
    @Column(name = "HASLO")
    private String haslo;
    @JoinColumn(name = "ID_PRACOWNIKA", referencedColumnName = "ID_PRACOWNIKA")
    @ManyToOne
    private Pracownicy idPracownika;

    public Zwierzchnicy() {
    }

    public Zwierzchnicy(Integer idZwierzchnika) {
        this.idZwierzchnika = idZwierzchnika;
    }

    public Integer getIdZwierzchnika() {
        return idZwierzchnika;
    }

    public void setIdZwierzchnika(Integer idZwierzchnika) {
        this.idZwierzchnika = idZwierzchnika;
    }

    public Integer getIloscPodwladnych() {
        return iloscPodwladnych;
    }

    public void setIloscPodwladnych(Integer iloscPodwladnych) {
        this.iloscPodwladnych = iloscPodwladnych;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public Pracownicy getIdPracownika() {
        return idPracownika;
    }

    public void setIdPracownika(Pracownicy idPracownika) {
        this.idPracownika = idPracownika;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZwierzchnika != null ? idZwierzchnika.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zwierzchnicy)) {
            return false;
        }
        Zwierzchnicy other = (Zwierzchnicy) object;
        if ((this.idZwierzchnika == null && other.idZwierzchnika != null) || (this.idZwierzchnika != null && !this.idZwierzchnika.equals(other.idZwierzchnika))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Zwierzchnicy[ idZwierzchnika=" + idZwierzchnika + " ]";
    }
    
}
