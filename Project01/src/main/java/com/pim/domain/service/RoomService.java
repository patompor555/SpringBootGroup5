package com.pim.domain.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pim.app.room.RoomForm;
import com.pim.domain.entity.Branch;
import com.pim.domain.entity.Room;
import com.pim.domain.repository.BranchRepository;
import com.pim.domain.repository.RoomRepository;

@Service
public class RoomService {
	
	@Autowired
	BranchRepository branchRepository;
	
	@Autowired
	RoomRepository roomRepository;
	
	public Branch findBranchByBranchId(int branchID) {
		return branchRepository.getOne(branchID);
	}

	public void save(RoomForm roomForm) {
		Date date = Calendar.getInstance().getTime();
		Room room = new Room();
		room.setRoomName(roomForm.getRoomName());
		room.setBranchID(branchRepository.getOne(roomForm.getBranchID()));
//		room.setStatus(false);
		room.setCreateBy("Admin");
		room.setCreateDate(date);
		roomRepository.save(room);
	}
	
	public RoomForm findRoomById(int roomID, int branchID) {
		Room room = roomRepository.getOne(roomID);
		Branch branch = branchRepository.getOne(branchID);
		return new RoomForm(room.getRoomID(), room.getRoomName(), branch.getBranchID());
	}
	
	public void update(RoomForm roomForm) {
		Room room = roomRepository.getOne(roomForm.getRoomID());
		room.setRoomName(roomForm.getRoomName());
		room.setBranchID(branchRepository.getOne(roomForm.getBranchID()));
		room.setCreateDate(Calendar.getInstance().getTime());
		room.setCreateBy("Admin");
		roomRepository.save(room);
	}
	
	public void delete(int roomID) {
		roomRepository.deleteById(roomID);
	}
	
	public List<Room> findAllRoom() {
		return roomRepository.findAll();
	}
}
