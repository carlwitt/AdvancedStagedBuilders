package de.witt.sandbox;

import java.util.OptionalInt;

public class BirthdayV1 {

	// required
	final int day;
	// required
	final int month;
	
	final OptionalInt year;
	final OptionalInt hour;
	final OptionalInt minute;

	public BirthdayV1(int year, int month, int day) {
		this.year = OptionalInt.of(year);
		this.month = month;
		this.day = day;
		this.hour = OptionalInt.empty();
		this.minute = OptionalInt.empty();
	}
	
	public BirthdayV1(int month, int day) {
		this.year = OptionalInt.empty();
		this.month = month;
		this.day = day;
		this.hour = OptionalInt.empty();
		this.minute = OptionalInt.empty();
	}
	
	public BirthdayV1(int month, int day, int hour, int minute) {
		this.year = OptionalInt.empty();
		this.month = month;
		this.day = day;
		this.hour = OptionalInt.of(hour);
		this.minute = OptionalInt.of(minute);
	} 

}
