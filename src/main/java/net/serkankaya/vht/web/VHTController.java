package net.serkankaya.vht.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.serkankaya.vht.model.Hayvan;
import net.serkankaya.vht.model.Sahip;
import net.serkankaya.vht.model.SahipAta;
import net.serkankaya.vht.service.VHTHayvanService;
import net.serkankaya.vht.service.VHTSahipService;

@Controller
public class VHTController {
	Logger logger = LoggerFactory.getLogger(VHTController.class);

	@Autowired
	private VHTSahipService vhtSahipService;

	@Autowired
	private VHTHayvanService vhtHayvanService;

	@RequestMapping("/sahip-tanitim")
	public ModelAndView getSahipler() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("sahipler", vhtSahipService.getirSahipHayvanList());
		mav.setViewName("sahipTanitim");
		return mav;
	}

	@RequestMapping("/hayvan-tanitim")
	public ModelAndView getHayvanlar() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("hayvanlar", vhtHayvanService.getirHayvanSahipList());
		mav.addObject("sahipler", vhtSahipService.getirTumSahipleri());
		mav.setViewName("hayvanTanitim");
		return mav;
	}

	@RequestMapping("/login.html")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/login");
		return mav;
	}
	
	@RequestMapping("/")
	public ModelAndView ansayfaYonlendirme() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("anasayfa");
		return mav;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "hayvanSil/{hayvanID}", method = RequestMethod.GET)
	public String silHayvan(@PathVariable("hayvanID") long id) {
		vhtHayvanService.sil(id);
		return "redirect:/hayvan-tanitim";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "sahipSil/{id}", method = RequestMethod.GET)
	public String silSahip(@PathVariable("id") long id) {
		vhtSahipService.silSahip(id);
		return "redirect:/sahip-tanitim";
	}

	@ModelAttribute
	public Sahip initModelForSahip() {
		return new Sahip();
	}

	@RequestMapping(value = "/sahip-tanitim", method = RequestMethod.POST)
	public String handleFormSubmitForAddSahip(@ModelAttribute Sahip sahip) {
		vhtSahipService.olustur(sahip);
		return "redirect:/sahip-tanitim";
	}

	@ModelAttribute
	public Hayvan initModelForHayvan() {
		return new Hayvan();
	}

	@ModelAttribute(value = "sahipata")
	public SahipAta initModelForSahipAta() {
		return new SahipAta();
	}

	@RequestMapping(value = "/hayvan-tanitim", method = RequestMethod.POST)
	public String handleFormSubmitForAddHayvan(@ModelAttribute Hayvan hayvan) {
		vhtHayvanService.olustur(hayvan);
		return "redirect:/hayvan-tanitim";
	}

	@RequestMapping(value = "sahipAta/{hid}/{sid}", method = RequestMethod.GET)
	public String sahipAta(@PathVariable("hid") long hid, @PathVariable("sid") long sid) {
		vhtHayvanService.sahipAta(hid, sid);
		System.out.println("Hello");
		return "redirect:/hayvan-tanitim";
	}

	@RequestMapping(value = "/sahipAtamaYonlendir", method = RequestMethod.GET)
	public String sahipAtamaYonlendir(@ModelAttribute("sahipata") SahipAta sahipAta) {
		return "redirect:/sahipAta/" + sahipAta.getHid() + "/" + sahipAta.getSid();
	}

	@RequestMapping(value = "/sahip/guncelle/{id}", method = RequestMethod.GET)
	public String sahipBul(@PathVariable Long id, ModelMap modelMap) {
		Sahip sahip = vhtSahipService.getirSahipIdIle(id);
		modelMap.put("sahipguncelle", sahip);
		return "sahipGuncelle";
	}

	@RequestMapping(value = "/sahip/guncelle/{id}", method = RequestMethod.POST)
	public String sahipGuncelle(@ModelAttribute Sahip sahip) {
		vhtSahipService.guncelle(sahip);
		return "redirect:/sahip-tanitim";
	}

	@RequestMapping(value = "/hayvan/guncelle/{id}", method = RequestMethod.GET)
	public String hayvanBul(@PathVariable Long id, ModelMap modelMap) {
		Hayvan hayvan = vhtHayvanService.getirIdIle(id);
		modelMap.put("hayvanguncelle", hayvan);
		return "hayvanGuncelle";
	}

	@RequestMapping(value = "/hayvan/guncelle/{hayvanID}", method = RequestMethod.POST)
	public String hayvanGuncelle(@ModelAttribute Hayvan hayvan) {
		vhtHayvanService.guncelle(hayvan);
		return "redirect:/hayvan-tanitim";
	}

	@RequestMapping(value = "/hayvan/ara/", method = RequestMethod.GET)
	public ModelAndView hayvanAdiIleBul(@RequestParam("ara") @PathVariable String ad, ModelAndView mav) {
		mav.addObject("hayvanlar", vhtHayvanService.getirHayvanAdiIle(ad));
		mav.setViewName("hayvanAra");
		return mav;
	}

	@RequestMapping(value = "/sahip/ara/", method = RequestMethod.GET)
	public ModelAndView sahipAdiIleBul(@RequestParam("ara") @PathVariable String ad, ModelAndView mav) {
		mav.addObject("sahipler", vhtSahipService.getirSahipIsimİle(ad));
		mav.setViewName("sahipAra");
		return mav;
	}

}
