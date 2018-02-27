package edu.tamu.jcabelloc.maintsystem.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Appliance")
public class Appliance {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ApplianceId")
	int applianceId;
	
	@ManyToOne
	@JoinColumn(name="ApartmentId")
	Apartment apartment;
	
	@Column(name="SerialNumber")
	String serialNumber;
	
	@Column(name="Type")
	String type;
	
	@Column(name="Brand")
	String brand;
	
	@Column(name="PurchaseDate")
	LocalDate purchaseDate;
	
	@Column(name="Description")
	String description;
	
	@Column(name="Status")
	char status;
	
	private Appliance() {
		
	}

	public Appliance(Apartment apartment, String serialNumber, String type, String brand, LocalDate purchaseDate,
			String description, char status) {
		super();
		this.apartment = apartment;
		this.serialNumber = serialNumber;
		this.type = type;
		this.brand = brand;
		this.purchaseDate = purchaseDate;
		this.description = description;
		this.status = status;
	}

	public int getApplianceId() {
		return applianceId;
	}

	public void setApplianceId(int applianceId) {
		this.applianceId = applianceId;
	}

	public Apartment getApartment() {
		return apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Appliance [applianceId=" + applianceId + ", apartment=" + apartment + ", serialNumber=" + serialNumber
				+ ", type=" + type + ", brand=" + brand + ", purchaseDate=" + purchaseDate + ", description="
				+ description + ", status=" + status + "]";
	}

}
