package com.vaccination;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationService {
	public boolean registerUser(RegistrationRequestDAO registrationRequestDAO) {
		User user = new User();
		UUID id = UUID.randomUUID();
		user.setId(id.toString());
		user.setPhoneNumber(registrationRequestDAO.getPhoneNumber());
		user.setUserName(registrationRequestDAO.getUserName());
		save(user);
		return true;

	}
	
	public List<String> getUsers(){
		String query = "SELECT UserName FROM UserDetails";
		return DBConnection.users(query);
	}

	public boolean isValid(String userName) {
		for(String user:getUsers()) {
			if(user == userName) {
				return true;
			}
		}
		return false;
	}

	public boolean save(User user) {
		String query = "INSERT INTO UserDetails(id, userName, phoneNumber) Values('"+user.getId()+"' ,'"+user.getUserName()+"', '"+user.getPhoneNumber()+"');";
		DBConnection.register(query);
		return true;
	}
}
