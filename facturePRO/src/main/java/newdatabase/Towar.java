package newdatabase;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "towar", catalog = "ivodb")
public class Towar implements java.io.Serializable {

	private static final long serialVersionUID = -9032828248176914798L;
	
	private Integer id;
	private Vat vat;
	private String nazwa;
	private double cena;
	private Magazyn magazyn;
	private Set<Kategoria> kategorias = new HashSet(0);

	public Towar() {
	}

	public Towar(Vat vat, String nazwa, double cena) {
		this.vat = vat;
		this.nazwa = nazwa;
		this.cena = cena;
	}

	public Towar(Vat vat, String nazwa, long cena, Magazyn magazyn, Set<Kategoria> kategorias) {
		this.vat = vat;
		this.nazwa = nazwa;
		this.cena = cena;
		this.magazyn = magazyn;
		this.kategorias = kategorias;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vat_id", nullable = false)
	public Vat getVat() {
		return this.vat;
	}

	public void setVat(Vat vat) {
		this.vat = vat;
	}

	@Column(name = "nazwa", nullable = false, length = 100, unique = true)
	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	@Column(name = "cena", nullable = false, precision = 10, scale = 0)
	public double getCena() {
		return this.cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "towar")
	public Magazyn getMagazyn() {
		return this.magazyn;
	}

	public void setMagazyn(Magazyn magazyn) {
		this.magazyn = magazyn;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "towar")
	public Set<Kategoria> getKategorias() {
		return this.kategorias;
	}

	public void setKategorias(Set<Kategoria> kategorias) {
		this.kategorias = kategorias;
	}

	@Override
	public String toString() {
		return "Towar [id=" + id + ", vat=" + vat.getNazwa() + ", nazwa=" + nazwa + ", cena=" + cena + "]";
	}

	
}
