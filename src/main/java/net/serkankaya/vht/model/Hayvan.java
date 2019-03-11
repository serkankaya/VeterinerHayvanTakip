package net.serkankaya.vht.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="Hayvan")
@SequenceGenerator(name = Hayvan.SEQUENCE_NAME, sequenceName = Hayvan.SEQUENCE_NAME, initialValue =10,
allocationSize =100)
public class Hayvan {
	public static final String SEQUENCE_NAME = "HAYVAN_SEQUENCE_ID";
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	private long hayvanID;
	private String ad;
	private String tur;
	private String cins;
	private String yas;
	private String aciklama;
	private long sahipID;
	
	public long getHayvanID() {
		return hayvanID;
	}
	public long getSahipID() {
		return sahipID;
	}

	public void setSahipID(long sahipID) {
		this.sahipID = sahipID;
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
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	
	@Override
	public String toString() {
		return "Hayvan [hayvanID=" + hayvanID + ", ad=" + ad + ", tur=" + tur + ", cins=" + cins + ", yas=" + yas
				+ ", aciklama=" + aciklama + "]";
	}






}
