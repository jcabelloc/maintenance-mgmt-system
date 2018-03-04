package edu.tamu.jcabelloc.maintsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.tamu.jcabelloc.maintsystem.entity.Problem;
import edu.tamu.jcabelloc.maintsystem.service.ProblemService;

@Controller
@RequestMapping("/problem")
public class ProblemController {
	
	@Autowired
	ProblemService problemService; 
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Problem> problems = problemService.getProblems();
		model.addAttribute("problems", problems);
		return "problemList";
	}
	
	@GetMapping("/addProblemForm")
	public String addProblemForm(Model model) {
		Problem problem = new Problem();
		model.addAttribute(problem);
		return "problemForm";
	}
	@PostMapping("/saveProblem")
	public String saveProblem(@ModelAttribute("problem") Problem problem) {
		if (problem.getProblemCode().equals("")) {
			problem.setProblemCode(null);
		}
		problemService.saveProblem(problem);
		return "redirect:/problem/list";
	}
	
	@GetMapping("/updateProblemForm")
	public String updateProblemForm(@RequestParam("problemCode") String problemCode, Model model) {
		Problem problem = problemService.getProblem(problemCode);
		model.addAttribute("problem", problem);
		return "problemForm";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("problemCode") String problemCode) {
		problemService.deleteProblem(problemCode);
		return "redirect:/problem/list";
	}
}
