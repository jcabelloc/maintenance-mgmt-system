package edu.tamu.jcabelloc.maintsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Problem")
public class Problem {
	
	@Id
	@GenericGenerator(name = "problemIdGenerator", strategy = "edu.tamu.jcabelloc.maintsystem.entity.ProblemIdGenerator")
	@GeneratedValue(generator = "problemIdGenerator")
	@Column(name="ProblemCode")
	private String problemCode;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="State")
	private char state;

	
	public String getProblemCode() {
		return problemCode;
	}

	public void setProblemCode(String problemCode) {
		this.problemCode = problemCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public char getState() {
		return state;
	}

	public void setState(char state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Problem [problemCode=" + problemCode + ", description=" + description + ", state=" + state + "]";
	}
	
	

}
