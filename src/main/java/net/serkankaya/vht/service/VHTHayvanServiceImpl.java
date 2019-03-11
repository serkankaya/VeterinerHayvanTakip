package net.serkankaya.vht.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import net.serkankaya.vht.dao.HayvanRepository;
import net.serkankaya.vht.model.Hayvan;
import net.serkankaya.vht.model.HayvanSahip;
@Service
@Transactional(rollbackFor=Exception.class)
public class VHTHayvanServiceImpl implements VHTHayvanService {

	@Autowired
	private HayvanRepository hayvanRepository;
	
	@Override
	public Hayvan getirIdIle(Long id) {
		return hayvanRepository.getirHayvanIdIle(id);
	}

	@Override
	public List<Hayvan> getirTumhayvanlari() {
		return hayvanRepository.getirTumhayvanlari();
	}

	@Override
	public void olustur(Hayvan hayvan) {
		hayvanRepository.olustur(hayvan);
	}

	@Override
	public Hayvan guncelle(Hayvan hayvan) {
		return hayvanRepository.guncelle(hayvan);
	}

	@Override
	public void sil(Long id) {
		hayvanRepository.sil(id);
	}

	@Override
	public List<Hayvan> getirHayvanAdiIle(String ad) {
		return hayvanRepository.hayvanAdiIleAra(ad);
	}

	@Override
	public List<HayvanSahip> getirHayvanSahipList() {
		return hayvanRepository.getirHayvanSahipList();
	}

	@Override
	public void sahipAta(Long hayvanID, long sahipID) {
		hayvanRepository.sahipAta(hayvanID, sahipID);
	}

}
