package com.example.demo.service;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.LocalStats;

@Service
public class CoronaVirusServiceData {
	private static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

	@Autowired
	RestTemplate restTemplate;
	private List<LocalStats> allStats=new ArrayList<>();
     @Scheduled(cron="* * 1 * * *")
	public List<LocalStats> fetchVirusData() throws IOException {
    	 
    	 List<LocalStats> newStats=new ArrayList<>();
		String httpResponse = restTemplate.getForObject(VIRUS_DATA_URL, String.class);
//		System.out.println(httpResponse);
		StringReader csvBodyReader = new StringReader(httpResponse);
//		System.out.println(csvBodyReader);
	//	List<String> states = new ArrayList<>();
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
		
		for (CSVRecord record : records) {
			LocalStats localStat=new LocalStats();
			localStat.setCountry( record.get("Country/Region"));
			localStat.setLatestTotalCases( Integer.parseInt(record.get(record.size()-1)));
			
//			
			System.out.println(localStat);
			newStats.add(localStat);
		
			
			
			//System.out.println(state);
			//states.add(state);
		}
		Collections.sort(newStats, new Comparator<LocalStats>() {

			@Override
			public int compare(LocalStats o1, LocalStats o2) {
				if(o1.getLatestTotalCases()<o2.getLatestTotalCases())
				return 1;
				else return -1;
			}
		});
		return newStats;

	//	return states;
	}
	public List<LocalStats> getAllStats() {
		
		return allStats;
	}
	
	
}
