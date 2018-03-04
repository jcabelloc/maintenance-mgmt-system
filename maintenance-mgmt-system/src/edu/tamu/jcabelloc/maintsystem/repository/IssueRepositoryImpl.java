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
		Query query = session.createQuery("Select a from Issue a where a.IssueCode=:issueCode");
		query.setParameter("issueCode", issueCode);
		return (Issue)query.getSingleResult();
	}

	@Override
	public void saveIssue(Issue issue) {
		Session session = sessionFactory.getCurrentSession();
		session.save(issue);
	}

	@Override
	public void deleteIssue(String issueCode) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete Issue a where a.IssueCode=:issueCode");
		query.setParameter("issueCode", issueCode);
		query.executeUpdate();
	}

}
