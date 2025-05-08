package org.motorph.model.datarepositories;

import java.util.ArrayList;


public class DataProcessRepo {
    private EmployeeRepository employeeRepository;
    private AttendanceRepository attendanceRepository;

    public DataProcessRepo() {
        this.employeeRepository = new EmployeeRepository();
        this.attendanceRepository = new AttendanceRepository();
    }

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public void setEmployeeRepository(EmployeeRepository er) {
        this.employeeRepository = er;
    }

    //method for processing employee
    //with an assumption that the file being pass is a valid employee details
    public void processEmployeeDetails(ArrayList<String> file) {
        employeeRepository.processEmployeeDetails(file);
    }

    //method for processing attendance
    public void processAttendance(ArrayList<String> file) {
        attendanceRepository.processAttendance(file);
    }

//   testing
    public void findInstanceLastName(String lastname) {
        ArrayList<EmployeeDetails> emp = employeeRepository.getEmployeeWithLastNameStartsWith(lastname);
        emp.stream().forEach(System.out::println);
    }


}
