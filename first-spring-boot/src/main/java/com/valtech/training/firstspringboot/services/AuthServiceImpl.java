package com.valtech.training.firstspringboot.services;

import java.util.Arrays;
import java.util.Objects;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.firstspringboot.entities.User;
import com.valtech.training.firstspringboot.models.ChangePassWordModel;
import com.valtech.training.firstspringboot.models.RegisterUserModel;
import com.valtech.training.firstspringboot.repository.UserRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AuthServiceImpl implements AuthService,UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostConstruct
	public void populateUsers() {
		RegisterUserModel model= new RegisterUserModel();
		model.setUsername("root");
		model.setPassword("root");
		createUser(model);
		
		model.setUsername("admin");
		model.setPassword("admin");
		User user=createUser(model);
	
	}
	
	@Override
	public User createUser(RegisterUserModel regUSerModel) {
		User user= new User(regUSerModel.getUsername(), passwordEncoder.encode(regUSerModel.getPassword()),Arrays.asList("ROLE_USER","ROLE_ADMIN"));
		user.setEnabled(true);
		return userRepo.save(user);
		
				
	}
	@Override
	public boolean  ChangePassword(ChangePassWordModel passwordModel) {
		User user= userRepo.findByUsername(passwordModel.getUsername());
		if(passwordEncoder.matches(passwordModel.getOldPassword(),user.getPassword() ))
//				Objects.equals(passwordModel.getOldPassword(), passwordModel.getNewPassword()))
//			
		{
			user.setPassword(passwordEncoder.encode(passwordModel.getNewPassword()));
			userRepo.save(user);
			return true ;
//			if(Objects.equals(pwdModel.getNewPassword(), pwdModel.getConfirmPassword()))
		}
	
		return false;
	}
	
	@Override
	public void upgradeUserToAdmin(long id) {
		User user=userRepo.getReferenceById(id);
//		user.add
		user.addRole("ROLE_ADMIN");
		
		
	}
@Override
public void enabledUser(long id) {
	userRepo.getReferenceById(id).setEnabled(true);
	
}
@Override
public void disabledUser(long id) {
	userRepo.getReferenceById(id).setEnabled(false);
	
}

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	return userRepo.findByUsername(username);
}
}
