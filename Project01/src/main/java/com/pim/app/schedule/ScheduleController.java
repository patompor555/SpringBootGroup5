package com.pim.app.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pim.domain.entity.Room;
import com.pim.domain.service.RoomService;
import com.pim.domain.service.ScheduleService;

@Controller
@RequestMapping("schedule")
public class ScheduleController {
	
	@Autowired
	ScheduleService scheduleService;
	
	@Autowired
	RoomService roomService;
	
	@RequestMapping(value = "list/{roomID}", method = RequestMethod.GET)
	public String list(@PathVariable("roomID") int roomID, Model model) {
		ScheduleForm scheduleForm = new ScheduleForm();
		List<Room> roomList = roomService.findAllRoom();
		model.addAttribute("roomList", roomList);
		scheduleForm.setRoomID(roomID);
		model.addAttribute("scheduleForm", scheduleForm);
		model.addAttribute("room", scheduleService.findRoomByRoomId(roomID));
		return "schedule/list";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(@ModelAttribute ScheduleForm scheduleForm) {
		scheduleService.save(scheduleForm);
		return "redirect:/schedule/list/" + scheduleForm.getRoomID();
	}

}
