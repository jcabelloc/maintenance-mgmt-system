package edu.tamu.jcabelloc.maintsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Resident")
public class Resident {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ResidentId")
	private int residentId;
	
	@Column(name="UserName")
	private String userName;
	
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="LastName")
	private String lastName;
	
	@ManyToOne
	@JoinColumn(name="ApartmentId")
	private Apartment apartment;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="PhoneNumber")
	private String phoneNumber;
	
	@Column(name="Status")
	private char status;
	
	
	public int getResidentId() {
		return residentId;
	}
	public void setResidentId(int residentId) {
		this.residentId = residentId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Apartment getApartment() {
		return apartment;
	}
	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Resident [residentId=" + residentId + ", userName=" + userName + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", apartment=" + apartment + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", status=" + status + "]";
	}
	

}
