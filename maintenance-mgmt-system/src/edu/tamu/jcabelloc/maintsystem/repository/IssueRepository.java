package edu.tamu.jcabelloc.maintsystem.repository;

import java.util.List;

import edu.tamu.jcabelloc.maintsystem.entity.Issue;

public interface IssueRepository {
	
	public List<Issue> getIssues();
	
	public Issue getIssue(String issueCode);
	
	public void saveIssue(Issue issue);
	
	public void deleteIssue(String issueCode);
}
