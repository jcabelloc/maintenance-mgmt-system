package edu.tamu.jcabelloc.maintsystem.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="`Order`")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="OrderId")
	private int orderId;
	
	@Column(name="RegisteredDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate registeredDate;
	
	@ManyToOne
	@JoinColumn(name="ResidentId")
	private Resident resident;
	
	@Column(name="Priority")
	private char priority;
	
	@ManyToOne
	@JoinColumn(name="IssueCode")
	private Issue issue;
	
	@Column(name="IssueComment")
	private String issueComment;
	
	@Column(name="Status")
	private char status;
	
	@Column(name="WorkedHours")
	private BigDecimal workedHours;
	
	@ManyToOne
	@JoinColumn(name="ProblemCode")
	private Problem problem;
	
	@Column(name="SolutionDescription")
	private String solutionDescription;
	
	@ManyToOne
	@JoinColumn(name="ApartmentId")
	private Apartment apartment;
	
	@ManyToOne
	@JoinColumn(name="ApplianceId")
	private Appliance appliance;
	
	@Column(name="EmailNotificationFlag")
	private boolean emailNotificationFlag;
	
	@Column(name="ServiceScore")
	private int serviceScore;
	
	@Column(name="ResidentFeedback")
	private String residentFeedback;
	
	@Transient
	private static Map<String, String> priorities;
	static {
		priorities = new HashMap<String, String>();
		priorities.put("H", "High"); 
		priorities.put("M", "Medium"); 
		priorities.put("L", "Low");
	}
	public Map<String, String> getPriorities() {
		return priorities;
	}
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDate getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(LocalDate registeredDate) {
		this.registeredDate = registeredDate;
	}

	public Resident getResident() {
		return resident;
	}

	public void setResident(Resident resident) {
		this.resident = resident;
	}

	public char getPriority() {
		return priority;
	}

	public void setPriority(char priority) {
		this.priority = priority;
	}

	public Issue getIssue() {
		return issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}

	public String getIssueComment() {
		return issueComment;
	}

	public void setIssueComment(String issueComment) {
		this.issueComment = issueComment;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public BigDecimal getWorkedHours() {
		return workedHours;
	}

	public void setWorkedHours(BigDecimal workedHours) {
		this.workedHours = workedHours;
	}

	public Problem getProblem() {
		return problem;
	}

	public void setProblem(Problem problem) {
		this.problem = problem;
	}

	public String getSolutionDescription() {
		return solutionDescription;
	}

	public void setSolutionDescription(String solutionDescription) {
		this.solutionDescription = solutionDescription;
	}

	public Apartment getApartment() {
		return apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

	public Appliance getAppliance() {
		return appliance;
	}

	public void setAppliance(Appliance appliance) {
		this.appliance = appliance;
	}

	public boolean isEmailNotificationFlag() {
		return emailNotificationFlag;
	}

	public void setEmailNotificationFlag(boolean emailNotificationFlag) {
		this.emailNotificationFlag = emailNotificationFlag;
	}

	public int getServiceScore() {
		return serviceScore;
	}

	public void setServiceScore(int serviceScore) {
		this.serviceScore = serviceScore;
	}

	public String getResidentFeedback() {
		return residentFeedback;
	}

	public void setResidentFeedback(String residentFeedback) {
		this.residentFeedback = residentFeedback;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", registeredDate=" + registeredDate + ", resident=" + resident
				+ ", priority=" + priority + ", issue=" + issue + ", issueComment=" + issueComment + ", status="
				+ status + ", workedHours=" + workedHours + ", problem=" + problem + ", solutionDescription="
				+ solutionDescription + ", apartment=" + apartment + ", appliance=" + appliance
				+ ", emailNotificationFlag=" + emailNotificationFlag + ", serviceScore=" + serviceScore
				+ ", residentFeedback=" + residentFeedback + "]";
	}
}
