package net.serkankaya.vht.dao;

import java.util.List;

import net.serkankaya.vht.model.Hayvan;

public interface HayvanRepository {
	Hayvan getirIdIle(Long id);
	List<Hayvan> getirTumhayvanlari();
	void olustur(Hayvan hayvan);
	Hayvan guncelle(Hayvan hayvan);
	void delete(Long id);
}
