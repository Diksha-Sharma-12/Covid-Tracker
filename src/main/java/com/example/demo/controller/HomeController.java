package com.example.demo.controller;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.LocalStats;
import com.example.demo.service.CoronaVirusServiceData;

@Controller
public class HomeController {
	@Autowired
	CoronaVirusServiceData coronaVirusServiceData;
	
	@GetMapping("/")
	public String home(Model model) throws IOException
	{   
	List<LocalStats> list = coronaVirusServiceData.fetchVirusData();
//	System.out.println(list);
	     int totalReportedCases =list.stream().mapToInt(stat->stat.getLatestTotalCases()).sum();
		model.addAttribute("LocalStats",list);	
		model.addAttribute("totalReportedCases",totalReportedCases);
		System.out.println(model);
		
		return "home";
	}
	
	

}
