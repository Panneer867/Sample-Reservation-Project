package com.railway.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "train", uniqueConstraints = @UniqueConstraint(columnNames = "trainNo"))
public class Train {

    @Id
    @NotNull(message = "Please provide Train No.")
    private Long trainNo;
    
    @Pattern(regexp = "^[A-Za-z, ]++$", message = "Train Name must have atleast 3 characters")
    private String trainName;
    
    @NotBlank(message = "Please provide number of seats")
    private String totalSeat;
    
    @NotBlank(message = "Please provide Ticket Price")
    private String trainFare;
    
    @NotBlank(message = "Please provide From Place")
    private String fromPlace;
    
    @NotBlank(message = "Please provide To Place")
    private String toPlace;
    
    @NotBlank(message = "Please provide date of the train")
    private String date;
    
    @NotBlank(message = "Please dispatch time")
    private String dispatch;
    
    @NotBlank(message = "Please arrival time")
	private String arrival;
	
    public Train() {
        super();
    }


    public Train(Long trainNo, String trainName, String totalSeat, String trainFare, String fromPlace, String toPlace, String date, String dispatch, String arrival) {
        super();
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.totalSeat = totalSeat;
        this.trainFare = trainFare;
        this.fromPlace = fromPlace;
        this.toPlace = toPlace;
        this.date = date;
        this.dispatch = dispatch;
        this.arrival = arrival;
    }


    public Long getTrainNo() {
        return trainNo;
    }


    public void setTrainNo(Long trainNo) {
        this.trainNo = trainNo;
    }

    public String getTrainName() {
		return trainName;
	}


	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	
    public String getTotalSeat() {
        return totalSeat;
    }


    public void setTotalSeat(String totalSeat) {
        this.totalSeat = totalSeat;
    }


    public String getTrainFare() {
        return trainFare;
    }


    public void setTrainFare(String trainFare) {
        this.trainFare = trainFare;
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

    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
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

}