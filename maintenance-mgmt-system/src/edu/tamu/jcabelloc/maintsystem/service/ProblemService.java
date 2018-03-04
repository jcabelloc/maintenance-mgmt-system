package edu.tamu.jcabelloc.maintsystem.service;

import java.util.List;

import edu.tamu.jcabelloc.maintsystem.entity.Problem;

public interface ProblemService {
	
	public List<Problem> getProblems();
	
	public Problem getProblem(String problemCode);
	
	public void saveProblem(Problem problem);
	
	public void deleteProblem(String problemCode);
}
