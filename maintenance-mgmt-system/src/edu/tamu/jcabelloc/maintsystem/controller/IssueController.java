package edu.tamu.jcabelloc.maintsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.tamu.jcabelloc.maintsystem.entity.Issue;
import edu.tamu.jcabelloc.maintsystem.service.IssueService;

@Controller
@RequestMapping("/issue")
public class IssueController {
	
	@Autowired
	IssueService issueService; 
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Issue> issues = issueService.getIssues();
		model.addAttribute("issues", issues);
		return "issueList";
	}
	
	@GetMapping("/addIssueForm")
	public String addIssueForm(Model model) {
		Issue issue = new Issue();
		model.addAttribute(issue);
		return "issueForm";
	}
	@PostMapping("/saveIssue")
	public String saveIssue(@ModelAttribute("issue") Issue issue) {
		if (issue.getIssueCode().equals("")) {
			issue.setIssueCode(null);
		}
		issueService.saveIssue(issue);
		return "redirect:/issue/list";
	}
	
	@GetMapping("/updateIssueForm")
	public String updateIssueForm(@RequestParam("issueCode") String issueCode, Model model) {
		Issue issue = issueService.getIssue(issueCode);
		model.addAttribute("issue", issue);
		return "issueForm";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("issueCode") String issueCode) {
		issueService.deleteIssue(issueCode);
		return "redirect:/issue/list";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam(value="issueDescription", required=false) String issueDescription, Model model) {
		List<Issue> issues = new ArrayList<>();
		if (issueDescription == null || issueDescription.equals("")) {
			issues = issueService.getIssues();
		} else {
			issues = issueService.findIssuesByDescription(issueDescription);
		}
		model.addAttribute("issues", issues);
		return "issueSearch";
	}
}
