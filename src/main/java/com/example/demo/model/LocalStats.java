package com.example.demo.model;

public class LocalStats {
	private String country;
	private int latestTotalCases;
//	public String getState() {
//		return state;
//	}
//	public   void setState(String state) {
//		this.state = state;
//	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getLatestTotalCases() {
		return latestTotalCases;
	}
	public void setLatestTotalCases(int latestTotalCases) {
		this.latestTotalCases = latestTotalCases;
	}
	@Override
	public String toString() {
		return "LocalStats [ "+ " country=" + country + ", latestTotalCases=" + latestTotalCases + "]";
	}
	
}
