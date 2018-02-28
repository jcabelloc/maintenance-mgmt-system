package edu.tamu.jcabelloc.maintsystem.controller;

import java.time.LocalDate;
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
import edu.tamu.jcabelloc.maintsystem.entity.Appliance;
import edu.tamu.jcabelloc.maintsystem.service.ApartmentService;
import edu.tamu.jcabelloc.maintsystem.service.ApplianceService;

@Controller
@RequestMapping("/appliance")
public class ApplianceController {
	
	@Autowired
	ApplianceService applianceService;
	
	@Autowired
	ApartmentService apartmentService;
	
	@RequestMapping("/test")
	public void test() {
		Apartment apartment = new Apartment(1308, 2, 'A', 3);
		apartmentService.saveApartment(apartment);
		Appliance appliance = new Appliance(apartment, "SN1236", "TV", "LG", LocalDate.now(), "42 inches TV LED", 'A');
		applianceService.saveAppliance(appliance);
		System.out.println(applianceService.getAppliances());
	}
	@GetMapping("/list")
	public String list(Model model) {
		List<Appliance> appliances = applianceService.getAppliances();
		model.addAttribute("appliances", appliances);
		return "applianceList";
	}
	@GetMapping("/addApplianceForm")
	public String addApplianceForm(Model model) {
		Apartment apartment = new Apartment();
		Appliance appliance = new Appliance();
		appliance.setApartment(apartment);
		model.addAttribute(appliance);
		return "applianceForm";
	}
	@PostMapping("/saveAppliance")
	public String saveAppliance(@ModelAttribute("appliance") Appliance appliance ) {
		Apartment apartment = apartmentService.getAparmentByNumber(appliance.getApartment().getNumber());
		appliance.setApartment(apartment);
		applianceService.saveAppliance(appliance);
		return "redirect:/appliance/list";
	}
	@GetMapping("/updateApplianceForm")
	public String updateApplianceForm(@RequestParam("applianceId") int applianceId, Model model) {
		Appliance appliance = applianceService.getAppliance(applianceId);
		model.addAttribute("appliance", appliance);
		return "applianceForm";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("applianceId") int applianceId) {
		applianceService.delete(applianceId);
		return "redirect:/appliance/list";
	}
	
}
