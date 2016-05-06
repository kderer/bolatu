package com.bolatu.rest.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolatu.service.api.response.BaseServiceResponse;
import com.bolatu.service.api.response.IndexResponse;
import com.bolatu.service.impl.response.IndexResponseImpl;
import com.bolatu.util.LogUtil;

@RestController
public class IndexController {
	
	@RequestMapping("/index")
	public BaseServiceResponse index(HttpServletRequest request) {
		
		LogUtil.RESTLOGGER.info("An index request from {}", request.getRemoteAddr());
		
		IndexResponse response = new IndexResponseImpl();
		response.setResultMessage("Welcome to imBolatu!");
		
		return response;
	}

}
