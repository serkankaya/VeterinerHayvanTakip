package net.serkankaya.vht.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.serkankaya.vht.model.Sahip;
import net.serkankaya.vht.service.VHTService;

@Controller
public class YeniSahipController {
	
	@Autowired
	private VHTService vhtService;
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value="/sahip/yeni",method=RequestMethod.GET)
	public String yeniSahip() {
		return "yeniSahip";
	}
	
	@ModelAttribute
	public Sahip initModel() {
		return new Sahip();
	}
	
	@RequestMapping(value="/sahip/yeni",method=RequestMethod.POST)
	public String handleFormSubmit(@ModelAttribute Sahip sahip) {
		vhtService.olustur(sahip);
		return "redirect:/";
	}
}
