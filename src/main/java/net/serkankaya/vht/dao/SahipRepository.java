package net.serkankaya.vht.dao;

import java.util.List;

import net.serkankaya.vht.model.Sahip;

public interface SahipRepository {
	List<Sahip> getirTumSahipleri();
	List<Sahip> getirAdIle(String ad);
	Sahip getirIdIle(long id);
	void olustur(Sahip sahip);
	Sahip guncelle(Sahip sahip);
	void sil(Long id);
}
