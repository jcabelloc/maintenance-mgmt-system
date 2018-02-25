package edu.tamu.jcabelloc.maintsystem.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.tamu.jcabelloc.maintsystem.entity.Apartment;

@Repository
public class ApartmentRepositoryImpl implements ApartmentRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Apartment> getApartments() {
		Session session = sessionFactory.getCurrentSession();
		List<Apartment> apartments = session.createQuery("select a from Apartment a", Apartment.class).getResultList();
		return apartments;
	}

	@Override
	public Apartment getApartment(int apartmentId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Apartment.class, apartmentId);
	}

	@Override
	public void saveApartment(Apartment apartment) {
		Session session = sessionFactory.getCurrentSession();
		session.save(apartment);
	}
}
