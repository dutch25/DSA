package Assignment;

import Helper.readCSV;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        String filePath = "students.csv";
        readCSV.loadStudentsFromCSV(filePath, bst);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add new student");
            System.out.println("2. Search student");
            System.out.println("3. Delete student");
            System.out.println("4. Edit student");
            System.out.println("5. Show student list");
            System.out.println("6. Sort students by marks");
            System.out.println("7. Exit");
            
            int choice = -1;
            while (choice < 1 || choice > 7) {
                System.out.print("Choose an option (1-7): ");
                try {
                    choice = Integer.parseInt(scanner.nextLine().trim());
                    if (choice < 1 || choice > 7) {
                        System.out.println("Invalid choice, please choose between 1 and 7.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a number between 1 and 7.");
                }
            }

            switch (choice) {
                case 1:
                    // Input validation for student details
                    String id = "";
                    while (id.isEmpty()) {
                        System.out.print("Enter ID: ");
                        id = scanner.nextLine().trim();
                        if (id.isEmpty()) {
                            System.out.println("ID cannot be empty. Please enter a valid ID.");
                        } else if (bst.search(id) != null) {
                            System.out.println("A student with this ID already exists. Please use a different ID.");
                            id = ""; // Reset ID to force re-entry
                        }
                    }

                    String name = "";
                    while (name.isEmpty()) {
                        System.out.print("Enter name: ");
                        name = scanner.nextLine().trim();
                        if (name.isEmpty()) {
                            System.out.println("Name cannot be empty. Please enter a valid name.");
                        }
                    }

                    Double mark = null;
                    while (mark == null) {
                        System.out.print("Enter mark: ");
                        try {
                            mark = Double.parseDouble(scanner.nextLine().trim());
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid mark! Please enter a valid numeric value.");
                        }
                    }

                    Student newStudent = new Student(id, name, mark);
                    bst.insert(newStudent);

                    bst.saveToCSV(filePath);

                    System.out.println("Student added!");
                    break;

                case 2:
                    System.out.print("Enter ID to search: ");
                    String idSearch = scanner.nextLine().trim();
                    Student student = bst.search(idSearch);
                    if (student == null) {
                        System.out.println("Student not found!");
                    } else {
                        System.out.println("Student details: " + student);
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    String idToDelete = scanner.nextLine().trim();
                    if (bst.search(idToDelete) == null) {
                        System.out.println("Student not found. Cannot delete.");
                    } else {
                        bst.delete(idToDelete);
                        bst.saveToCSV(filePath);
                        System.out.println("Student deleted successfully!");
                    }
                    break;

                case 4: 
                    System.out.print("Enter ID of the student to edit: ");
                    String editId = scanner.nextLine().trim();
                    if (bst.search(editId) == null) {
                        System.out.println("Student not found. Cannot edit.");
                        break;
                    }
                    System.out.print("Enter new name (or press Enter to skip): ");
                    String newName = scanner.nextLine().trim();
                    Double newMark = null;
                    while (true) {
                        System.out.print("Enter new mark (or press Enter to skip): ");
                        String newMarkInput = scanner.nextLine().trim();
                        if (newMarkInput.isEmpty()) {
                            break; 
                        }
                        try {
                            newMark = Double.parseDouble(newMarkInput);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid mark entered. Please enter a valid number or press Enter to skip.");
                        }
                    }
                    boolean isEdited = bst.edit(editId, newName.isEmpty() ? null : newName, newMark);
                    if (isEdited) {
                        bst.saveToCSV(filePath);
                        System.out.println("Student details updated successfully!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 5:
                    System.out.println("Student list:");
                    bst.inOrderTraversal();
                    break;

                case 6:
                    System.out.println("Choose sorting order:");
                    System.out.println("1. Low to High");
                    System.out.println("2. High to Low");
                    System.out.print("Enter your choice: ");
                    int sortChoice = -1;
                    while (sortChoice != 1 && sortChoice != 2) {
                        try {
                            sortChoice = Integer.parseInt(scanner.nextLine().trim());
                            if (sortChoice != 1 && sortChoice != 2) {
                                System.out.println("Invalid choice, please choose 1 or 2.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input! Please enter 1 or 2.");
                        }
                    }

                    // Get the list of sorted students based on the choice
                    List<Student> sortedStudents;
                    if (sortChoice == 1) {
                        sortedStudents = bst.getStudentsSortedByMarks(true);  // Ascending (Low to High)
                    } else {
                        sortedStudents = bst.getStudentsSortedByMarks(false);  // Descending (High to Low)
                    }

                    System.out.println("Students sorted by marks:");
                    for (Student studentInList : sortedStudents) {
                        System.out.println(studentInList);
                    }
                    break;

                case 7:
                    System.out.println("Exiting program.");
                    return;

                default:
                    System.out.println("Invalid choice!");
                    break;
            } 
            
        }
    }
}
