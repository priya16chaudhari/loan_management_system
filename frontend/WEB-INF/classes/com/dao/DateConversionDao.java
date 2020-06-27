package com.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


import com.beans.AccountBeans;

public class DateConversionDao {
	
	public static ArrayList<String> DatesList(String startDate, String endDate){
		
		LocalDate start = LocalDate.parse(startDate);
		LocalDate end = LocalDate.parse(endDate);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		ArrayList<String> totalDates = new ArrayList<>();
		while (!start.isAfter(end)) {
			totalDates.add(formatter.format(start).toString());
			start = start.plusDays(1);
		}

		return totalDates;
	}
	
	
	public static void main(String[] args) {
		AccountBeans ab = FetchBorrowerDao.getBorrowerAccountDetailsById("2");
		System.out.println(ab);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate start = LocalDate.parse(ab.getStartDate().replace("/", "-"));
		LocalDate end = LocalDate.parse(ab.getEndDate().replace("/", "-"));
		
	}

}
