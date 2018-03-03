package edu.tamu.jcabelloc.maintsystem.repository;

import java.util.List;

import edu.tamu.jcabelloc.maintsystem.entity.Resident;

public interface ResidentRepository {
	
	public List<Resident> getResidents();
	
	public Resident getResident(int residentId);
	
	public void deleteResident(int residentId);
	
	public void saveResident(Resident resident);

}
