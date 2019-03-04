package net.serkankaya.vht.service;

import java.util.List;

import net.serkankaya.vht.exception.SahipNotFoundException;
import net.serkankaya.vht.model.Sahip;

public interface VHTSahipService {
	List<Sahip> getirTumSahipleri();
	List<Sahip> getirSahipIsimİle(String ad);
	Sahip getirSahipIdIle(Long id) throws SahipNotFoundException;
	void olustur(Sahip sahip);
	void guncelle(Sahip sahip);
	void silSahip(Long id);
}
