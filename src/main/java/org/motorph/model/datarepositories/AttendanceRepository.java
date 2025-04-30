package org.motorph.model.datarepositories;

import org.motorph.utility.TypeCleaner;

import java.util.ArrayList;
import java.util.HashMap;

public class AttendanceRepository {
    private HashMap<String, AttendancePerEmployee> repository;

    public AttendanceRepository() {
        this.repository = new HashMap<>();
    }

    //method for processing attendance
    //with an assumption that the file being pass is a valid attendance details
    public void processAttendance(ArrayList<String> file) {

        //Start on the second(1) row since first(0) row is the column title
        for (int i = 1; i < file.size(); i++) {
            String[] att = TypeCleaner.cleanSplit(file.get(i));

            //if ID do not exist in repository
            if (!(repository.containsKey(att[0]))) {
                AttendancePerEmployee empAttendance = new AttendancePerEmployee(att[0]);
                addNewAttendance(empAttendance, att[3], att[4], att[5]);
                repository.put(att[0], empAttendance);
            } else {
                addNewAttendance(repository.get(att[0]), att[3], att[4], att[5]);
            }
        }
    }

    private void addNewAttendance(AttendancePerEmployee empAtt, String date, String start, String end) {
        empAtt.addNewAttendance(
                TypeCleaner.convertStringToDate(date),
                TypeCleaner.convertStringToTime(start),
                TypeCleaner.convertStringToTime(end)
        );
    }





}
