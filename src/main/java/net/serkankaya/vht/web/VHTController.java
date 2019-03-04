package net.serkankaya.vht.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.serkankaya.vht.service.VHTHayvanService;
import net.serkankaya.vht.service.VHTSahipService;

@Controller
public class VHTController {
	
	@Autowired
	private VHTSahipService vhtSahipService;
	
	@Autowired
	private VHTHayvanService vhtHayvanService;
	
	@RequestMapping("/sahip-tanitim")
	public ModelAndView getSahipler() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("sahipler",vhtSahipService.getirTumSahipleri());
		mav.setViewName("sahipTanitim");
		return mav;
	}
	@RequestMapping("/hayvan-tanitim")
	public ModelAndView getHayvanlar() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("hayvanlar",vhtHayvanService.getirTumhayvanlari());
		mav.setViewName("hayvanTanitim");
		return mav;
	}
	
	@RequestMapping("/login.html")
	public ModelAndView login() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping("/")
	public ModelAndView welcome() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping(value="hayvanSil/{hayvanID}",method=RequestMethod.GET)
	public String silHayvan(@PathVariable("hayvanID") long id) {
		vhtHayvanService.sil(id);
		return "redirect:/hayvan-tanitim";
	}
	
	@RequestMapping(value="sahipSil/{id}",method=RequestMethod.GET)
	public String silSahip(@PathVariable("id") long id) {
		vhtSahipService.silSahip(id);
		return "redirect:/sahip-tanitim";
	}
	
}
