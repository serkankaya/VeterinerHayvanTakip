package net.serkankaya.vht.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import net.serkankaya.vht.dao.SahipRepository;
import net.serkankaya.vht.model.Hayvan;
import net.serkankaya.vht.model.HayvanListesi;
import net.serkankaya.vht.model.HayvanSahip;
import net.serkankaya.vht.model.Sahip;
import net.serkankaya.vht.model.SahipHayvan;

@Repository("sahipRepository")
public class SahipRepositoryJpaImp implements SahipRepository {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Sahip> getirTumSahipleri() {
		return entityManager.createQuery("from Sahip",Sahip.class).getResultList();
	}

	@Override
	public Sahip getirIdIle(long id) {
		return entityManager.find(Sahip.class,id);
	}

	@Override
	public List<Sahip> getirAdIle(String ad) {
		return entityManager.createQuery("from Sahip where lower(ad) LIKE lower(:sahipAdi)",Sahip.class)
				.setParameter("sahipAdi", ad+"%")
				.getResultList();
	}

	@Override
	public void olustur(Sahip sahip) {
		entityManager.persist(sahip);
	}

	@Override
	public Sahip guncelle(Sahip sahip) {
		return entityManager.merge(sahip);
	}

	@Override
	public void sil(Long id) {
		entityManager.remove(entityManager.getReference(Sahip.class, id));
	}

	@Override
	public List<SahipHayvan> getirSahipHayvanList() {
		List<Sahip> sahip=getirTumSahipleri();
		List<SahipHayvan> sahipHayvanList = new ArrayList<SahipHayvan>();
		for (int i = 0; i < sahip.size(); i++) {
			SahipHayvan data=new SahipHayvan();
			List<Hayvan> hayvanListesiHazirlik=new ArrayList<>();
			data.setId(sahip.get(i).getId());
			data.setAd(sahip.get(i).getAd());
			data.setAdres(sahip.get(i).getAdres());
			data.setSoyad(sahip.get(i).getSoyad());
			data.setEposta(sahip.get(i).getEposta());
			data.setTelefon(sahip.get(i).getTelefon());
			hayvanListesiHazirlik= entityManager.createQuery("from Hayvan where SAHIPID = :sid",Hayvan.class).setParameter("sid", sahip.get(i).getId()).getResultList();
			List<String> hayvanListesi=new ArrayList<>();
			for (int j = 0; j < hayvanListesiHazirlik.size(); j++) {
				hayvanListesi.add(hayvanListesiHazirlik.get(j).getAd().toString());
			}
			data.setHadi(hayvanListesi);
			sahipHayvanList.add(data);
		}
		return sahipHayvanList;
	}

}
