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
@Table(name = "magazyn", catalog = "ivodb")
public class Magazyn implements java.io.Serializable {

	private int towarId;
	private Towar towar;
	private int ilosc;

	public Magazyn() {
	}

	public Magazyn(Towar towar, int ilosc) {
		this.towar = towar;
		this.ilosc = ilosc;
	}

	@GenericGenerator(name = "newdatabase.MagazynIdGenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "towar"))
	@Id
	@GeneratedValue(generator = "newdatabase.MagazynIdGenerator")

	@Column(name = "towar_id", unique = true, nullable = false)
	public int getTowarId() {
		return this.towarId;
	}

	public void setTowarId(int towarId) {
		this.towarId = towarId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Towar getTowar() {
		return this.towar;
	}

	public void setTowar(Towar towar) {
		this.towar = towar;
	}

	@Column(name = "ilosc", nullable = false)
	public int getIlosc() {
		return this.ilosc;
	}

	public void setIlosc(int ilosc) {
		this.ilosc = ilosc;
	}

	@Override
	public String toString() {
		return "Magazyn [towarId=" + towarId + ", towar=" + towar + ", ilosc=" + ilosc + "]";
	}
}
