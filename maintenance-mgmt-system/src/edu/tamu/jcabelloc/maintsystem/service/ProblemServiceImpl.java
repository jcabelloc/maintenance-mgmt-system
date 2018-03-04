package edu.tamu.jcabelloc.maintsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.tamu.jcabelloc.maintsystem.entity.Problem;
import edu.tamu.jcabelloc.maintsystem.repository.ProblemRepository;

@Repository
public class ProblemServiceImpl implements ProblemService {
	
	@Autowired
	ProblemRepository problemRepository; 
	
	@Override
	@Transactional
	public List<Problem> getProblems() {
		return problemRepository.getProblems();
	}

	@Override
	@Transactional
	public Problem getProblem(String problemCode) {
		return problemRepository.getProblem(problemCode);
	}

	@Override
	@Transactional
	public void saveProblem(Problem problem) {
		problemRepository.saveProblem(problem);
	}

	@Override
	@Transactional
	public void deleteProblem(String problemCode) {
		problemRepository.deleteProblem(problemCode);
	}

}
