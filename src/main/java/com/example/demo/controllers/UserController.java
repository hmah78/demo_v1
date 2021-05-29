package com.example.demo.controllers;
import com.example.demo.repositories.UserRepository;
import com.example.demo.models.User;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "userController")
@ELBeanName(value = "userController")
@Join(path = "/addnewuser", to = "/registration-form.jsf")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	private User user = new User();

	public String save() {

		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		user = new User();
		return "/login";
	}

	public User getUser() {
		return user;
	}
}
