package edu.tamu.jcabelloc.maintsystem.repository;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.tamu.jcabelloc.maintsystem.entity.Resident;

@Repository
public class ResidentRepositoryImpl implements ResidentRepository {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Resident> getResidents() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select a from Resident a", Resident.class); 
		return query.getResultList();
	}

	@Override
	public Resident getResident(int residentId) {
		Session session = sessionFactory.getCurrentSession();
		return session.byId(Resident.class).load(residentId); // Another way to find a object by its Id
	}

	@Override
	public void deleteResident(int residentId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete Resident a where a=:residentId");
		query.setParameter("residentId", residentId);
		query.executeUpdate();
	}

	@Override
	public void saveResident(Resident resident) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(resident);
	}

}
