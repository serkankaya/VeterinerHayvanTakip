# VeterinerHayvanTakip

Veteriner Hayvan Takip yazılımı Spring Boot kullanımını örneklemek amacı ile yazılmıştır.

Kullanılan Teknolojiler ;

* Maven
* Bootstrap
* Spring Boot
* JPA-Hibernate
* Tomcat(Gömülü)
* Spring Security
* Java Server Pages
* H2 Veritabanı(Gömülü)
* Spring Tool Suit(IDE)

**Proje Senaryosu**
Veterinerin Kullanabileceği basit bir hayvan takip web yazılımı projesi ;

* Hayvan tanıtımı ( ad , tür, cins, isim, yaş, açıklama )
* Hayvan Sahibi tanıtımı ( ad soyad, iletişim bilgileri, telefon, e-posta )
* Hayvan adı ya da hayvan sahibi adı üzerinden aranabilmeli
* Bir hayvan sahibine n adet hayvan tanımı yapılabilmeli
* Var olan bir kayıt üzerinde değişiklik yapılabilmeli
* Var olan kayıtlar incelebilmeli
* Var olan bir kayıt silinebilmeli
* Birim testi olmalı
* Kullanıcılar sisteme kullanıcı adı/parola ile giriş yapmalı
* Bir yetkilendirme mekanizması içermeli. Kullanıcılar kayıt oluşturabilsin ilişkilendirebilsin fakat silemesin. Yönetici tüm eylemleri gerçekleştirebilsin.

**Projeden WAR dosyası oluşturma ve terminalden çalıştırma ;**

![](/gorsel-veri/war-hazirlama-ve-calistirma.gif)

**NOT:** War Dosyasını proje içerisinde bırakıyorum.IDE ile uğraşmak istemez iseniz Java yüklü cihazda aşağıdaki komut ile IDE kullanmadan test edebilirsiniz ;

**java -jar VeterinerHayvanTakip.war**


**Proje Tanitim 1**
![](/gorsel-veri/proje-tanitim-1.gif)
**Proje Tanitim 2**
![](/gorsel-veri/proje-tanitim-2.gif)
**Proje Tanitim 3**
![](/gorsel-veri/proje-tanitim-3.gif)

**Birim Testleri**
Proje içerisinde 2 adet Birim testi bulunmakta.Bunlar ;
* Hayvan Servisi için Test;
![](/gorsel-veri/hayvan-servisi-birim-test.gif)
* Hayvan Sahibi için Test;
![](/gorsel-veri/sahip-servisi-birim-test.gif)

**Gerekli Kullanıcı Bilgileri**
ADMIN
Kullanıcı Adı : admin
şifre	      : admin
USER
Kullanıcı Adı : user
şifre	      : user




