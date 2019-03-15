package net.serkankaya.vht.test;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.serkankaya.vht.model.Hayvan;
import net.serkankaya.vht.model.HayvanSahip;
import net.serkankaya.vht.service.VHTHayvanService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HayvanServiceTest {

	//import.sql dosyasından görüleceği üzere 3 adet hayvan bulunmakta ...
	@Autowired
	private VHTHayvanService hayvanService;

	@Test
	public void Test_1_ToplamHayvanSayiKontrol1() {
		List<Hayvan> hayvanlar = hayvanService.getirTumhayvanlari();
		Assert.assertEquals(3, hayvanlar.size());
	}

	@Test
	public void Test_2_hayvanAdiİleAramaTest() {
		Hayvan hayvan = new Hayvan();
		List<Hayvan> hayvanAramaSonucu = hayvanService.getirHayvanAdiIle("Limon");
		Assert.assertTrue(hayvanAramaSonucu.size() > 0);

	}

	
	@Test
	public void Test_3_hayvanEklemeTest() {
		Hayvan hayvan = new Hayvan();
		hayvan.setAd("Minik");
		hayvan.setCins("Hamster");
		hayvan.setTur("Gonzales");
		hayvan.setAciklama(
				"Ömrü en fazla 2-2.5 yıl süren bu küçük canlıların kilosu en fazla 60 ile 70 gr. arasında değişir. Boyutları ise Hamsterların hemen hemen yarısıdır. 10 cm.’ye kadar uzayabilirler.");
		hayvan.setYas("1");
		hayvanService.olustur(hayvan);
		List<Hayvan> hayvanAramaSonucu = hayvanService.getirHayvanAdiIle("Minik");
		Assert.assertTrue(hayvanAramaSonucu.size() > 0);
	}

	@Test
	public void Test_4_eklemeSonrasiToplamHayvanSayiKontrol() {
		List<Hayvan> hayvanlar = hayvanService.getirTumhayvanlari();
		Assert.assertEquals(4, hayvanlar.size());
	}

	@Test
	public void Test_5_eklenenHayvaniSilme() {
		List<Hayvan> hayvanAramaSonucu = hayvanService.getirHayvanAdiIle("Minik");
		hayvanService.sil(hayvanAramaSonucu.get(0).getHayvanID());
		List<Hayvan> hayvanAramaSonucuSilinmisSonuc = hayvanService.getirHayvanAdiIle("Minik");
		Assert.assertTrue(hayvanAramaSonucuSilinmisSonuc.size() == 0);
	}

	@Test
	public void Test_6_hayvanGuncelleme() {
		List<Hayvan> hayvanAramaSonucu = hayvanService.getirHayvanAdiIle("Pamuk");
		Hayvan hayvan = new Hayvan();
		if (hayvanAramaSonucu.size() == 1) {
			hayvan = hayvanAramaSonucu.get(0);
			hayvan.setAd("Badem");
		}
		hayvanService.guncelle(hayvan);
		List<Hayvan> guncellenmisHayvanSonucu = hayvanService.getirHayvanAdiIle("Badem");
		Assert.assertTrue(guncellenmisHayvanSonucu.size() > 0);
	}

	@Test
	public void Test_7_sahipAtama() {
		List<Hayvan> hayvanAramaSonucu = hayvanService.getirHayvanAdiIle("Pamuk");
		Hayvan hayvan = new Hayvan();
		if (hayvanAramaSonucu.size() == 1) {
			hayvan = hayvanAramaSonucu.get(0);
		}
		// ID 'si 3 olan Osman Oluk'u yeni sahibi yapıyoruz.
		hayvanService.sahipAta(hayvan.getHayvanID(), 3);
		List<HayvanSahip> atamaYapilmisHayvanSonucu = hayvanService.getirHayvanSahipList();
		for (int i = 0; i < atamaYapilmisHayvanSonucu.size(); i++) {
			if (atamaYapilmisHayvanSonucu.get(i).getAd().equals("Pamuk")) {
				Assert.assertTrue(atamaYapilmisHayvanSonucu.get(i).getSad().equals("Osman"));
			}
		}

	}

}
