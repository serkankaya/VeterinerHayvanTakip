package net.serkankaya.vht.model;

public class HayvanSahip {
	private long hayvanID;
	private String ad;
	private String tur;
	private String cins;
	private String yas;
	private String aciklama;
	private String sad;

	public HayvanSahip() {

	}

	public HayvanSahip(long hayvanID, String ad, String tur, String cins, String yas, String aciklama, String sad) {
		super();
		this.hayvanID = hayvanID;
		this.ad = ad;
		this.tur = tur;
		this.cins = cins;
		this.yas = yas;
		this.aciklama = aciklama;
		this.sad = sad;
	}

	public long getHayvanID() {
		return hayvanID;
	}

	public void setHayvanID(long hayvanID) {
		this.hayvanID = hayvanID;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
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

	public String getSad() {
		return sad;
	}

	public void setSad(String sad) {
		this.sad = sad;
	}
}