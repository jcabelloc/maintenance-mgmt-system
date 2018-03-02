package edu.tamu.jcabelloc.maintsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/search")
	public String search(@RequestParam(value="apartmentNumber", required=false) Integer apartmentNumber, Model model) {
		List<Apartment> apartments = new ArrayList<>();
		if (apartmentNumber == null) {
			apartments = apartmentService.getApartments();
		} else {
			apartments.add(apartmentService.getAparmentByNumber(apartmentNumber));
		}
		model.addAttribute("apartments", apartments);
		return "apartmentSearch";
	}
	
	@GetMapping("/addApartmentForm")
	public String addApartmentForm(Model model) {
		Apartment apartment = new Apartment();
		model.addAttribute(apartment);
		model.addAttribute("blocks", apartmentService.getBlocks());
		return "apartmentForm";
	}
	@PostMapping("/saveApartment")
	public String saveCustomer(@ModelAttribute("apartment") Apartment apartment) {
		apartmentService.saveApartment(apartment);
		return "redirect:/apartment/list";
	}
	
	@GetMapping("/updateApartmentForm")
	public String updateApartmentForm(@RequestParam("apartmentId") int apartmentId, Model model) {
		Apartment apartment = apartmentService.getAparment(apartmentId);
		model.addAttribute("apartment", apartment);
		model.addAttribute("blocks", apartmentService.getBlocks());
		return "apartmentForm";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("apartmentId") int apartmentId) {
		apartmentService.delete(apartmentId);
		return "redirect:/apartment/list";
	}
}
