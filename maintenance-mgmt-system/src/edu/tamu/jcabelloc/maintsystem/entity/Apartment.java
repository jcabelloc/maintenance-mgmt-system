package edu.tamu.jcabelloc.maintsystem.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="Apartment")
public class Apartment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ApartmentId")
	private int apartmentId;

	@Column(name="Number")
	private int number;
	
	@Column(name="NumberOfRooms")
	private int numberOfRooms;
	
	@Column(name="Block")
	private char block;
	
	@Column(name="Floor")
	private int floor;
	
	@Transient
	int[] roomChoices = {1,2,3,4};

	@Transient
	int[] floorChoices = {1,2,3};

	public Apartment() {
		
	}

	public Apartment(int number, int numberOfRooms, char block, int floor) {
		this.number = number;
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
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
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
		return "Apartment [apartmentId=" + apartmentId + ", number=" + number + ", numberOfRooms=" + numberOfRooms
				+ ", block=" + block + ", floor=" + floor + ", roomChoices=" + Arrays.toString(roomChoices)
				+ ", floorChoices=" + Arrays.toString(floorChoices) + "]";
	}

	public int[] getRoomChoices() {
		return roomChoices;
	}

	public int[] getFloorChoices() {
		return floorChoices;
	}
}
