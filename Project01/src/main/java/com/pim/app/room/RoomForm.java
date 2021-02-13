package com.pim.app.room;


public class RoomForm {

	private int roomID;
	
	private String roomName;
	
	private int branchID;
	
	public RoomForm(int roomID, String roomName, int branchID) {
		this.roomID = roomID;
		this.roomName = roomName;
		this.branchID = branchID;
	}
	
	public RoomForm(int roomID, String roomName) {
		this.roomID = roomID;
		this.roomName = roomName;
	}
	
	public RoomForm() {}
		
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

	public int getBranchID() {
		return branchID;
	}

	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}

	
	
}
