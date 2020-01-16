package database.mapped;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*****************************
CREATE TABLE `vat` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nazwa` VARCHAR(20) NOT NULL,
	`mnoznik` DECIMAL NOT NULL,
	PRIMARY KEY (`id`)
);
 *****************************/

@Entity
@Table(name="vat")
public class Vat {
	
	@Id
    @GeneratedValue
    @Column(name="id")
    private int id;

	@Column(name="nazwa")
    private String nazwa;
    
    @Column(name="mnoznik")
    private double mnoznik;

    public Vat() {
		super();
	}

	public Vat(String nazwa, double mnoznik) {
		super();
		this.nazwa = nazwa;
		this.mnoznik = mnoznik;
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

	public double getMnoznik() {
		return mnoznik;
	}

	public void setMnoznik(double mnoznik) {
		this.mnoznik = mnoznik;
	}
	
	@Override
	public String toString() {
		return "id: '" + this.id + "',  nazwa: '" + this.nazwa + "',  mnoznik: '" + this.mnoznik + "'";
	}
}
