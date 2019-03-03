package net.serkankaya.vht.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="Sahip")
@SequenceGenerator(name = Sahip.SAHIP_SEQUENCE_NAME, sequenceName = Sahip.SAHIP_SEQUENCE_NAME, initialValue =10,
allocationSize =100)
public class Sahip {
	public static final String SAHIP_SEQUENCE_NAME = "SAHIP_SEQUENCE_ID";
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SAHIP_SEQUENCE_NAME)
	private long id;
	private String ad;
	private String soyad;
	private String adres;
	private String telefon;
	private String eposta;

	@OneToMany(mappedBy="sahip")
	private Set<Hayvan> hayvanlar=new HashSet<>();
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getEposta() {
		return eposta;
	}
	public void setEposta(String eposta) {
		this.eposta = eposta;
	}
	@Override
	public String toString() {
		return "Sahip [id=" + id + ", ad=" + ad + ", soyad=" + soyad + ", adres=" + adres + ", telefon=" + telefon
				+ ", eposta=" + eposta + ", hayvanlar=" + hayvanlar + "]";
	}

	
}