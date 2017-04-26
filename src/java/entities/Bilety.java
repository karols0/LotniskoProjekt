/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Karol
 */
@Entity
@Table(name = "BILETY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bilety.findAll", query = "SELECT b FROM Bilety b"),
    @NamedQuery(name = "Bilety.findByIdBiletu", query = "SELECT b FROM Bilety b WHERE b.idBiletu = :idBiletu"),
    @NamedQuery(name = "Bilety.findByIdKlienta", query = "SELECT b FROM Bilety b WHERE b.idKlienta = :idKlienta"),
    @NamedQuery(name = "Bilety.findByKlasa", query = "SELECT b FROM Bilety b WHERE b.klasa = :klasa"),
    @NamedQuery(name = "Bilety.findByCena", query = "SELECT b FROM Bilety b WHERE b.cena = :cena"),
    @NamedQuery(name = "Bilety.findByCzyZaplacono", query = "SELECT b FROM Bilety b WHERE b.czyZaplacono = :czyZaplacono")})
public class Bilety implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_BILETU")
    private Integer idBiletu;
    @Column(name = "KLASA")
    private Integer klasa;
    @Column(name = "CENA")
    private Integer cena;
    @Column(name = "CZY_ZAPLACONO")
    private Boolean czyZaplacono;
    @JoinColumn(name = "ID_KLIENTA", referencedColumnName = "ID_KLIENTA")
    @ManyToOne(cascade = CascadeType.ALL)
    private Klienci idKlienta;
    @JoinColumn(name = "ID_LOTU", referencedColumnName = "ID_LOTU")
    @ManyToOne(cascade = CascadeType.ALL)
    private Loty idLotu;

    public Bilety() {
    }

    public Bilety(Integer idBiletu) {
        this.idBiletu = idBiletu;
    }

    public Integer getIdBiletu() {
        return idBiletu;
    }

    public void setIdBiletu(Integer idBiletu) {
        this.idBiletu = idBiletu;
    }

    public Integer getKlasa() {
        return klasa;
    }

    public void setKlasa(Integer klasa) {
        this.klasa = klasa;
    }

    public Integer getCena() {
        return cena;
    }

    public void setCena(Integer cena) {
        this.cena = cena;
    }

    public Boolean getCzyZaplacono() {
        return czyZaplacono;
    }

    public void setCzyZaplacono(Boolean czyZaplacono) {
        this.czyZaplacono = czyZaplacono;
    }

    public Klienci getIdKlienta() {
        return idKlienta;
    }

    public void setIdKlienta(Klienci idKlienta) {
        this.idKlienta = idKlienta;
    }

    public Loty getIdLotu() {
        return idLotu;
    }

    public void setIdLotu(Loty idLotu) {
        this.idLotu = idLotu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBiletu != null ? idBiletu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bilety)) {
            return false;
        }
        Bilety other = (Bilety) object;
        if ((this.idBiletu == null && other.idBiletu != null) || (this.idBiletu != null && !this.idBiletu.equals(other.idBiletu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Bilety[ idBiletu=" + idBiletu + " ]";
    }
    
}
