package edu.tamu.jcabelloc.maintsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.tamu.jcabelloc.maintsystem.entity.Issue;
import edu.tamu.jcabelloc.maintsystem.service.IssueService;

@Controller
@RequestMapping("/issue")
public class IssueController {
	
	@Autowired
	IssueService issueService; 
	
	@GetMapping("/test")
	public void test() {
		Issue issue = new Issue();
		issue.setDescription("test");
		issue.setState('A');
		issueService.saveIssue(issue);
		System.out.println(issueService.getIssues());
	}
}
