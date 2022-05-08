package com.railway.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ticketNo;
	private String name;
	private  String mobile;
	private  String address;
	private  String date;
	private String aadhar;
	private  String schedule;
	private  String fromPlace;
	private  String toPlace;
	private  String trainFare;
	private  String trainName;
	private  String dispatch;
	private  String arrival;
	private  String trainNo;
	
	
	public Booking() {
		super();
		
	}

	public Booking(String name, String mobile, String address, String fromPlace, String toPlace, String trainFare,
			 String date, String schedule, String trainName, String dispatch, String arrival, String aadhar, String trainNo) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.address = address;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.trainFare = trainFare;
		this.trainName = trainName;
		this.dispatch = dispatch;
		this.arrival = arrival;
		this.date = date;
		this.schedule = schedule;
		this.aadhar = aadhar;
		this.trainNo = trainNo;
		
	}
	
	public Long getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(Long ticketNo) {
		this.ticketNo = ticketNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	public String getToPlace() {
		return toPlace;
	}

	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}

	public String getTrainFare() {
		return trainFare;
	}

	public void setTrainFare(String trainFare) {
		this.trainFare = trainFare;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getDispatch() {
		return dispatch;
	}

	public void setDispatch(String dispatch) {
		this.dispatch = dispatch;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}

	
}
