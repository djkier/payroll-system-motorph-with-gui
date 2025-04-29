package org.motorph.model;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    private ArrayList<String> lines;

    public FileHandler() {
        this.lines = new ArrayList<>();
    }


    public void printFile() {
        for (int i = 0; i < this.lines.size(); i++) {
            System.out.println(lines.get(i));
        }
    }

    public void testing() {
        long startTime = System.currentTimeMillis();
        this.lines = preLoadEmpDetails();
        System.out.println(isValidEmployeeDetailFile(this.lines));
        printFile();

        this.lines = preLoadAttendance();
        System.out.println(isValidEmployeeDetailFile(this.lines));
        printFile();

        long endTime = System.currentTimeMillis();
        System.out.println("Process took " + (endTime - startTime) + "ms");
    }

    public ArrayList<String> openFile(String filePath) throws FileNotFoundException {
        InputStream is = new FileInputStream(filePath);
        return open(is);
    }

    public ArrayList<String> preLoadEmpDetails() {
        return open(getClass().getClassLoader().getResourceAsStream("employee-details.csv"));
    }

    public ArrayList<String> preLoadAttendance() {
        return open(getClass().getClassLoader().getResourceAsStream("employee-attendance.csv"));
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

        //Check entry length per row
        for (int i = 1; i < file.size(); i++) {
            String[] row = cleanSplit(file.get(i));
            if (w.length != row.length){
                return false;
            }
        }

        return true;
    }


    public Boolean isValidEmployeeDetailFile(ArrayList<String> file) {
        return isValidFile(file, FileHeader.detailHeader);
    }

    public Boolean isValidAttendanceFile(ArrayList<String> file) {
        return isValidFile(file, FileHeader.attendanceHeader);
    }

    public String[] cleanSplit(String line) {
        return line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
    }

}
