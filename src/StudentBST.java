public class StudentBST {

    private StudentTreeNode root;

    // Constructor
    public StudentBST() {
        root = null;
    }

    // Insert a student
    public void insert(Student student) {
        root = insertRecursive(root, student);
    }

    private StudentTreeNode insertRecursive(
            StudentTreeNode current,
            Student student) {

        // Create a new node
        if (current == null) {
            System.out.println("Student added to BST successfully.");
            return new StudentTreeNode(student);
        }

        // Compare Student IDs
        int comparison = student.getStudentId()
                .compareTo(current.student.getStudentId());

        // Smaller Student ID goes to the left
        if (comparison < 0) {

            current.left = insertRecursive(current.left, student);

        }
        // Larger Student ID goes to the right
        else if (comparison > 0) {

            current.right = insertRecursive(current.right, student);

        }
        // Duplicate Student ID
        else {

            System.out.println("Student ID already exists in BST.");
        }

        return current;
    }

    // Search for a student using Student ID
    public Student search(String studentId) {
        return searchRecursive(root, studentId);
    }

    private Student searchRecursive(
            StudentTreeNode current,
            String studentId) {

        // Student not found
        if (current == null) {
            return null;
        }

        int comparison = studentId
                .compareTo(current.student.getStudentId());

        // Student found
        if (comparison == 0) {
            return current.student;
        }

        // Search left subtree
        if (comparison < 0) {
            return searchRecursive(current.left, studentId);
        }

        // Search right subtree
        return searchRecursive(current.right, studentId);
    }

    // Display all students using in-order traversal
    public void displayStudents() {

        if (root == null) {
            System.out.println("BST is empty.");
            return;
        }

        System.out.println("\n=== STUDENTS IN BST ===");

        inOrderTraversal(root);
    }

    // In-order traversal
    private void inOrderTraversal(StudentTreeNode current) {

        if (current != null) {

            // Left
            inOrderTraversal(current.left);

            // Root
            current.student.displayStudent();

            // Right
            inOrderTraversal(current.right);
        }
    }

    // Delete a student from BST
    public void delete(String studentId) {

        // Check whether student exists first
        if (search(studentId) == null) {
            System.out.println("Student not found in BST.");
            return;
        }

        root = deleteRecursive(root, studentId);

        System.out.println("Student deleted from BST successfully.");
    }

    private StudentTreeNode deleteRecursive(
            StudentTreeNode current,
            String studentId) {

        if (current == null) {
            return null;
        }

        int comparison = studentId
                .compareTo(current.student.getStudentId());

        // Search left subtree
        if (comparison < 0) {

            current.left = deleteRecursive(
                    current.left,
                    studentId
            );

        }
        // Search right subtree
        else if (comparison > 0) {

            current.right = deleteRecursive(
                    current.right,
                    studentId
            );

        }
        // Student found
        else {

            // Case 1: No left child
            if (current.left == null) {
                return current.right;
            }

            // Case 2: No right child
            if (current.right == null) {
                return current.left;
            }

            // Case 3: Two children
            StudentTreeNode smallestNode =
                    findSmallest(current.right);

            current.student = smallestNode.student;

            current.right = deleteRecursive(
                    current.right,
                    smallestNode.student.getStudentId()
            );
        }

        return current;
    }

    // Find smallest node
    private StudentTreeNode findSmallest(
            StudentTreeNode current) {

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }
}