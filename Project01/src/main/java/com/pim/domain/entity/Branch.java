package com.pim.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="branch")
public class Branch {
	
	@GeneratedValue
	@Id
	@Column(name = "BRANCHID")
	private int branchID;
	
	@Column(name = "BRANCHNAME")
	private String branchName;
	
	
	@OneToMany(mappedBy = "branchID", cascade = CascadeType.ALL)
	private List<Room> roomList;
	
	
	public int getBranchID() {
		return branchID;
	}


	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}


	public String getBranchName() {
		return branchName;
	}


	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}


	public List<Room> getRoomList() {
		return roomList;
	}


	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}


	
	
	
	

}

