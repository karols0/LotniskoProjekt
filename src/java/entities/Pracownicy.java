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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Karol
 */
@Entity
@Table(name = "PRACOWNICY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pracownicy.findAll", query = "SELECT p FROM Pracownicy p"),
    @NamedQuery(name = "Pracownicy.findByIdPracownika", query = "SELECT p FROM Pracownicy p WHERE p.idPracownika = :idPracownika"),
    @NamedQuery(name = "Pracownicy.findByImie", query = "SELECT p FROM Pracownicy p WHERE p.imie = :imie"),
    @NamedQuery(name = "Pracownicy.findByNazwisko", query = "SELECT p FROM Pracownicy p WHERE p.nazwisko = :nazwisko"),
    @NamedQuery(name = "Pracownicy.findByTelefon", query = "SELECT p FROM Pracownicy p WHERE p.telefon = :telefon"),
    @NamedQuery(name = "Pracownicy.findByNumerKontaBankowego", query = "SELECT p FROM Pracownicy p WHERE p.numerKontaBankowego = :numerKontaBankowego"),
    @NamedQuery(name = "Pracownicy.findByPensja", query = "SELECT p FROM Pracownicy p WHERE p.pensja = :pensja"),
    @NamedQuery(name = "Pracownicy.findByIdZwierzchnika", query = "SELECT p FROM Pracownicy p WHERE p.idZwierzchnika = :idZwierzchnika"),
    @NamedQuery(name = "Pracownicy.findByLogin", query = "SELECT p FROM Pracownicy p WHERE p.login = :login"),
    @NamedQuery(name = "Pracownicy.findByHaslo", query = "SELECT p FROM Pracownicy p WHERE p.haslo = :haslo")})
public class Pracownicy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PRACOWNIKA")
    private Integer idPracownika;
    @Size(max = 25)
    @Column(name = "IMIE")
    private String imie;
    @Size(max = 25)
    @Column(name = "NAZWISKO")
    private String nazwisko;
    @Size(max = 9)
    @Column(name = "TELEFON")
    private String telefon;
    @Size(max = 26)
    @Column(name = "NUMER_KONTA_BANKOWEGO")
    private String numerKontaBankowego;
    @Column(name = "PENSJA")
    private Integer pensja;
    @Column(name = "ID_ZWIERZCHNIKA")
    private Integer idZwierzchnika;
    @Size(max = 25)
    @Column(name = "LOGIN")
    private String login;
    @Size(max = 25)
    @Column(name = "HASLO")
    private String haslo;
    @OneToMany(mappedBy = "idPracownika")
    private Collection<Zwierzchnicy> zwierzchnicyCollection;
    @JoinColumn(name = "ID_GRAFIKU", referencedColumnName = "ID_GRAFIKU")
    @ManyToOne(cascade = CascadeType.ALL)
    private Grafik idGrafiku;
    @JoinColumn(name = "ID_SEKTORA", referencedColumnName = "ID_SEKTORU")
    @ManyToOne
    private Sektory idSektora;
    @JoinColumn(name = "ID_STANOWISKA", referencedColumnName = "ID_STANOWISKA")
    @ManyToOne
    private Stanowiska idStanowiska;

    public Pracownicy() {
    }

    public Pracownicy(Integer idPracownika) {
        this.idPracownika = idPracownika;
    }

    public Integer getIdPracownika() {
        return idPracownika;
    }

    public void setIdPracownika(Integer idPracownika) {
        this.idPracownika = idPracownika;
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

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getNumerKontaBankowego() {
        return numerKontaBankowego;
    }

    public void setNumerKontaBankowego(String numerKontaBankowego) {
        this.numerKontaBankowego = numerKontaBankowego;
    }

    public Integer getPensja() {
        return pensja;
    }

    public void setPensja(Integer pensja) {
        this.pensja = pensja;
    }

    public Integer getIdZwierzchnika() {
        return idZwierzchnika;
    }

    public void setIdZwierzchnika(Integer idZwierzchnika) {
        this.idZwierzchnika = idZwierzchnika;
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
    public Collection<Zwierzchnicy> getZwierzchnicyCollection() {
        return zwierzchnicyCollection;
    }

    public void setZwierzchnicyCollection(Collection<Zwierzchnicy> zwierzchnicyCollection) {
        this.zwierzchnicyCollection = zwierzchnicyCollection;
    }

    public Grafik getIdGrafiku() {
        return idGrafiku;
    }

    public void setIdGrafiku(Grafik idGrafiku) {
        this.idGrafiku = idGrafiku;
    }

    public Sektory getIdSektora() {
        return idSektora;
    }

    public void setIdSektora(Sektory idSektora) {
        this.idSektora = idSektora;
    }

    public Stanowiska getIdStanowiska() {
        return idStanowiska;
    }

    public void setIdStanowiska(Stanowiska idStanowiska) {
        this.idStanowiska = idStanowiska;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPracownika != null ? idPracownika.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pracownicy)) {
            return false;
        }
        Pracownicy other = (Pracownicy) object;
        if ((this.idPracownika == null && other.idPracownika != null) || (this.idPracownika != null && !this.idPracownika.equals(other.idPracownika))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Pracownicy[ idPracownika=" + idPracownika + " ]";
    }
    
}
