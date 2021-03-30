package newdatabase;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "kategoria", catalog = "ivodb")
public class Kategoria implements java.io.Serializable {

	private KategoriaId id;
	private Faktura faktura;
	private Towar towar;

	public Kategoria() {
	}

	public Kategoria(KategoriaId id, Faktura faktura, Towar towar) {
		this.id = id;
		this.faktura = faktura;
		this.towar = towar;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "fakturaId", column = @Column(name = "faktura_id", nullable = false)),
			@AttributeOverride(name = "towarId", column = @Column(name = "towar_id", nullable = false)),
			@AttributeOverride(name = "ilosc", column = @Column(name = "ilosc", nullable = false)) })
	public KategoriaId getId() {
		return this.id;
	}

	public void setId(KategoriaId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "faktura_id", nullable = false, insertable = false, updatable = false)
	public Faktura getFaktura() {
		return this.faktura;
	}

	public void setFaktura(Faktura faktura) {
		this.faktura = faktura;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "towar_id", nullable = false, insertable = false, updatable = false)
	public Towar getTowar() {
		return this.towar;
	}

	public void setTowar(Towar towar) {
		this.towar = towar;
	}

}
