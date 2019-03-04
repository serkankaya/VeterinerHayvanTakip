package net.serkankaya.vht.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import net.serkankaya.vht.dao.HayvanRepository;
import net.serkankaya.vht.model.Hayvan;
@Service
@Transactional(rollbackFor=Exception.class)
public class VHTHayvanServiceImpl implements VHTHayvanService {

	private HayvanRepository hayvanRepository;
	
	@Autowired
	public void setHayvanRepository(HayvanRepository hayvanRepository) {
		this.hayvanRepository = hayvanRepository;
	}
	
	@Override
	public Hayvan getirIdIle(Long id) {
		return hayvanRepository.getirIdIle(id);
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

}
