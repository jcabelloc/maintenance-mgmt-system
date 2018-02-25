package edu.tamu.jcabelloc.maintsystem.repository;

import java.util.List;

import edu.tamu.jcabelloc.maintsystem.entity.Apartment;

public interface ApartmentRepository {
	
	public List<Apartment> getApartments();
	
	public Apartment getApartment(int apartmentId);
	
	public void saveApartment(Apartment apartment);
}