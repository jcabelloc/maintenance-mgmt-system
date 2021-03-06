package edu.tamu.jcabelloc.maintsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tamu.jcabelloc.maintsystem.entity.Apartment;
import edu.tamu.jcabelloc.maintsystem.repository.ApartmentRepository;

@Service
public class ApartmentServiceImpl implements ApartmentService {
	
	@Autowired
	private ApartmentRepository apartmentRepository;
	
	@Override
	@Transactional
	public List<Apartment> getApartments() {
		return apartmentRepository.getApartments();
	}

	@Override
	@Transactional
	public Apartment getAparment(int apartmentId) {
		return apartmentRepository.getApartment(apartmentId);
	}

	@Override
	@Transactional
	public void saveApartment(Apartment apartment) {
		apartmentRepository.saveApartment(apartment);
	}

	@Override
	@Transactional
	public char[] getBlocks() {
		return apartmentRepository.getBlocks();
	}

	@Override
	@Transactional
	public void deleteApartment(int apartmentId) {
		apartmentRepository.deleteApartment(apartmentId);
	}

	@Override
	@Transactional
	public Apartment getAparmentByNumber(int number) {
		return apartmentRepository.getApartmentByNumber(number);
	}
	

}
