package edu.tamu.jcabelloc.maintsystem.service;

import java.util.List;

import edu.tamu.jcabelloc.maintsystem.entity.Resident;

public interface ResidentService {

	public List<Resident> getResidents();
	
	public Resident getResident(int residentId);
	
	public void saveResident(Resident resident);
	
	public void deleteResident(int residentId);
	
}
