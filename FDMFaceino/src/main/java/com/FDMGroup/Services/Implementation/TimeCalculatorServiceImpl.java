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
		
		return getTime(period, time);
	}
	
	private String getTime(Period period, long time[]){
		if(period.getYears() != 0){
			return period.getYears() + " years";
		}
		return checkMonths(period, time);
	}

	private String checkMonths(Period period, long time[]){
		if(period.getMonths() != 0){
			return period.getMonths() + " months";
		}
		return checkDays(period, time);
	}
	
	private String checkDays(Period period, long time[]){
		if(period.getDays() != 0){
			return period.getMonths() + " days";
		}
		return checkHours(time);
	}
	
	private String checkHours(long time[]){
		if(time[0] != 0){
			return time[0] + " hours";
		}
		return checkMinutes(time);
	}
	
	private String checkMinutes(long time[]){
		if(time[1] != 0){
			return time[1] + " minutes";
		}
		return checkSeconds(time);
	}
	
	private String checkSeconds(long time[]){
		if(time[2] != 0){
			return time[2] + " seconds";
		}
		return "now";
	}
}
