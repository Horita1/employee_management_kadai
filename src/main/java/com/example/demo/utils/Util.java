package com.example.demo.utils;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Util {

	/*
	 * 年齢計算
	 */
	public int calculateAge(Date birthDate) {
		Calendar birthCal = Calendar.getInstance();
		birthCal.setTime(birthDate);
		Calendar nowCal = Calendar.getInstance();
		int age = nowCal.get(Calendar.YEAR) - birthCal.get(Calendar.YEAR);
		if(nowCal.get(Calendar.DAY_OF_YEAR) < birthCal.get(Calendar.DAY_OF_YEAR)) {
			age--;
		}
		return age;
	}
	
}
