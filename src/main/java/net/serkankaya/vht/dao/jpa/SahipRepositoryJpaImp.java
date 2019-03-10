package net.serkankaya.vht.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import net.serkankaya.vht.dao.SahipRepository;
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
	return entityManager.createQuery("SELECT new net.serkankaya.vht.model.SahipHayvan(SAHIP.id AS ID,SAHIP.ad,SAHIP.soyad,SAHIP.adres,SAHIP.telefon,SAHIP.eposta,HAYVAN.ad AS HADI) FROM Sahip AS SAHIP INNER JOIN Hayvan as HAYVAN ON SAHIP.id=HAYVAN.hayvanID",SahipHayvan.class)
			.getResultList();
	}

}
