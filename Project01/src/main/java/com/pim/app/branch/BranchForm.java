package com.pim.app.branch;

public class BranchForm {

	private int branchID;
	
	private String branchName;
	
	public BranchForm(int branchID, String branchName) {
		this.branchID = branchID;
		this.branchName = branchName;
	}
	
	public BranchForm() {}

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
}
