package com.pim.domain.service;

import java.util.List;

//import java.util.Calendar;
//import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pim.app.branch.BranchForm;
import com.pim.domain.entity.Branch;
import com.pim.domain.repository.BranchRepository;

@Service
@Transactional
public class BranchService {

	@Autowired
	BranchRepository branchRepository;
	
	public void save(BranchForm branchForm) {
//		Date date = Calendar.getInstance().getTime();
		Branch branch = new Branch();
		branch.setBranchName(branchForm.getBranchName());
//		branch.setCreatedDate(date);
//		branch.setUpdatedDate(date);
		branchRepository.save(branch);
	}
	
	public List<Branch> findAllBranch() {
		return branchRepository.findAll();
	}
	
	public BranchForm findBranchById(int branchID) {
		Branch branch = branchRepository.getOne(branchID);
		return new BranchForm(branch.getBranchID(), branch.getBranchName());
	}
	
	public void update(BranchForm branchForm) {
		Branch branch = branchRepository.getOne(branchForm.getBranchID());
		branch.setBranchName(branchForm.getBranchName());
//		project.setUpdatedDate(Calendar.getInstance().getTime());
		branchRepository.save(branch);
	}
	
	public void delete (int branchID) {
		branchRepository.deleteById(branchID);
	}

}
