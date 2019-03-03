//package net.serkankaya.vht.dao.mem;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//import org.springframework.stereotype.Repository;
//
//import net.serkankaya.vht.dao.SahipRepository;
//import net.serkankaya.vht.model.Sahip;
//
//@Repository
//public class SahipRepositoryInMemoryImpl implements SahipRepository {
//
//	private Map<Long,Sahip> sahipMap=new HashMap<>();
//	
//	public SahipRepositoryInMemoryImpl() {
//		Sahip sahip1=new Sahip();
//		sahip1.setId(1L);
//		sahip1.setAd("Serkan");
//		sahip1.setSoyad("Kaya");
//		sahip1.setAdres("Avcılar");
//		sahip1.setEposta("serkankayatr@hotmail.com");
//		sahip1.setTelefon("05374806535");
//		
//		Sahip sahip2=new Sahip();
//		sahip2.setId(2L);
//		sahip2.setAd("Mehmet");
//		sahip2.setSoyad("Taşçı");
//		sahip2.setAdres("Beyoğlu");
//		sahip2.setEposta("mehmet@hotmail.com");
//		sahip2.setTelefon("05300000000");
//
//		
//		sahipMap.put(sahip1.getId(), sahip1);
//		sahipMap.put(sahip2.getId(), sahip2);
//		
//		
//	}
//	@Override
//	public List<Sahip> getirTumSahipleri() {
//		return new ArrayList<>(sahipMap.values());
//	}
//
//	@Override
//	public Sahip getirIdIle(long id) {
//		return sahipMap.get(id);
//	}
//
//	@Override
//	public List<Sahip> getirAdIle(String ad) {
//		return sahipMap.values().stream().filter(o->o.getAd().equals(ad)).collect(Collectors.toList());
//	}
//
//	@Override
//	public void olustur(Sahip sahip) {
//		sahip.setId(new Date().getTime());
//		sahipMap.put(sahip.getId(), sahip);
//	}
//
//	@Override
//	public Sahip guncelle(Sahip sahip) {
//		sahipMap.replace(sahip.getId(), sahip);
//		return sahip;
//	}
//
//	@Override
//	public void sil(Long id) {
//		sahipMap.remove(id);
//	}
//
//}
