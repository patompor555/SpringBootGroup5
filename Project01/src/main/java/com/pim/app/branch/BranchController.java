package com.pim.app.branch;

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

@Controller
@RequestMapping("/branch")
public class BranchController {
	@Autowired
	BranchService branchService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String login(Model model) {
		return "user/login";
	}
	
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String index(Model model) {
		List<Branch> branchList = branchService.findAllBranch();
		model.addAttribute("branchList", branchList);
		return "branch/list";
	}
	
	@RequestMapping(value = "create", params = "form", method = RequestMethod.GET)
	public String createForm(Model model) {
		model.addAttribute("branchForm", new BranchForm());
		return "branch/create";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public Object create(@ModelAttribute BranchForm branchForm) {
		branchService.save(branchForm);
		return "redirect:/branch";
	}
	
	@RequestMapping(value = "edit/{branchID}", method = RequestMethod.GET)
	public String edit(@PathVariable("branchID") int branchID, Model model) {
		model.addAttribute("branchForm", branchService.findBranchById(branchID));
		return "branch/edit";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public Object edit(@ModelAttribute BranchForm branchForm) {
		branchService.update(branchForm);
		return "redirect:/branch";
	}
	
	@RequestMapping(value = "delete/{branchID}", method = RequestMethod.GET)
	public String delete(@PathVariable("branchID") int branchID) {
		branchService.delete(branchID);
		return "redirect:/branch";
	}	
	
//	@RequestMapping(value = "user", method = RequestMethod.GET)
//	public String singup() {
//		return "user/login";
//	}
	

}
