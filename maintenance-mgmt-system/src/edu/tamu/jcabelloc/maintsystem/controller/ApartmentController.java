package edu.tamu.jcabelloc.maintsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.tamu.jcabelloc.maintsystem.entity.Apartment;
import edu.tamu.jcabelloc.maintsystem.service.ApartmentService;

@Controller
@RequestMapping("/apartment")
public class ApartmentController {
	
	@Autowired
	private ApartmentService apartmentService;
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Apartment> apartments = apartmentService.getApartments();
		model.addAttribute("apartments", apartments);
		return "apartmentList";
	}
	@GetMapping("addApartmentForm")
	public String addApartmentForm(Model model) {
		Apartment apartment = new Apartment();
		model.addAttribute(apartment);
		model.addAttribute("blocks", apartmentService.getBlocks());
		return "apartmentForm";
	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("apartment") Apartment apartment) {
		apartmentService.saveApartment(apartment);
		return "redirect:/apartment/list";
	}
}
