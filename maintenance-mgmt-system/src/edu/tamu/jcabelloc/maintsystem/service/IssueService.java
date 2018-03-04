package edu.tamu.jcabelloc.maintsystem.service;

import java.util.List;

import edu.tamu.jcabelloc.maintsystem.entity.Issue;

public interface IssueService {
	
	public List<Issue> getIssues();
	
	public Issue getIssue(String issueCode);
	
	public void saveIssue(Issue issue);
	
	public void deleteIssue(String issueCode);
	
}
