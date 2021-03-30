package newdatabase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "adres", catalog = "ivodb")
public class Adres implements java.io.Serializable {

	private int nabywcaId;
	private Nabywca nabywca;
	private String kodPocztowy;
	private String miejscowosc;
	private String ulica;
	private String numerDomu;

	public Adres() {
	}

	public Adres(Nabywca nabywca, String kodPocztowy, String miejscowosc, String ulica, String numerDomu) {
		this.nabywca = nabywca;
		this.kodPocztowy = kodPocztowy;
		this.miejscowosc = miejscowosc;
		this.ulica = ulica;
		this.numerDomu = numerDomu;
	}

	@GenericGenerator(name = "newdatabase.AdresIdGenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "nabywca"))
	@Id
	@GeneratedValue(generator = "newdatabase.AdresIdGenerator")

	@Column(name = "nabywca_id", unique = true, nullable = false)
	public int getNabywcaId() {
		return this.nabywcaId;
	}

	public void setNabywcaId(int nabywcaId) {
		this.nabywcaId = nabywcaId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Nabywca getNabywca() {
		return this.nabywca;
	}

	public void setNabywca(Nabywca nabywca) {
		this.nabywca = nabywca;
	}

	@Column(name = "kod_pocztowy", nullable = false, length = 6)
	public String getKodPocztowy() {
		return this.kodPocztowy;
	}

	public void setKodPocztowy(String kodPocztowy) {
		this.kodPocztowy = kodPocztowy;
	}

	@Column(name = "miejscowosc", nullable = false, length = 100)
	public String getMiejscowosc() {
		return this.miejscowosc;
	}

	public void setMiejscowosc(String miejscowosc) {
		this.miejscowosc = miejscowosc;
	}

	@Column(name = "ulica", nullable = false, length = 100)
	public String getUlica() {
		return this.ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	@Column(name = "numer_domu", nullable = false, length = 10)
	public String getNumerDomu() {
		return this.numerDomu;
	}

	public void setNumerDomu(String numerDomu) {
		this.numerDomu = numerDomu;
	}

}
