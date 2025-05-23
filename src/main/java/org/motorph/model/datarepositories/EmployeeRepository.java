package org.motorph.model.datarepositories;

import org.motorph.utility.TypeCleaner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeRepository {
    private HashMap<String, EmployeeDetails> repository;
    private HashMap<String, String> lastNameReference;

    public EmployeeRepository() {
        this.repository = new HashMap<>();
        this.lastNameReference = new HashMap<>();
    }

    public HashMap<String, EmployeeDetails> getRepository() {
        return repository;
    }

    //method for processing employee
    //with an assumption that the file being pass is a valid employee details
    public void processEmployeeDetails(ArrayList<String> file) {
        //Start on the second(1) row since first(0) row is the column title
        for (int i = 1; i < file.size(); i++) {

            String[] emp = TypeCleaner.cleanSplit(file.get(i));

            //Refer to the EmployeeDetails class to get the args label
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
            //get last name then use the string to search the repository
            lastNameReference.put(emp[1], emp[0]);
        }

    }



    public Object[][] employeeTableData() {
        ArrayList<Integer> sortId = new ArrayList<>();
        for (String key : repository.keySet()) {
            sortId.add(Integer.valueOf(key));
        }

        ArrayList<String> stringedId = sortedIntToStrArray(sortId);

        return tableData(stringedId);
    }

    public Object[][] tableData(ArrayList<String> list) {

        List<Object[]> dataList = new ArrayList<>();
        for (String id : list) {
            dataList.add(new Object[] {
                    repository.get(id).getId(),
                    repository.get(id).getFullName(),
                    repository.get(id).getBirthDate(),
                    repository.get(id).getPosition(),
                    repository.get(id).getStatus()
            });
        }

        return dataList.toArray(new Object[dataList.size()][]);

    }

    private ArrayList<String> sortedIntToStrArray(ArrayList<Integer> intArray) {
        Collections.sort(intArray);

        return intArray.stream()
                .map(String::valueOf)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public int totalEmployee() {
        return repository.size();
    }

    public int totalRegular() {
        int count = 0;
        for (String key : repository.keySet()) {
            if(repository.get(key).getStatus().equalsIgnoreCase("Regular")) {
                count++;
            }
        }

        return count;
    }

    public int totalProbationary() {
        int count = 0;
        for (String key : repository.keySet()) {
            if(repository.get(key).getStatus().equalsIgnoreCase("Probationary")) {
                count++;
            }
        }

        return count;
    }

}
