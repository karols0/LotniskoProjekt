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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Karol
 */
@Entity
@Table(name = "PRZEWOZNICY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Przewoznicy.findAll", query = "SELECT p FROM Przewoznicy p"),
    @NamedQuery(name = "Przewoznicy.findByIdPrzewoznika", query = "SELECT p FROM Przewoznicy p WHERE p.idPrzewoznika = :idPrzewoznika"),
    @NamedQuery(name = "Przewoznicy.findByNazwa", query = "SELECT p FROM Przewoznicy p WHERE p.nazwa = :nazwa"),
    @NamedQuery(name = "Przewoznicy.findByAdresFirmy", query = "SELECT p FROM Przewoznicy p WHERE p.adresFirmy = :adresFirmy"),
    @NamedQuery(name = "Przewoznicy.findByTelefon", query = "SELECT p FROM Przewoznicy p WHERE p.telefon = :telefon"),
    @NamedQuery(name = "Przewoznicy.findByIloscSamolotow", query = "SELECT p FROM Przewoznicy p WHERE p.iloscSamolotow = :iloscSamolotow"),
    @NamedQuery(name = "Przewoznicy.findByLogin", query = "SELECT p FROM Przewoznicy p WHERE p.login = :login"),
    @NamedQuery(name = "Przewoznicy.findByHaslo", query = "SELECT p FROM Przewoznicy p WHERE p.haslo = :haslo")})
public class Przewoznicy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PRZEWOZNIKA")
    private Integer idPrzewoznika;
    @Size(max = 25)
    @Column(name = "NAZWA")
    private String nazwa;
    @Size(max = 25)
    @Column(name = "ADRES_FIRMY")
    private String adresFirmy;
    @Size(max = 9)
    @Column(name = "TELEFON")
    private String telefon;
    @Column(name = "ILOSC_SAMOLOTOW")
    private Integer iloscSamolotow;
    @Size(max = 25)
    @Column(name = "LOGIN")
    private String login;
    @Size(max = 25)
    @Column(name = "HASLO")
    private String haslo;
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "idPrzewoznika", orphanRemoval = true)
    private Collection<Samoloty> samolotyCollection;

    public Przewoznicy() {
    }

    public Przewoznicy(Integer idPrzewoznika) {
        this.idPrzewoznika = idPrzewoznika;
    }

    public Integer getIdPrzewoznika() {
        return idPrzewoznika;
    }

    public void setIdPrzewoznika(Integer idPrzewoznika) {
        this.idPrzewoznika = idPrzewoznika;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getAdresFirmy() {
        return adresFirmy;
    }

    public void setAdresFirmy(String adresFirmy) {
        this.adresFirmy = adresFirmy;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Integer getIloscSamolotow() {
        return iloscSamolotow;
    }

    public void setIloscSamolotow(Integer iloscSamolotow) {
        this.iloscSamolotow = iloscSamolotow;
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

    @XmlTransient
    public Collection<Samoloty> getSamolotyCollection() {
        return samolotyCollection;
    }

    public void setSamolotyCollection(Collection<Samoloty> samolotyCollection) {
        this.samolotyCollection = samolotyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrzewoznika != null ? idPrzewoznika.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Przewoznicy)) {
            return false;
        }
        Przewoznicy other = (Przewoznicy) object;
        if ((this.idPrzewoznika == null && other.idPrzewoznika != null) || (this.idPrzewoznika != null && !this.idPrzewoznika.equals(other.idPrzewoznika))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Przewoznicy[ idPrzewoznika=" + idPrzewoznika + " ]";
    }
    
}
