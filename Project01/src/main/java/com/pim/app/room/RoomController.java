package com.pim.app.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pim.domain.entity.Branch;
import com.pim.domain.service.BranchService;
import com.pim.domain.service.RoomService;

@Controller
@RequestMapping("room")
public class RoomController {
	
	@Autowired
	RoomService roomService;
	
	@Autowired
	BranchService branchService;
	
	@RequestMapping(value = "list/{branchID}", method = RequestMethod.GET)
	public String list(@PathVariable("branchID") int branchID, Model model) {
		RoomForm roomForm = new RoomForm();
		List<Branch> branchList = branchService.findAllBranch();
		model.addAttribute("branchList", branchList);
		roomForm.setBranchID(branchID);
		model.addAttribute("roomForm", roomForm);
		model.addAttribute("branch", roomService.findBranchByBranchId(branchID));
		return "room/list";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(@ModelAttribute RoomForm roomForm) {
		roomService.save(roomForm);
		return "redirect:/room/list/" + roomForm.getBranchID();
	}
	
	@RequestMapping(value = "edit/{branchID}/{roomID}", method = RequestMethod.GET)
	public String edit(@PathVariable("branchID") int branchID, @PathVariable("roomID") int roomID, Model model) {
		model.addAttribute("roomForm", roomService.findBranchByBranchId(branchID));
		model.addAttribute("roomForm", roomService.findRoomById(roomID, branchID));
		return "room/edit";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public Object edit(@ModelAttribute RoomForm roomForm) {
		roomService.update(roomForm);
		return "redirect:/room";
	}
	
	@RequestMapping(value = "delete/{branchID}/{roomID}", method = RequestMethod.GET)
	public String delete(@PathVariable("branchID") int branchID, @PathVariable("roomID") int roomID) {
		roomService.delete(roomID);
		return "redirect:/room/list/" + branchID;
	}
		

}
