package com.fabirvale.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabirvale.workshopmongo.domain.User;
import com.fabirvale.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;//mecanismo de injeção de dependencia automatica do spring
	
	public List<User> findAll(){
		return repo.findAll();
	}

}
