package com.pim.domain.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pim.app.user.UserForm;
import com.pim.domain.entity.User;
import com.pim.domain.repository.UserRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public void save(UserForm userForm) {
		String status = "Inactive";
		Date date = Calendar.getInstance().getTime();
		User user = new User();
		user.setFname(userForm.getFname());
		user.setLname(userForm.getLname());
		user.setUserEmail(userForm.getUserEmail());
		user.setPassword(userForm.getPassword());
		user.setCreatedDate(date);
		user.setStatus(status);
		userRepository.save(user);
	}
	
	public List<User> findAllUser() {
		return userRepository.findAll();
	}
	
	public UserForm findUser(int id) {
        User UserLogin = userRepository.getOne(id);
        return new UserForm(UserLogin.getUserID(), UserLogin.getFname(), UserLogin.getLname(),UserLogin.getUserEmail(),UserLogin.getPassword());
    }

}
