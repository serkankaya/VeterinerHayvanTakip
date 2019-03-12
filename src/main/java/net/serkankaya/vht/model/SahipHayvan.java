package net.serkankaya.vht.model;

import java.util.List;

public class SahipHayvan {
	private long id;
	private String ad;
	private String soyad;
	private String adres;
	private String telefon;
	private String eposta;
	private List<String> hadi;
	


	public SahipHayvan() {
		
	}
	public SahipHayvan(long id, String ad, String soyad, String adres, String telefon, String eposta,
			List<String> hadi) {
		super();
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
		this.adres = adres;
		this.telefon = telefon;
		this.eposta = eposta;
		this.hadi = hadi;
	}
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
	public List<String> getHadi() {
		return hadi;
	}
	public void setHadi(List<String> hadi) {
		this.hadi = hadi;
	}



	
}
