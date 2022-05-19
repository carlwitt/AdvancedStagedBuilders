package de.witt.sandbox;

import java.util.OptionalInt;

/**
 * When setting the optional hour value, force setting the minute also.
 * 
 * @author Carl Witt, KNIME AG, Zurich, Switzerland
 */
public class BirthdayV4 {

	// required
	final int day;
	// required
	final int month;

	final OptionalInt year;
	final OptionalInt hour;
	final OptionalInt minute;

	private BirthdayV4(FinalStage builder) {
		this.day = builder.day;
		this.month = builder.month;
		this.year = builder.year;
		this.hour = builder.hour;
		this.minute = builder.minute;
	}

	public static RequireDay builder() {
		return day -> month -> new FinalStage(day, month);
	}

	public interface RequireDay {
		public RequireMonth withDay(int day);
	}

	public interface RequireMonth {
		public AllowBuild withMonth(int month);
	}

	public interface RequireMinute {
		public AllowBuild withMinute(int minute);
	}
	
	public interface AllowBuild {
		AllowBuild withYear(int year);
		RequireMinute withHour(int hour);
		BirthdayV4 build();
	}

	private static final class FinalStage implements AllowBuild {
		private int day;
		private int month;
		private OptionalInt year;
		private OptionalInt hour;
		private OptionalInt minute;

		private FinalStage(int day, int month) {
			this.day = day;
			this.month = month;
		}

		@Override
		public AllowBuild withYear(int year) {
			this.year = OptionalInt.of(year);
			return this;
		}

		@Override
		public RequireMinute withHour(int hour) {
			this.hour = OptionalInt.of(hour);
			return minute -> {this.minute = OptionalInt.of(minute); return this;};
		}

		@Override
		public BirthdayV4 build() {
			return new BirthdayV4(this);
		}
	}

}
