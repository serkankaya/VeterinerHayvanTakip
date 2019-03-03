package net.serkankaya.vht.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.serkankaya.vht.service.VHTService;

@Controller
public class VHTController {
	
	@Autowired
	private VHTService vhtService;
	
	@RequestMapping("/")
	public ModelAndView getSahipler() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("sahipler",vhtService.getirTumSahipleri());
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/login.html")
	public ModelAndView login() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	
//	@RequestMapping("/welcome")
//	@ResponseBody
//	public String welcome() {
//		return "Veteriner Hayvan Takip - Hoşgeldiniz";
//	}
	
}
