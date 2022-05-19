package de.witt.sandbox;

import java.util.OptionalInt;

/**
 * Improve readability using builder.
 * 
 * @author Carl Witt, KNIME AG, Zurich, Switzerland
 */
public class BirthdayV2 {

	// required
	final int day;
	// required
	final int month;

	final OptionalInt year;
	final OptionalInt hour;
	final OptionalInt minute;

	private BirthdayV2(Builder builder) {
		this.day = builder.day;
		this.month = builder.month;
		this.year = builder.year;
		this.hour = builder.hour;
		this.minute = builder.minute;
	}
	
	public static final class Builder {
		private int day;
		private int month;
		private OptionalInt year;
		private OptionalInt hour;
		private OptionalInt minute;

		public Builder(int day, int month) {
			this.day = day;
			this.month = month;
		}
		
		public Builder withYear(int year) {
			this.year = OptionalInt.of(year);
			return this;
		}

		public Builder withHour(int hour) {
			this.hour = OptionalInt.of(hour);
			return this;
		}

		public Builder withMinute(int minute) {
			this.minute = OptionalInt.of(minute);
			return this;
		}

		public BirthdayV2 build() {
			return new BirthdayV2(this);
		}
	}
	
	public static Builder builder(int day, int month) {
		return new Builder(day, month);
	}

}
