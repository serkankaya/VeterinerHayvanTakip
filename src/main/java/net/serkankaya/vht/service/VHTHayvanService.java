package net.serkankaya.vht.service;

import java.util.List;

import net.serkankaya.vht.model.Hayvan;
import net.serkankaya.vht.model.HayvanSahip;

public interface VHTHayvanService {
	Hayvan getirIdIle(Long id);
	List<Hayvan> getirTumhayvanlari();
	List<Hayvan> getirHayvanAdiIle(String ad);
	List<HayvanSahip> getirHayvanSahipList();
	void olustur(Hayvan hayvan);
	Hayvan guncelle(Hayvan hayvan);
	void sil(Long id);
}
