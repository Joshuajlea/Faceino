package com.FDMGroup.Services;

import java.time.LocalDateTime;
import java.time.Period;

public interface TimeCalculatorService {
	Period getPeriod(LocalDateTime dob, LocalDateTime now);
	long[] getTime(LocalDateTime dob, LocalDateTime now);
	String getTimeBetweenAsString(LocalDateTime dob, LocalDateTime now);
}
