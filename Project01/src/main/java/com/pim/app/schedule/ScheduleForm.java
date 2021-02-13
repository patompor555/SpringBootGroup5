package com.pim.app.schedule;


public class ScheduleForm {

	private int id;
	
	private int roomID;
	
	private String date;
	
	private String reservationer;
	
	private String time_start;
	
	private String time_end;
	
	private String detail;
	
	public ScheduleForm() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
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

}
