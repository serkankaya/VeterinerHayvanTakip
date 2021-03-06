package net.serkankaya.vht.dao;

import java.util.List;

import net.serkankaya.vht.model.Hayvan;
import net.serkankaya.vht.model.HayvanSahip;
import net.serkankaya.vht.model.Sahip;

public interface HayvanRepository {
	Hayvan getirHayvanIdIle(Long id);
	List<Hayvan> getirTumhayvanlari();
	List<Hayvan> hayvanAdiIleAra(String ad);
	void olustur(Hayvan hayvan);
	Hayvan guncelle(Hayvan hayvan);
	void sil(Long id);
	List<HayvanSahip> getirHayvanSahipList();
	void sahipAta(Long hayvanID,long sahipID);
}
