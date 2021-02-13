package com.pim.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="schedule")
public class Schedule {

	@GeneratedValue
	@Id
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "ROOMID")
	private Room roomID;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "reservationer")
	private String reservationer;
	
	@Column(name = "time_start")
	private String time_start;
	
	@Column(name = "time_end")
	private String time_end;
	
	@Column(name = "Detail")
	private String detail;
	
	@Column(name = "created_at")
	private Date created_at;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Room getRoomID() {
		return roomID;
	}

	public void setRoomID(Room roomID) {
		this.roomID = roomID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getReservationer() {
		return reservationer;
	}

	public void setReservationer(String reservationer) {
		this.reservationer = reservationer;
	}

	public String getTime_start() {
		return time_start;
	}

	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}

	public String getTime_end() {
		return time_end;
	}

	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	
	
}
