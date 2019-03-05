package net.serkankaya.vht.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Hayvan")
@SequenceGenerator(name = Hayvan.SEQUENCE_NAME, sequenceName = Hayvan.SEQUENCE_NAME, initialValue =10,
allocationSize =100)
public class Hayvan {
	public static final String SEQUENCE_NAME = "HAYVAN_SEQUENCE_ID";
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	private long hayvanID;
	private String tur;
	private String cins;
	private String yas;
	private String aciklama;
	
//	@ManyToOne
//	@JoinColumn(name="sahipID")
//	private Sahip sahip;
	
//	public Sahip getSahip() {
//		return sahip;
//	}
//	public void setSahip(Sahip sahip) {
//		this.sahip = sahip;
//	}
	public long getHayvanID() {
		return hayvanID;
	}
	public void setHayvanID(long hayvanID) {
		this.hayvanID = hayvanID;
	}

	public String getTur() {
		return tur;
	}
	public void setTur(String tur) {
		this.tur = tur;
	}
	public String getCins() {
		return cins;
	}
	public void setCins(String cins) {
		this.cins = cins;
	}
	public String getYas() {
		return yas;
	}
	public void setYas(String yas) {
		this.yas = yas;
	}
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	@Override
	public String toString() {
		return "Hayvan [hayvanID=" + hayvanID + ", tur=" + tur + ", cins=" + cins + ", yas=" + yas + ", aciklama="
				+ aciklama + "]";
	}



}
