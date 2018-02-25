package edu.tamu.jcabelloc.maintsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Apartment")
public class Apartment {
	
	@Id
	@Column(name="ApartmentId")
	private int apartmentId;
	
	@Column(name="NumberOfRooms")
	private int numberOfRooms;
	
	@Column(name="Block")
	private char block;
	
	@Column(name="Floor")
	private int floor;
	
	public Apartment() {
		
	}

	public Apartment(int apartmentId, int numberOfRooms, char block, int floor) {
		this.apartmentId = apartmentId;
		this.numberOfRooms = numberOfRooms;
		this.block = block;
		this.floor = floor;
	}

	public int getApartmentId() {
		return apartmentId;
	}

	public void setApartmentId(int apartmentId) {
		this.apartmentId = apartmentId;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public char getBlock() {
		return block;
	}

	public void setBlock(char block) {
		this.block = block;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	@Override
	public String toString() {
		return "Apartment [apartmentId=" + apartmentId + ", numberOfRooms=" + numberOfRooms + ", block=" + block
				+ ", floor=" + floor + ", getApartmentId()=" + getApartmentId() + ", getNumberOfRooms()="
				+ getNumberOfRooms() + ", getBlock()=" + getBlock() + ", getFloor()=" + getFloor() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	

}
