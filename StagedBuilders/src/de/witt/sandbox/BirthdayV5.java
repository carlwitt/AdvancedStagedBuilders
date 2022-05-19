package de.witt.sandbox;

import java.time.LocalDateTime;
import java.util.OptionalInt;

/**
 * Stage reuse via generics.
 * 
 * Composite stage "time" for hour and minute with default method to unpack a
 * value into the hour stage and the minute stage.
 * 
 * @author Carl Witt, KNIME AG, Zurich, Switzerland
 */
public class BirthdayV5 {

	// required
	final int day;
	// required
	final int month;

	final OptionalInt year;
	final OptionalInt hour;
	final OptionalInt minute;

	private BirthdayV5(FinalStage builder) {
		this.day = builder.day;
		this.month = builder.month;
		this.year = builder.year;
		this.hour = builder.hour;
		this.minute = builder.minute;
	}

	public static RequireMonth<RequireDay<AllowBuild>> builder() {
		return month -> day -> new FinalStage(day, month);
	}

	public interface RequireDay<S> {
		public S withDay(int day);
	}

	public interface RequireMonth<S> {
		public S withMonth(int month);
	}

	public interface RequireTime<S> extends RequireHour<RequireMinute<S>> {
		default S withTime(LocalDateTime time) {
			return withHour(time.getHour()).withMinute(time.getMinute());
		}
	}

	public interface RequireHour<S> {
		public S withHour(int hour);
	}

	public interface RequireMinute<S> {
		public S withMinute(int minute);
	}

	public interface AllowBuild extends RequireTime<AllowBuild> {
		AllowBuild withYear(int year);

		BirthdayV5 build();
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
		public RequireMinute<AllowBuild> withHour(int hour) {
			return minute -> {
				this.hour = OptionalInt.of(hour);
				this.minute = OptionalInt.of(minute);
				return this;
			};
		}

		@Override
		public BirthdayV5 build() {
			return new BirthdayV5(this);
		}
	}

}
