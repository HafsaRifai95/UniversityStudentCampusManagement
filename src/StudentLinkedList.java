public class StudentLinkedList {

    // Node class
    class Node {
        Student student;
        Node next;

        Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    // Head of the linked list
    private Node head;

    // Constructor
    public StudentLinkedList() {
        head = null;
    }

    // Add Student
    public boolean addStudent(Student student) {

        // Check duplicate Student ID
        if (searchStudent(student.getStudentId()) != null) {
            System.out.println("Student ID already exists.");
            return false;
        }

        Node newNode = new Node(student);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        System.out.println("Student added successfully.");
        return true;
    }

    // Display All Students
    public void displayStudents() {

        if (head == null) {
            System.out.println("\nNo student records found.");
            return;
        }

        Node current = head;

        System.out.println("\n========== STUDENT RECORDS ==========");

        while (current != null) {
            System.out.println(current.student);
            current = current.next;
        }

        System.out.println("=====================================");
    }

    // Search Student by ID
    public Student searchStudent(String studentId) {

        Node current = head;

        while (current != null) {

            if (current.student.getStudentId().equalsIgnoreCase(studentId)) {
                return current.student;
            }

            current = current.next;
        }

        return null;
    }

    // Update Student
    public boolean updateStudent(String studentId,
                                 String name,
                                 String programme,
                                 double marks) {

        Student student = searchStudent(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return false;
        }

        student.setName(name);
        student.setProgramme(programme);
        student.setMarks(marks);

        System.out.println("Student updated successfully.");
        return true;
    }

    // Delete Student
    public boolean deleteStudent(String studentId) {

        if (head == null) {
            System.out.println("No student records available.");
            return false;
        }

        // Delete first node
        if (head.student.getStudentId().equalsIgnoreCase(studentId)) {
            head = head.next;
            System.out.println("Student deleted successfully.");
            return true;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.student.getStudentId().equalsIgnoreCase(studentId)) {
                current.next = current.next.next;
                System.out.println("Student deleted successfully.");
                return true;
            }

            current = current.next;
        }

        System.out.println("Student not found.");
        return false;
    }
}