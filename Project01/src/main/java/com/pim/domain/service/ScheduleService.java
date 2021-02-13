package com.pim.domain.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pim.app.schedule.ScheduleForm;
import com.pim.domain.entity.Room;
import com.pim.domain.entity.Schedule;
import com.pim.domain.repository.RoomRepository;
import com.pim.domain.repository.ScheduleRepository;

@Service
public class ScheduleService {
	
	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	ScheduleRepository scheduleRepository;
	
	public Room findRoomByRoomId(int roomID) {
		return roomRepository.getOne(roomID);
	}
	
	
	
	public void save(ScheduleForm scheduleForm) {
		Date date = Calendar.getInstance().getTime();
		String reservationer = "Admin";
		Schedule schedule = new Schedule();
		schedule.setRoomID(roomRepository.getOne(scheduleForm.getRoomID()));
		schedule.setDate(scheduleForm.getDate());
		schedule.setReservationer(reservationer);
		schedule.setTime_start(scheduleForm.getTime_start());
		schedule.setTime_end(scheduleForm.getTime_end());
		schedule.setDetail(scheduleForm.getDetail());
		schedule.setCreated_at(date);
		
		scheduleRepository.save(schedule);
	}

}
