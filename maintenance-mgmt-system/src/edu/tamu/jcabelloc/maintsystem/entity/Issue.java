package edu.tamu.jcabelloc.maintsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Issue")
public class Issue {
	
	@Id
	@GenericGenerator(name = "issueIdGenerator", strategy = "edu.tamu.jcabelloc.maintsystem.entity.IssueIdGenerator")
	@GeneratedValue(generator = "issueIdGenerator")
	@Column(name="IssueCode")
	private String issueCode;
	
	@Column(name="Description")
	private String Description;
	
	@Column(name="State")
	private char state;

	
	public String getIssueCode() {
		return issueCode;
	}
	public void setIssueCode(String issueCode) {
		this.issueCode = issueCode;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public char getState() {
		return state;
	}
	public void setState(char state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Issue [issueCode=" + issueCode + ", Description=" + Description + ", state=" + state + "]";
	}
	
}
