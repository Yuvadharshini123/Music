package com.musicalapp.Controller;

import org.apache.tomcat.util.descriptor.web.ContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicalapp.Dto.OtpRequest;
import com.musicalapp.Dto.OtpResponseDto;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/otp")
@Slf4j

public class OtpController {

//	@Autowired
//	private ContextService smsService;
//	
//	@GetMapping("/process")
//	public String processSMS() {
//		return "Sms Sent" ;
//		
//	}
	
	@PostMapping("/send-Otp")
	public OtpResponseDto sendOtp(@RequestBody OtpRequest otpRequest) {
		return null;
	
	}
	
	
}
