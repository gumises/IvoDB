package newdatabase;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "nabywca", catalog = "ivodb")
public class Nabywca implements java.io.Serializable {

	private Integer id;
	private String telefon;
	private String nip;
	private String nazwa;

	private Set<Faktura> fakturas = new HashSet(0);
	private Adres adres;

	public Nabywca() {
	}

	public Nabywca(String nazwa, String telefon, String nip) {
		this.nazwa = nazwa;
		this.telefon = telefon;
		this.nip = nip;
	}

	public Nabywca(String telefon, String nip, Set<Faktura> fakturas, Adres adres) {
		this.telefon = telefon;
		this.nip = nip;
		this.fakturas = fakturas;
		this.adres = adres;
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

	@Column(name = "telefon", nullable = false, length = 20)
	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	@Column(name = "nip", nullable = false, length = 20)
	public String getNip() {
		return this.nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nabywca")
	public Set<Faktura> getFakturas() {
		return this.fakturas;
	}

	public void setFakturas(Set fakturas) {
		this.fakturas = fakturas;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "nabywca")
	public Adres getAdres() {
		return this.adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}
	
	@Column(name = "nazwa", unique = true, nullable = false, length = 100)
	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	@Override
	public String toString() {
		return "Nabywca [id=" + id + ", telefon=" + telefon + ", nip=" + nip + ", nazwa=" + nazwa + "]";
	}
}
