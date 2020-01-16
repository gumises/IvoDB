package database.mapped;

import java.io.Serializable;

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
@Table(name="magazyn")
public class Magazyn implements Serializable{
	
	//@Id
	//@Column(name="towar_id")
    //private int id;

	private static final long serialVersionUID = 7974073489797608662L;

	@Column(name="ilosc")
    private int ilosc;
    
	@Id
    @OneToOne
    @MapsId
    @JoinColumn(name="towar_id")
    private Towar towar;

    public Magazyn() {
    	
    }
    
	public Magazyn(int ilosc, Towar towar) {
		super();
		this.ilosc = ilosc;
		this.towar = towar;
	}

	public int getIlosc() {
		return ilosc;
	}

	public void setIlosc(int ilosc) {
		this.ilosc = ilosc;
	}

	public Towar getTowar() {
		return towar;
	}

	public void setTowar(Towar towar) {
		this.towar = towar;
	}

	@Override
	public String toString() {
		return "Magazyn [ilosc=" + ilosc + ", towar=" + towar.getNazwa() + "]";
	}
}
