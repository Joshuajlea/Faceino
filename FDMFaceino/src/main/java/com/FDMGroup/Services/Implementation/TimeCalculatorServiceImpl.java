package com.FDMGroup.Services.Implementation;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

import org.springframework.stereotype.Component;

import com.FDMGroup.Services.TimeCalculatorService;

@Component
public class TimeCalculatorServiceImpl implements TimeCalculatorService{

	final int MINUTES_PER_HOUR = 60;
    final int SECONDS_PER_MINUTE = 60;
    final int SECONDS_PER_HOUR = SECONDS_PER_MINUTE * MINUTES_PER_HOUR;
	
	@Override
	public Period getPeriod(LocalDateTime dob, LocalDateTime now) {
		return Period.between(dob.toLocalDate(), now.toLocalDate());
	}

	@Override
	public long[] getTime(LocalDateTime dob, LocalDateTime now) {
		LocalDateTime today = LocalDateTime.of(now.getYear(),
                now.getMonthValue(), now.getDayOfMonth(), dob.getHour(), dob.getMinute(), dob.getSecond());
        Duration duration = Duration.between(today, now);

        long seconds = duration.getSeconds();

        long hours = seconds / SECONDS_PER_HOUR;
        long minutes = ((seconds % SECONDS_PER_HOUR) / SECONDS_PER_MINUTE);
        long secs = (seconds % SECONDS_PER_MINUTE);

        return new long[]{hours, minutes, secs};
	}

	@Override
	public String getTimeBetweenAsString(LocalDateTime dob, LocalDateTime now) {
		Period period = getPeriod(dob, now);
		long time[] = getTime(dob, now);
		
		return period.getYears() + " years " + 
                period.getMonths() + " months " + 
                period.getDays() + " days " +
                time[0] + " hours " +
                time[1] + " minutes " +
                time[2] + " seconds.";
	}

}
