package net.serkankaya.vht.service;

import java.util.List;

import net.serkankaya.vht.model.Hayvan;

public interface VHTHayvanService {
	Hayvan getirIdIle(Long id);
	List<Hayvan> getirTumhayvanlari();
	void olustur(Hayvan hayvan);
	Hayvan guncelle(Hayvan hayvan);
	void sil(Long id);
}