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
@Table(name = "KLIENCI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klienci.findAll", query = "SELECT k FROM Klienci k"),
    @NamedQuery(name = "Klienci.findByIdKlienta", query = "SELECT k FROM Klienci k WHERE k.idKlienta = :idKlienta"),
    @NamedQuery(name = "Klienci.findByImie", query = "SELECT k FROM Klienci k WHERE k.imie = :imie"),
    @NamedQuery(name = "Klienci.findByNazwisko", query = "SELECT k FROM Klienci k WHERE k.nazwisko = :nazwisko"),
    @NamedQuery(name = "Klienci.findByAdres", query = "SELECT k FROM Klienci k WHERE k.adres = :adres"),
    @NamedQuery(name = "Klienci.findByTelefon", query = "SELECT k FROM Klienci k WHERE k.telefon = :telefon"),
    @NamedQuery(name = "Klienci.findByFormaPlatnosci", query = "SELECT k FROM Klienci k WHERE k.formaPlatnosci = :formaPlatnosci"),
    @NamedQuery(name = "Klienci.findByLogin", query = "SELECT k FROM Klienci k WHERE k.login = :login"),
    @NamedQuery(name = "Klienci.findByHaslo", query = "SELECT k FROM Klienci k WHERE k.haslo = :haslo")})
public class Klienci implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_KLIENTA")
    private Integer idKlienta;
    @Size(max = 25)
    @Column(name = "IMIE")
    private String imie;
    @Size(max = 25)
    @Column(name = "NAZWISKO")
    private String nazwisko;
    @Size(max = 25)
    @Column(name = "ADRES")
    private String adres;
    @Size(max = 9)
    @Column(name = "TELEFON")
    private String telefon;
    @Size(max = 20)
    @Column(name = "FORMA_PLATNOSCI")
    private String formaPlatnosci;
    @Size(max = 25)
    @Column(name = "LOGIN")
    private String login;
    @Size(max = 25)
    @Column(name = "HASLO")
    private String haslo;
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "idKlienta", orphanRemoval = true)
    private Collection<Bilety> biletyCollection;

    public Klienci() {
    }

    public Klienci(Integer idKlienta) {
        this.idKlienta = idKlienta;
    }

    public Integer getIdKlienta() {
        return idKlienta;
    }

    public void setIdKlienta(Integer idKlienta) {
        this.idKlienta = idKlienta;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getFormaPlatnosci() {
        return formaPlatnosci;
    }

    public void setFormaPlatnosci(String formaPlatnosci) {
        this.formaPlatnosci = formaPlatnosci;
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
    public Collection<Bilety> getBiletyCollection() {
        return biletyCollection;
    }

    public void setBiletyCollection(Collection<Bilety> biletyCollection) {
        this.biletyCollection = biletyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKlienta != null ? idKlienta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klienci)) {
            return false;
        }
        Klienci other = (Klienci) object;
        if ((this.idKlienta == null && other.idKlienta != null) || (this.idKlienta != null && !this.idKlienta.equals(other.idKlienta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Klienci[ idKlienta=" + idKlienta + " ]";
    }
    
}
