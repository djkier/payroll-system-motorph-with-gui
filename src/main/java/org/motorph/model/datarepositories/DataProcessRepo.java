package org.motorph.model.datarepositories;

import java.util.ArrayList;


public class DataProcessRepo {
    //Hashmap for employee details
    private EmployeeRepository employeeRepository;
    //Hashmap for the attendance

    public DataProcessRepo() {
        this.employeeRepository = new EmployeeRepository();
    }

    //method for processing employee
    //with an assumption that the file being pass is a valid employee details
    public void processEmployeeDetails(ArrayList<String> file) {
        employeeRepository.processEmployeeDetails(file);
    }

    //method for processing attendance

}
