package org.motorph.model;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileHandler {
    private ArrayList<String> lines;

    public FileHandler() {
        this.lines = new ArrayList<>();
    }

    public void printFile() {
        for (int i = 0; i < 5; i++) {
            System.out.println(lines.get(i));
        }
    }

    public void testing() {
        this.lines = preLoadEmpDetails();

        printFile();

        this.lines = preLoadAttendance();
        printFile();

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

}
