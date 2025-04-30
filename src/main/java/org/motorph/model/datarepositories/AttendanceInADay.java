package org.motorph.model.datarepositories;

import org.motorph.utility.TypeCleaner;

import java.time.LocalTime;

public class AttendanceInADay {
    private LocalTime start;
    private LocalTime end;

    public AttendanceInADay(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public double computeWorkingHours() {
        //Work start @ 8AM
        //convert start as a minutes for the day
        int startHour = convertHoursToMinutes(start);
        int startMinutes = start.getMinute();
        int startTotalMinutes = startHour + startMinutes;
        //Workers start before 8 will be computed as 8AM
        //Workers start within 10 minutes after 8AM (>= 8:10) will be computed as 8AM
        if (startTotalMinutes <= (8 * 60) + 10) {
            startTotalMinutes = 8 * 60;
        }

        int endHour = convertHoursToMinutes(end);
        int endMinutes = end.getMinute();
        int endTotalMinutes = endHour + endMinutes;
        //Assume worker work until or after 12:00 AM / 24:00 with a limit until 3AM
        if (endTotalMinutes <= (3 * 60)) {
            endTotalMinutes = endTotalMinutes + (24 * 60);
        }

        int totalMinuteWorked = endTotalMinutes - startTotalMinutes;
        double totalHoursWorked =  totalMinuteWorked / 60.0;
        return TypeCleaner.cleanDouble(totalHoursWorked);
    }

    private int convertHoursToMinutes(LocalTime time) {
        return time.getHour() * 60;
    }
}
