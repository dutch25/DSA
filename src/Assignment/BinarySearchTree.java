package Assignment;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    private TreeNode root;

    //save to csv
    public void saveToCSV(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            List<Student> students = getStudentsSortedByMarks(true); // Get all students in sorted order
            for (Student student : students) {
                writer.write(student.getId() + "," + student.getName() + "," + student.getMark() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving students to file: " + e.getMessage());
        }
    }

    //insert
    public boolean insert(Student student) {
        if (search(student.getId()) != null) {
            return false; // Duplicate ID, do not insert
        }
        root = insertRec(root, student);
        return true;
    }

    private TreeNode insertRec(TreeNode root, Student student) {
        if (root == null) {
            root = new TreeNode(student);
            return root;
        }
        if (student.getId().compareTo(root.student.getId()) < 0) {
            root.left = insertRec(root.left, student);
        } else if (student.getId().compareTo(root.student.getId()) > 0) {
            root.right = insertRec(root.right, student);
        }
        return root;
    }

    //search
    public Student search(String id) {
    return searchRec(root, id);
}

    private Student searchRec(TreeNode root, String id) {
        if (root == null) return null;
        if (id.equals(root.student.getId())) return root.student;
        if (id.compareTo(root.student.getId()) < 0) return searchRec(root.left, id);
        return searchRec(root.right, id);
    }


    //delete
    public void delete(String id) {
        root = deleteRec(root, id);
    }
    
    private TreeNode deleteRec(TreeNode root, String id) {
        if (root == null) {
            System.out.println("Student with ID " + id + " not found.");
            return null;
        }
    
        // Traverse to the correct node
        if (id.compareTo(root.student.getId()) < 0) {
            root.left = deleteRec(root.left, id);
        } else if (id.compareTo(root.student.getId()) > 0) {
            root.right = deleteRec(root.right, id);
        } else {
            // Node found, handle deletion
            if (root.left == null) {
                // Case 1 & Case 2: No left child or leaf node
                return root.right;
            } else if (root.right == null) {
                // Case 2: No right child
                return root.left;
            } else {
                // Case 3: Node with two children
                // Find the in-order successor (smallest node in the right subtree)
                TreeNode successor = findMin(root.right);
    
                // Replace root's student with successor's student
                root.student = successor.student;
    
                // Delete the in-order successor from the right subtree
                root.right = deleteRec(root.right, successor.student.getId());
            }
        }
    
        return root;
    }
    
    // Helper function to find the smallest node in a subtree
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


    //edit
    public boolean edit(String id, String newName, Double newMark) {
        TreeNode target = searchNode(root, id); // Find the node by ID
        if (target == null) {
            return false; // Student not found
        }
        if (newName != null) {
            target.student.setName(newName); // Update name if provided
        }
        if (newMark != null) {
            target.student.setMark(newMark); // Update mark if provided
        }
        return true; 
    }
    
    private TreeNode searchNode(TreeNode root, String id) {
        if (root == null || root.student.getId().equals(id)) {
            return root;
        }
        if (id.compareTo(root.student.getId()) < 0) {
            return searchNode(root.left, id);
        }
        return searchNode(root.right, id);
    }
    
    

    //traversal
    public void inOrderTraversal() {
        inOrderRec(root);
    }

    private void inOrderRec(TreeNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.student);
            inOrderRec(root.right);
        }
    }

    //sort

    public List<Student> getStudentsSortedByMarks(boolean ascending) {
        List<Student> students = new ArrayList<>();
        collectStudents(root, students);
        students.sort((s1, s2) -> {
            if (ascending) {
                return Double.compare(s1.getMark(), s2.getMark());
            } else {
                return Double.compare(s2.getMark(), s1.getMark());
            }
        });
        return students;
    }

    private void collectStudents(TreeNode node, List<Student> students) {
        if (node != null) {
            collectStudents(node.left, students);
            students.add(node.student);
            collectStudents(node.right, students);
        }
    }
}
