package edu.tamu.jcabelloc.maintsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tamu.jcabelloc.maintsystem.entity.Resident;
import edu.tamu.jcabelloc.maintsystem.repository.ResidentRepository;

@Service
public class ResidentServiceImpl implements ResidentService {
	
	@Autowired
	ResidentRepository residentRepository;

	@Override
	@Transactional
	public List<Resident> getResidents() {
		return residentRepository.getResidents();
	}

	@Override
	@Transactional
	public Resident getResident(int residentId) {
		return residentRepository.getResident(residentId);
	}

	@Override
	@Transactional
	public void saveResident(Resident resident) {
		residentRepository.saveResident(resident);
	}

	@Override
	@Transactional
	public void deleteResident(int residentId) {
		residentRepository.deleteResident(residentId);
	}
	
	
	

}
