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
import net.serkankaya.vht.model.Sahip;
import net.serkankaya.vht.service.VHTHayvanService;
import net.serkankaya.vht.service.VHTSahipService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SahipServiceTest {

	@Autowired
	private VHTSahipService sahipService;

	//import.sql dosyasından görüleceği üzere 3 adet sahip bulunmakta ...
	@Test
	public void Test_1_ToplamSahipSayiKontrol1() {
		List<Sahip> sahipler = sahipService.getirTumSahipleri();
		Assert.assertEquals(3, sahipler.size());
	}

	@Test
	public void Test_2_sahipAdiİleAramaTest() {
		Sahip sahip = new Sahip();
		List<Sahip> sahipAramaSonucu = sahipService.getirSahipIsimİle("Serkan");
		Assert.assertTrue(sahipAramaSonucu.size() > 0);

	}

	
	@Test
	public void Test_3_sahipEklemeTest() {
		Sahip sahip = new Sahip();
		sahip.setAd("Merve");
		sahip.setSoyad("Gül");
		sahip.setAdres("Beşiktaş/İstanbul");
		sahip.setEposta("merve@gmail.com");
		sahip.setTelefon("+09009909090");
		sahipService.olustur(sahip);
		List<Sahip> sahipAramaSonucu = sahipService.getirSahipIsimİle("Merve");
		Assert.assertTrue(sahipAramaSonucu.size() > 0);
	}

	@Test
	public void Test_4_eklemeSonrasiToplamSahipSayiKontrol() {
		List<Sahip> sahipler = sahipService.getirTumSahipleri();
		Assert.assertEquals(4, sahipler.size());
	}

	@Test
	public void Test_5_eklenenSahibiSilme() {
		List<Sahip> sahipAramaSonucu = sahipService.getirSahipIsimİle("Merve");
		sahipService.silSahip(sahipAramaSonucu.get(0).getId());
		List<Sahip> AramaSonucuSilinmisSonuc = sahipService.getirSahipIsimİle("Merve");
		Assert.assertTrue(AramaSonucuSilinmisSonuc.size() == 0);
	}

	@Test
	public void Test_6_sahipGuncelleme() {
		List<Sahip> sahipAramaSonucu = sahipService.getirSahipIsimİle("Osman");
		Sahip sahip = new Sahip();
		if (sahipAramaSonucu.size() == 1) {
			sahip = sahipAramaSonucu.get(0);
			sahip.setAd("Mustafa");
		}
		sahipService.guncelle(sahip);
		List<Sahip> guncellenmisSahipSonucu = sahipService.getirSahipIsimİle("Mustafa");
		Assert.assertTrue(guncellenmisSahipSonucu.size() > 0);
	}

}
