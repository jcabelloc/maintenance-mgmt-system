package edu.tamu.jcabelloc.maintsystem.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.tamu.jcabelloc.maintsystem.entity.Issue;

@Repository
public class IssueRepositoryImpl implements IssueRepository {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Issue> getIssues() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("Select a from Issue a", Issue.class).getResultList();
	}

	@Override
	public Issue getIssue(String issueCode) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select a from Issue a where a.issueCode=:issueCode");
		query.setParameter("issueCode", issueCode);
		return (Issue)query.getSingleResult();
	}

	@Override
	public void saveIssue(Issue issue) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(issue);
	}

	@Override
	public void deleteIssue(String issueCode) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete Issue a where a.issueCode=:issueCode");
		query.setParameter("issueCode", issueCode);
		query.executeUpdate();
	}

	@Override
	public List<Issue> findIssuesByDescription(String issueDescription) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select a from Issue a where a.description like :issueDescription", Issue.class);
		query.setParameter("issueDescription", "%"+issueDescription+"%");
		return query.getResultList();
	}

}
