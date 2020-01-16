package database.mapped;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="towar")
public class Towar {
	
	@Id
    @GeneratedValue
    @Column(name="id")
    private int id;

	@Column(name="nazwa")
    private String nazwa;
    
    @Column(name="cena")
    private double cena;
    
    @OneToOne
    @MapsId
    @JoinColumn(name="vat_id")
    private Vat vat;
    
    //@OneToOne(mappedBy = "towar")
    //@PrimaryKeyJoinColumn
    //private Magazyn magazyn;
    
	public Towar() {
		super();
	}

	public Towar(String nazwa, double cena, Vat vat) {
		super();
		this.nazwa = nazwa;
		this.cena = cena;
		this.vat = vat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public Vat getVat() {
		return vat;
	}

	public void setVat(Vat vat) {
		this.vat = vat;
	}
	
	@Override
	public String toString() {
		return 
				"id: '" + this.id + 
				"',  nazwa: '" + this.nazwa + 
				"',  cena: '" + this.cena + 
				"',  vat: '" + this.vat.getNazwa() + "'";
	}
}
