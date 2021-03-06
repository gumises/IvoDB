package newdatabase;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class KategoriaId implements java.io.Serializable {

	private int fakturaId;
	private int towarId;
	private int ilosc;

	public KategoriaId() {
	}

	public KategoriaId(int fakturaId, int towarId, int ilosc) {
		this.fakturaId = fakturaId;
		this.towarId = towarId;
		this.ilosc = ilosc;
	}

	@Column(name = "faktura_id", nullable = false)
	public int getFakturaId() {
		return this.fakturaId;
	}

	public void setFakturaId(int fakturaId) {
		this.fakturaId = fakturaId;
	}

	@Column(name = "towar_id", nullable = false)
	public int getTowarId() {
		return this.towarId;
	}

	public void setTowarId(int towarId) {
		this.towarId = towarId;
	}

	@Column(name = "ilosc", nullable = false)
	public int getIlosc() {
		return this.ilosc;
	}

	public void setIlosc(int ilosc) {
		this.ilosc = ilosc;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof KategoriaId))
			return false;
		KategoriaId castOther = (KategoriaId) other;

		return (this.getFakturaId() == castOther.getFakturaId()) && (this.getTowarId() == castOther.getTowarId())
				&& (this.getIlosc() == castOther.getIlosc());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getFakturaId();
		result = 37 * result + this.getTowarId();
		result = 37 * result + this.getIlosc();
		return result;
	}

}
