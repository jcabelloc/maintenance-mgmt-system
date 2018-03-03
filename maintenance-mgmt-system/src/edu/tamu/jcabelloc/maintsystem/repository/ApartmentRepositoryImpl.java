package edu.tamu.jcabelloc.maintsystem.repository;

import java.util.List;

import javax.persistence.Query;

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
		session.saveOrUpdate(apartment);
	}
	
	@Override
	public void delete(int apartmentId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete Apartment where apartmentId = :apartmentId");
		query.setParameter("apartmentId", apartmentId);
		query.executeUpdate();
		
	}
	
	@Override
	public char[] getBlocks() {
		return new char[]{'A', 'B', 'C', 'D', 'E','F'};
	}

	@Override
	public Apartment getApartmentByNumber(int number) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select a from Apartment a where a.number = :number", Apartment.class);
		query.setParameter("number", number);
		Apartment apartment = (Apartment)query.getSingleResult();
		if (apartment != null) {
			return apartment;			
		}
		return null;
		
		
	}
	
}
