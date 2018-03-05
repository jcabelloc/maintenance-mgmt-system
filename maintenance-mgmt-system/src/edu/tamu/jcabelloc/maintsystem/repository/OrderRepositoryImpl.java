package edu.tamu.jcabelloc.maintsystem.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.tamu.jcabelloc.maintsystem.entity.Order;
import edu.tamu.jcabelloc.maintsystem.entity.Resident;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Order> getOrders() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("select a from Order a", Order.class).getResultList();
	}

	@Override
	public Order getOrder(int orderId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Order.class, orderId);
	}

	@Override
	public void saveOrder(Order order) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(order);
	}

	@Override
	public void deleteOrder(int orderId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Delete Order a where a.orderId=:orderId");
		query.setParameter("orderId", orderId);
		query.executeUpdate();
	}

}
