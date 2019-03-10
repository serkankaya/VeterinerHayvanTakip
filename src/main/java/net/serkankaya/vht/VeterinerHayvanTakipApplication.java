package net.serkankaya.vht;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("net.serkankaya.vht")
public class VeterinerHayvanTakipApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeterinerHayvanTakipApplication.class, args);
	}

}
