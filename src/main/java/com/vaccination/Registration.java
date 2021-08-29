package com.vaccination;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Registration {
	@PostMapping("/register")
	public ApiResponse register(@RequestBody RegistrationRequestDAO registrationRequestDAO) {
		RegistrationService registrationService = new RegistrationService();
		ApiResponse response = new ApiResponse();
        registrationService.registerUser(registrationRequestDAO);
		if (registrationService.isValid(registrationRequestDAO.getUserName())) {
			if (registrationService.registerUser(registrationRequestDAO)) {
				response.setResponseCode(200);
				response.setMessage("Your Registration is successful");
			} else {
				response.setResponseCode(400);
				response.setMessage("You have been already a user");
			}
		} else {
			response.setResponseCode(400);
			response.setMessage("Your name is already registered so give unique name.");
		}
		return response;
	}
}
