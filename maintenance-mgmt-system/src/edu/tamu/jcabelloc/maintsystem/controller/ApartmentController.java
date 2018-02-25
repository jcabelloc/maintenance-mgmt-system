package edu.tamu.jcabelloc.maintsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.tamu.jcabelloc.maintsystem.entity.Apartment;
import edu.tamu.jcabelloc.maintsystem.service.ApartmentService;

@Controller
@RequestMapping("/apartment")
public class ApartmentController {
	
	@Autowired
	private ApartmentService apartmentService;
	
	@RequestMapping("/go")
	public void test() {
		Apartment apartment = new Apartment(1306, 2, 'M', 3);
		apartmentService.saveApartment(apartment);
		
		System.out.println(apartmentService.getAparment(1306));
		
	}
	
}
