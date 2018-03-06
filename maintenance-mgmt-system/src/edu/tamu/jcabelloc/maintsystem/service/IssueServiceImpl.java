package edu.tamu.jcabelloc.maintsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tamu.jcabelloc.maintsystem.entity.Issue;
import edu.tamu.jcabelloc.maintsystem.repository.IssueRepository;

@Service
public class IssueServiceImpl implements IssueService {

	@Autowired
	IssueRepository issueRepository ;
	
	@Override
	@Transactional
	public List<Issue> getIssues() {
		return issueRepository.getIssues();
	}

	@Override
	@Transactional
	public Issue getIssue(String issueCode) {
		return issueRepository.getIssue(issueCode);
	}

	@Override
	@Transactional
	public void saveIssue(Issue issue) {
		issueRepository.saveIssue(issue);
	}

	@Override
	@Transactional
	public void deleteIssue(String issueCode) {
		issueRepository.deleteIssue(issueCode);
	}

	@Override
	@Transactional
	public List<Issue> findIssuesByDescription(String issueDescription) {
		return issueRepository.findIssuesByDescription(issueDescription);
	}

}
