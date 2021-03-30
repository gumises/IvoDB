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
import javax.persistence.Table;


@Entity
@Table(name = "vat", catalog = "ivodb")
public class Vat implements java.io.Serializable {

	private static final long serialVersionUID = 7827639718863961197L;
	
	private Integer id;
	private String nazwa;
	private Integer mnoznik;
	private Set<Towar> towars = new HashSet(0);

	public Vat() {
	}

	public Vat(String nazwa, int mnoznik) {
		this.nazwa = nazwa;
		this.mnoznik = mnoznik;
	}

	public Vat(String nazwa, int mnoznik, Set<Towar> towars) {
		this.nazwa = nazwa;
		this.mnoznik = mnoznik;
		this.towars = towars;
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

	@Column(name = "nazwa", nullable = false, length = 20)
	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	@Column(name = "mnoznik", nullable = false, precision = 10, scale = 0)
	public int getMnoznik() {
		return this.mnoznik;
	}

	public void setMnoznik(int mnoznik) {
		this.mnoznik = mnoznik;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vat")
	public Set<Towar> getTowars() {
		return this.towars;
	}

	public void setTowars(Set towars) {
		this.towars = towars;
	}

	//@Override
	//public String toString() {
	//	return "Vat [id=" + id + ", nazwa=" + nazwa + ", mnoznik=" + mnoznik + "]";
	//}

}
