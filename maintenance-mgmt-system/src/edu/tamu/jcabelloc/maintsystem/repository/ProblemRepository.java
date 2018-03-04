package edu.tamu.jcabelloc.maintsystem.repository;

import java.util.List;

import edu.tamu.jcabelloc.maintsystem.entity.Problem;

public interface ProblemRepository {
	
	public List<Problem> getProblems();
	
	public Problem getProblem(String problemCode);
	
	public void saveProblem(Problem problem);
	
	public void deleteProblem(String problemCode);
	

}
