package net.serkankaya.vht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.serkankaya.vht.dao.SahipRepository;
import net.serkankaya.vht.exception.SahipNotFoundException;
import net.serkankaya.vht.model.Sahip;
import net.serkankaya.vht.model.SahipHayvan;
@Service
@Transactional(rollbackFor=Exception.class)
public class VHTSahipServiceImpl implements VHTSahipService {

	@Autowired
	private SahipRepository sahipRepository;
	
	@Override
	public List<Sahip> getirTumSahipleri() {
		return sahipRepository.getirTumSahipleri();
	}

	@Override
	public List<Sahip> getirSahipIsimİle(String ad) {
		return sahipRepository.getirAdIle(ad);
	}

	@Override
	public Sahip getirSahipIdIle(Long id) throws SahipNotFoundException {
		Sahip sahip=sahipRepository.getirIdIle(id);
		if (sahip==null) throw new SahipNotFoundException("Sahip Bulunamadı ... id : " + id);
		return sahip;
	}

	@Override
	public void olustur(Sahip sahip) {
		sahipRepository.olustur(sahip);

	}

	@Override
	public void guncelle(Sahip sahip) {
		sahipRepository.guncelle(sahip);

	}

	@Override
	public void silSahip(Long id) {
		sahipRepository.sil(id);

	}

	@Override
	public List<SahipHayvan> getirSahipHayvanList() {
		return sahipRepository.getirSahipHayvanList();
	}

}
