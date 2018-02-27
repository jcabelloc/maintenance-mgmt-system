package edu.tamu.jcabelloc.maintsystem.service;

import java.util.List;

import edu.tamu.jcabelloc.maintsystem.entity.Appliance;

public interface ApplianceService {
	
	public Appliance getAppliance(int applianceId);
	
	public List<Appliance> getAppliances();
	
	public void saveAppliance(Appliance appliance);

}
