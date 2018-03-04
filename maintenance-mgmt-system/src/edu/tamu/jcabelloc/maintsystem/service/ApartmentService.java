package edu.tamu.jcabelloc.maintsystem.service;

import java.util.List;

import edu.tamu.jcabelloc.maintsystem.entity.Apartment;

public interface ApartmentService {
	
	public List<Apartment> getApartments();
	
	public Apartment getAparment(int apartmentId);
	
	public void saveApartment(Apartment apartment);

	public char[] getBlocks();

	public void deleteApartment(int apartmentId);

	public Apartment getAparmentByNumber(int number);
	
}
