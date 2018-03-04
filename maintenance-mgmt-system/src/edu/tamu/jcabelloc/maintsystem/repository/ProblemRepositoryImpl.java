package edu.tamu.jcabelloc.maintsystem.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.tamu.jcabelloc.maintsystem.entity.Problem;

@Repository
public class ProblemRepositoryImpl implements ProblemRepository {
	
	@Autowired
	SessionFactory sessionFactory; 
	
	@Override
	public List<Problem> getProblems() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("Select a from Problem a", Problem.class).getResultList();
	}

	@Override
	public Problem getProblem(String problemCode) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select a from Problem a where a.ProblemCode=:problemCode");
		query.setParameter("problemCode", problemCode);
		return (Problem)query.getSingleResult();
	}

	@Override
	public void saveProblem(Problem problem) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(problem);
	}

	@Override
	public void deleteProblem(String problemCode) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete Problem a where a.ProblemCode=:problemCode");
		query.setParameter("problemCode", problemCode);
		query.executeUpdate();
	}

}
