package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LocalStats;
import com.example.demo.service.CoronaVirusServiceData;

@RestController
@RequestMapping("/virus")
public class Controller {

	@Autowired
	CoronaVirusServiceData coronaVirusService;
	
	
	@GetMapping("/get")
	public List<LocalStats> getDetails() throws IOException {
		 return coronaVirusService.fetchVirusData();
	}
	
}
