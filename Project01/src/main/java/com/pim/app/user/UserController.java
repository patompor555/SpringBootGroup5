package com.pim.app.user;

import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pim.domain.entity.Branch;
import com.pim.domain.entity.User;
import com.pim.domain.service.BranchService;
//import com.pim.app.branch.BranchForm;
//import com.pim.domain.entity.Branch;
import com.pim.domain.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	private int ID;
	
	@Autowired
	UserService userService;
	
	@Autowired
	BranchService branchService;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(Model model) {
		return "user/login";
	}
	
	@RequestMapping(value = "log_in", method = RequestMethod.GET)
    public String log_in(@RequestParam("email") String email, @RequestParam("password") String password,Model model) {
        
        List<User> userList = userService.findAllUser();

        int check = 0;
        int ID = 0;
        for(int i = 0;i<userList.size();i++) {
        	if(userList.get(i).getUserEmail().equals(email) && userList.get(i).getPassword().equals(password)  ) {

                check = 1;
                ID = userList.get(i).getUserID();
                break;
            }
        }
        this.ID=ID;
        if(check==1) {
        	return "redirect:/user/branch";
        }else {
            return "user/login";
        }

    }
	
	
	@RequestMapping(value = "branch", method = RequestMethod.GET)
    public String go_Main(Model model,Model model2) {
        List<Branch> branchList = branchService.findAllBranch();
        model2.addAttribute("User", userService.findUser(this.ID));
        model.addAttribute("branchList", branchList);
        return "branch/list";
    }
	
		
		
	@RequestMapping(value = "singup", params = "form", method = RequestMethod.GET)
	public String createForm(Model model) {
		model.addAttribute("userForm", new UserForm());
		return "user/singup";
	}
	
	@RequestMapping(value = "singup", method = RequestMethod.POST)
	public Object create(@ModelAttribute UserForm userForm) {
		userService.save(userForm);
		return "redirect:/user/login";
	}
	
	

}
