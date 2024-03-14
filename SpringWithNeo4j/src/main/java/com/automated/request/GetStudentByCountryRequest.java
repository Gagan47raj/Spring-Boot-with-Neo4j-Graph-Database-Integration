package com.automated.request;

import java.util.List;

public class GetStudentByCountryRequest {

	private List<String> countries;
	
	public List<String> getCountries() {
		return countries;
	}
	
	public void setCountries(List<String> countries) {
		this.countries = countries;
	}
}
