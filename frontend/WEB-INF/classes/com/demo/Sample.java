package com.demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "2014-05-01";
		String e = "2014-05-10";
		LocalDate start = LocalDate.parse(s);
		LocalDate end = LocalDate.parse(e);
		List<LocalDate> totalDates = new ArrayList<>();
		while (!start.isAfter(end)) {
			totalDates.add(start);
			start = start.plusDays(1);
		}

		System.out.println(totalDates);

		Iterator<LocalDate> itr = totalDates.iterator();

		while (itr.hasNext()) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			System.out.println(formatter.format(itr.next()));
		}
	}

}
