package net.serkankaya.vht.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import net.serkankaya.vht.dao.HayvanRepository;
import net.serkankaya.vht.model.Hayvan;
import net.serkankaya.vht.model.HayvanSahip;
import net.serkankaya.vht.model.Sahip;

@Repository("hayvanRepository")
public class HayvanRepositoryJpaImpl implements HayvanRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Hayvan getirHayvanIdIle(Long id) {
		return entityManager.find(Hayvan.class, id);
	}

	@Override
	public List<Hayvan> getirTumhayvanlari() {
		return entityManager.createQuery("from Hayvan", Hayvan.class).getResultList();
	}

	@Override
	public void olustur(Hayvan hayvan) {
		entityManager.persist(hayvan);
	}

	@Override
	public Hayvan guncelle(Hayvan hayvan) {
		return entityManager.merge(hayvan);
	}

	@Override
	public void sil(Long id) {
		entityManager.remove(entityManager.getReference(Hayvan.class, id));

	}

	@Override
	public List<Hayvan> hayvanAdiIleAra(String ad) {
		return entityManager.createQuery("from Hayvan where lower(ad) LIKE lower(:hayvanAdi)", Hayvan.class)
				.setParameter("hayvanAdi", ad + "%").getResultList();
	}

	@Override
	public List<HayvanSahip> getirHayvanSahipList() {
		return entityManager.createQuery(
				"SELECT new net.serkankaya.vht.model.HayvanSahip (HAYVAN.hayvanID,HAYVAN.ad,HAYVAN.tur,HAYVAN.cins,HAYVAN.yas,HAYVAN.aciklama,CONCAT(SAHIP.ad,' ',SAHIP.soyad)AS SAD) FROM Hayvan AS HAYVAN LEFT JOIN Sahip as SAHIP ON HAYVAN.sahipID=SAHIP.id",
				HayvanSahip.class).getResultList();
	}

	@Override
	public void sahipAta(Long hayvanID, long sahipID) {
	entityManager.createQuery("UPDATE Hayvan AS HAYVAN SET HAYVAN.sahipID= :sahip_ID WHERE HAYVAN.hayvanID= :hayvan_ID")
		.setParameter("hayvan_ID", hayvanID)
		.setParameter("sahip_ID", sahipID).executeUpdate();
	}



}
