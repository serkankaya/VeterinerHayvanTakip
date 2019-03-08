package net.serkankaya.vht.dao;

import java.util.List;

import net.serkankaya.vht.model.Hayvan;

public interface HayvanRepository {
	Hayvan getirHayvanIdIle(Long id);
	List<Hayvan> getirTumhayvanlari();
	List<Hayvan> hayvanAdiIleAra(String ad);
	void olustur(Hayvan hayvan);
	Hayvan guncelle(Hayvan hayvan);
	void sil(Long id);
}
