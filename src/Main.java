public class Main {

    public static void main(String[] args) {

        // Create BST
        StudentBST studentBST = new StudentBST();

        // Create sample students
        Student s1 = new Student(105, "Kamal", "IT", 75.5);
        Student s2 = new Student(101, "Nimal", "Software Engineering", 82.0);
        Student s3 = new Student(110, "Ahamed", "IT", 68.5);
        Student s4 = new Student(103, "Fathima", "Data Science", 91.0);

        // Insert students into BST
        studentBST.insert(s1);
        studentBST.insert(s2);
        studentBST.insert(s3);
        studentBST.insert(s4);

        // Display before deletion
        System.out.println("\n=== BEFORE DELETION ===");
        studentBST.displayStudents();

        // Delete Student ID 101
        System.out.println("\n=== DELETE STUDENT 101 ===");
        studentBST.delete(101);

        // Display after deletion
        System.out.println("\n=== AFTER DELETION ===");
        studentBST.displayStudents();

        // Search for deleted student
        System.out.println("\n=== SEARCH DELETED STUDENT 101 ===");

        Student foundStudent = studentBST.search(101);

        if (foundStudent != null) {
            System.out.println("Student found:");
            foundStudent.displayStudent();
        } else {
            System.out.println("Student not found.");
        }
    }
}