package com.pim.domain.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="room")
public class Room {
	
	@GeneratedValue
	@Id
	@Column(name="ROOMID")
	private int roomID;
	
	@Column(name="ROOMNAME")
	private String roomName;
	
	@ManyToOne
	@JoinColumn(name = "BRANCHID")
	private Branch branchID;
	
	@Column(name="CREATEDBY")
	private String createBy;
	
	@Column(name="CREATEDDATE")
	private Date createDate;
	
	@OneToMany(mappedBy = "roomID", cascade = CascadeType.ALL)
	private List<Schedule> scheduleList;
	
	
	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	
	public Branch getBranchID() {
		return branchID;
	}

	public void setBranchID(Branch branchID) {
		this.branchID = branchID;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public List<Schedule> getScheduleList() {
		return scheduleList;
	}

	public void setScheduleList(List<Schedule> scheduleList) {
		this.scheduleList = scheduleList;
	}
	
	

	

}
