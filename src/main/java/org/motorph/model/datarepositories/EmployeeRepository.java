package org.motorph.model.datarepositories;

import org.motorph.utility.TypeCleaner;

import java.util.ArrayList;
import java.util.HashMap;

public class EmployeeRepository {
    private HashMap<String, EmployeeDetails> repository;

    public EmployeeRepository() {
        this.repository = new HashMap<>();
    }

    //method for processing employee
    //with an assumption that the file being pass is a valid employee details
    public void processEmployeeDetails(ArrayList<String> file) {

        //Start on the second(1) row since first(0) row is the column title
        for (int i = 1; i < file.size(); i++) {
            String[] emp = TypeCleaner.cleanSplit(file.get(i));

            EmployeeDetails employee = new EmployeeDetails(
                    emp[0], emp[1], emp[2], emp[3], emp[4],
                    emp[5], emp[6], emp[7], emp[8], emp[9],
                    emp[10], emp[11], emp[12],
                    TypeCleaner.convertStringToMoney(emp[13]),
                    TypeCleaner.convertStringToMoney(emp[14]),
                    TypeCleaner.convertStringToMoney(emp[15]),
                    TypeCleaner.convertStringToMoney(emp[16]),
                    TypeCleaner.convertStringToMoney(emp[17]),
                    TypeCleaner.convertStringToMoney(emp[18])
            );

            //Keep the id to string, assuming it may have a leading zero
            repository.put(emp[0], employee);
        }

    }
}
