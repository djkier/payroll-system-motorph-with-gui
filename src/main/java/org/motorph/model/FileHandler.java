package org.motorph.model;

import org.motorph.model.datarepositories.DataProcessRepo;
import org.motorph.utility.TypeCleaner;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    private String fileNameLoaded;
    private String fileNameEmpDet;
    private String fileNameAtt;
    private DataProcessRepo dataProcessRepo;

    public FileHandler() {
        this.fileNameLoaded = "";
        this.fileNameEmpDet = "";
        this.fileNameAtt = "";
        this.dataProcessRepo = new DataProcessRepo();
    }

    public DataProcessRepo getRepository() {
        return this.dataProcessRepo;
    }

    //Opening employee details and attendance file will have seperate method
    //for the action listener of the button to be use and
    //avoid the system to change the other file if it is not the intention

    //Try to open and process employee details file
    public boolean tryProcessEmployeeFile(String filePath) throws FileNotFoundException {
        ArrayList<String> lines = openFile(filePath);
        if (isValidEmployeeDetailFile(lines)) {
            this.fileNameEmpDet = this.fileNameLoaded;
            //function that will process the file.
            dataProcessRepo.processEmployeeDetails(lines);
            return true;
        }
        return false;
    }

    //Try to open and process attendance file
    public boolean tryProcessAttendanceFile(String filePath) throws FileNotFoundException {
        ArrayList<String> lines = openFile(filePath);
        if (isValidAttendanceFile(lines)) {
            this.fileNameAtt = this.fileNameLoaded;
            //function that will process the file
            dataProcessRepo.processAttendance(lines);

            return true;
        }

        return false;
    }

    public void preLoadEmpDetails() {
        ArrayList<String> lines = open(getClass().getClassLoader().getResourceAsStream("employee-details.csv"));
        this.fileNameEmpDet = "employee-details.csv";
        dataProcessRepo.processEmployeeDetails(lines);
    }

    public void preLoadAttendance() {
        ArrayList<String> lines = open(getClass().getClassLoader().getResourceAsStream("employee-attendance.csv"));
        this.fileNameAtt = "employee-attendance.csv";
        dataProcessRepo.processAttendance(lines);
    }


    public ArrayList<String> openFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        this.fileNameLoaded = file.getName();

        InputStream is = new FileInputStream(file);
        return open(is);
    }



    public ArrayList<String> open(InputStream is) {
        ArrayList<String> list = new ArrayList<>();

        if (is == null) {
            System.out.println("File not found!");
            return list;
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            System.out.println("File does not exist!");
        } finally {
            //close input stream
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        return list;
    }

    public Boolean isValidEmployeeDetailFile(ArrayList<String> file) {
        return isValidFile(file, FileHeader.detailHeader);
    }

    public Boolean isValidAttendanceFile(ArrayList<String> file) {
        return isValidFile(file, FileHeader.attendanceHeader);
    }

    public Boolean isValidFile(ArrayList<String> file, String comparedTo) {
        String[] w = comparedTo.split(",");
        String[] fHead = file.get(0).split(",");

        //Check coloumn title
        if (w.length != fHead.length) {
            return false;
        }

        for (int i = 0; i < w.length; i++) {
            if (!w[i].trim().equalsIgnoreCase(fHead[i].trim())) {
                return false;
            }
        }

        //Check basic integrity of rows by comparing the length of it
        //to the intended size
        for (int i = 1; i < file.size(); i++) {
            String[] row = TypeCleaner.cleanSplit(file.get(i));
            if (w.length != row.length){
                return false;
            }
        }

        return true;
    }






}
