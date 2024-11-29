package Helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Assignment.BinarySearchTree;
import Assignment.Student;

public class readCSV {
    public static void loadStudentsFromCSV(String filePath, BinarySearchTree bst) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String name = data[1];
                double mark = Double.parseDouble(data[2]);
                Student student = new Student(id, name, mark);
                bst.insert(student);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
