package com.example.demo.controllers;
import com.example.demo.repositories.UserRepository;
import com.example.demo.models.User;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Scope (value = "session")
@Component (value = "userList")
@ELBeanName(value = "userList")
@Join(path = "/", to = "/user-list.jsf")
public class UserListController {
	@Autowired
	private UserRepository userRepository;

	private List<User> users;

	@Deferred
	@RequestAction
	@IgnorePostback
	public void loadData() {
		users = userRepository.findAll();
	}

	public List<User> getUsers() {
		return users;
	}
}
