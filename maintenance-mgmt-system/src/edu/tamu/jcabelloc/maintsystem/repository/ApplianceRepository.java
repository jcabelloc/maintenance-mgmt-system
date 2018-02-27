package edu.tamu.jcabelloc.maintsystem.repository;

import java.util.List;

import edu.tamu.jcabelloc.maintsystem.entity.Appliance;

public interface ApplianceRepository {
	
	public Appliance getAppliance(int applianceId);
	
	public List<Appliance> getAppliances();
	
	public void saveAppliance(Appliance appliance);

}
