package edu.tamu.jcabelloc.maintsystem.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
}
