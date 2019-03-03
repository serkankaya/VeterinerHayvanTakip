package net.serkankaya.vht.model.secure;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="authorities")
public class Yetkiler {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="VHTSegGen")
	@SequenceGenerator(name="VHTSegGen",sequenceName="vht_sequence")
	@Column(nullable=false)
	private String username;
	@Column(nullable=false)
	private String authority;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
