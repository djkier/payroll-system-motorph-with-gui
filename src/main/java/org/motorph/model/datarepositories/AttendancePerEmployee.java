package org.motorph.model.datarepositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.TreeMap;

public class AttendancePerEmployee {
    private String id;
    private TreeMap<LocalDate, AttendanceInADay> attendance;

    public AttendancePerEmployee(String id) {
        this.id = id;
        this.attendance = new TreeMap<>();
    }

    public void addNewAttendance(LocalDate day, LocalTime start, LocalTime end) {
        attendance.put(day, new AttendanceInADay(start, end));
    }



}
