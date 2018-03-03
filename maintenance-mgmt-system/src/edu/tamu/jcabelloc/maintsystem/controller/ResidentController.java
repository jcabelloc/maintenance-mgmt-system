package edu.tamu.jcabelloc.maintsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.tamu.jcabelloc.maintsystem.entity.Resident;
import edu.tamu.jcabelloc.maintsystem.service.ApartmentService;
import edu.tamu.jcabelloc.maintsystem.service.ResidentService;

@Controller
@RequestMapping("/resident")
public class ResidentController {
	
	@Autowired
	ResidentService residentService;
	
	@Autowired
	ApartmentService apartmentService;
	
	@RequestMapping("/test")
	public void test() {
		Resident resident = new Resident();
		resident.setFirstName("Juan");
		resident.setLastName("Cabello");
		resident.setStatus('A');
		residentService.saveResident(resident);
		System.out.println(residentService.getResidents());
	}
	@GetMapping("/list")
	public String list(Model model) {
		List<Resident> residents = residentService.getResidents();
		model.addAttribute("residents", residents);
		return "residentList";
	}
	@GetMapping("/addResidentForm")
	public String addResidentForm(Model model) {
		Resident resident = new Resident();
		model.addAttribute("resident", resident);
		return "residentForm";
	}
	@PostMapping("/saveResident")
	public String saveResident(@ModelAttribute("resident") Resident resident) {
		int apartmentNumber = resident.getApartment().getNumber();
		resident.setApartment(apartmentService.getAparmentByNumber(apartmentNumber));
		residentService.saveResident(resident);
		return "redirect:/resident/list";
	}
	
	
}
