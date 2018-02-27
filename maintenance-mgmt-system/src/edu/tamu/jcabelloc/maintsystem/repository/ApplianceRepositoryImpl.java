package edu.tamu.jcabelloc.maintsystem.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.tamu.jcabelloc.maintsystem.entity.Appliance;

@Repository
public class ApplianceRepositoryImpl implements ApplianceRepository {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Appliance getAppliance(int applianceId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Appliance.class, applianceId);
	}

	@Override
	public List<Appliance> getAppliances() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("Select a from Appliance a", Appliance.class).getResultList();
	}

	@Override
	public void saveAppliance(Appliance appliance) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(appliance);
	}

}
