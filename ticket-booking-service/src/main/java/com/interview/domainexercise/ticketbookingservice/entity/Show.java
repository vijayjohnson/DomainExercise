package com.interview.domainexercise.ticketbookingservice.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Show {
	
	@Id
	@GeneratedValue
	private Integer id;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String showTime;
	private Double price;
	@ManyToOne
	@JsonIgnore
	private Theatre theatre;
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Theatre getTheatre() {
		return theatre;
	}
	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}
	public Integer getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Show [id=" + id + ", fromDate=" + fromDate + ", toDate=" + toDate + ", showTime=" + showTime
				+ ", price=" + price + ", theatre=" + theatre + "]";
	}
	
	

}
