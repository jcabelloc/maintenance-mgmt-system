package edu.tamu.jcabelloc.maintsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tamu.jcabelloc.maintsystem.entity.Appliance;
import edu.tamu.jcabelloc.maintsystem.repository.ApplianceRepository;

@Service
public class ApplianceServiceImpl implements ApplianceService {
	
	@Autowired
	ApplianceRepository applianceRepository;  
	
	@Override
	@Transactional
	public Appliance getAppliance(int applianceId) {
		return applianceRepository.getAppliance(applianceId);
	}

	@Override
	@Transactional
	public List<Appliance> getAppliances() {
		return applianceRepository.getAppliances();
	}

	@Override
	@Transactional
	public void saveAppliance(Appliance appliance) {
		applianceRepository.saveAppliance(appliance);
	}

	@Override
	@Transactional
	public void delete(int applianceId) {
		applianceRepository.delete(applianceId);
	}
	

}
