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

**NOT:** War Dosyasını proje içerisinde bırakıyorum(VeterinerHayvanTakip.war).IDE ile uğraşmak istemez iseniz Java yüklü cihazda aşağıdaki komut ile IDE kullanmadan test edebilirsiniz ;</br>

**java -jar VeterinerHayvanTakip.war**</br>


**Proje Tanitim Gorsel 1**</br>
![](/gorsel-veri/proje-tanitim-1.gif)</br>
**Proje Tanitim Gorsel 2**</br>
![](/gorsel-veri/proje-tanitim-2.gif)</br>
**Proje Tanitim Gorsel 3**</br>
![](/gorsel-veri/proje-tanitim-3.gif)</br>
**Birim Testleri**</br>
Proje içerisinde 2 adet Birim testi bulunmakta.Bunlar ;</br>
* Hayvan Servisi için görsel Test;</br>
![](/gorsel-veri/hayvan-servisi-birim-test.gif)
* Hayvan Sahibi için görsel Test;</br>
![](/gorsel-veri/sahip-servisi-birim-test.gif)

**Gerekli Kullanıcı Bilgileri**
*ADMIN kullanıcısı için;*</br>
**Kullanıcı Adı :** admin</br>
**Şifre	      :** admin</br>
*USER kullanıcısı için;*</br>
**Kullanıcı Adı :** user</br>
**şifre	      :** user</br>




