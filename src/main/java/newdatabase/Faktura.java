package newdatabase;

import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "faktura", catalog = "ivodb")
public class Faktura implements java.io.Serializable {

	private Integer id;
	private Nabywca nabywca;
	private Date dataWystawienia;
	private Date dataZaplaty;
	private String numer;
	private Set<Kategoria> kategorias = new HashSet(0);

	public Faktura() {
	}

	public Faktura(Nabywca nabywca, Date dataWystawienia, String numer) {
		this.nabywca = nabywca;
		this.dataWystawienia = dataWystawienia;
		this.numer = numer;
	}

	public Faktura(Nabywca nabywca, Date dataWystawienia, Date dataZaplaty, String numer, Set<Kategoria> kategorias) {
		this.nabywca = nabywca;
		this.dataWystawienia = dataWystawienia;
		this.dataZaplaty = dataZaplaty;
		this.numer = numer;
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
	@JoinColumn(name = "nabywca_id", nullable = false)
	public Nabywca getNabywca() {
		return this.nabywca;
	}

	public void setNabywca(Nabywca nabywca) {
		this.nabywca = nabywca;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_wystawienia", nullable = false, length = 10)
	public Date getDataWystawienia() {
		return this.dataWystawienia;
	}

	public void setDataWystawienia(Date dataWystawienia) {
		this.dataWystawienia = dataWystawienia;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_zaplaty", length = 10)
	public Date getDataZaplaty() {
		return this.dataZaplaty;
	}

	public void setDataZaplaty(Date dataZaplaty) {
		this.dataZaplaty = dataZaplaty;
	}

	@Column(name = "numer", nullable = false, length = 20)
	public String getNumer() {
		return this.numer;
	}

	public void setNumer(String numer) {
		this.numer = numer;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "faktura")
	public Set<Kategoria> getKategorias() {
		return this.kategorias;
	}

	public void setKategorias(Set<Kategoria> kategorias) {
		this.kategorias = kategorias;
	}

}
