package user;

import java.time.LocalDateTime;

import de.witt.sandbox.BirthdayV1;
import de.witt.sandbox.BirthdayV2;
import de.witt.sandbox.BirthdayV3;
import de.witt.sandbox.BirthdayV4;
import de.witt.sandbox.BirthdayV5;

public class Usage { //NOSONAR

	// Simple constructor V1
	static {
		new BirthdayV1(3, 4); // April? March?
		new BirthdayV1(3, 4, 5, 6); // ???
	}

	// Regular builder V2 
	static {
		// required parameters as builder constructor argument
		BirthdayV2.builder(3, 4).withYear(1841);
	}

	// Staged builder V3 
	static {
		// force setters for required parameters to be called before build() 
		BirthdayV3.builder() // build() isn't exposed yet, just withDay()
			.withDay(3) 	 // only withMonth() can be called next
			.withMonth(4) 	 // from now we can build() or provide set optional values
			.withHour(11) 
			.build();
	}
	
	// Staged Builder V4
	static {
		// either BOTH hour and minute are set or NEITHER
		BirthdayV4.builder()
			.withDay(3)
			.withMonth(4)
			.withHour(11) // cannot build without providing minute
			.withMinute(12) // back to optional stage, provide year or build()
			.build();
	}
	
	// Staged Builder V5 
	static {
		// aggregate stage with unpack method
		BirthdayV5.builder().withMonth(3).withDay(4).withHour(11).withMinute(59).build();
		BirthdayV5.builder().withMonth(3).withDay(4).withTime(LocalDateTime.now()).build();
	}

}
