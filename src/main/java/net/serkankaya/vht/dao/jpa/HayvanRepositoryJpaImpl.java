package net.serkankaya.vht.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.serkankaya.vht.dao.HayvanRepository;
import net.serkankaya.vht.model.Hayvan;
import net.serkankaya.vht.model.Sahip;

@Repository("hayvanRepository")
public class HayvanRepositoryJpaImpl implements HayvanRepository {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Hayvan getirIdIle(Long id) {
		return entityManager.find(Hayvan.class,id);
	}

	@Override
	public List<Hayvan> getirTumhayvanlari() {
		return entityManager.createQuery("from Hayvan",Hayvan.class).getResultList();
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

}
