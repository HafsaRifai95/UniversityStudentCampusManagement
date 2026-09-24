public class StudentBST {

    private StudentTreeNode root;

    public StudentBST() {
        root = null;
    }

    public void insert(Student student) {
        root = insertRecursive(root, student);
    }

    private StudentTreeNode insertRecursive(
            StudentTreeNode current,
            Student student) {

        if (current == null) {
            System.out.println("Student added to BST successfully.");
            return new StudentTreeNode(student);
        }

        if (student.getStudentId().compareTo(current.student.getStudentId()) < 0) {

            current.left = insertRecursive(current.left, student);

        } else if (student.getStudentId().compareTo(current.student.getStudentId()) > 0) {

            current.right = insertRecursive(current.right, student);

        } else {

            System.out.println("Student ID already exists in BST.");
        }

        return current;
    }

    public Student search(String studentId) {
        return searchRecursive(root, studentId);
    }

    private Student searchRecursive(
            StudentTreeNode current,
            String studentId) {

        if (current == null) {
            return null;
        }

        int comparison = studentId.compareTo(current.student.getStudentId());

        if (comparison == 0) {
            return current.student;
        }

        if (comparison < 0) {
            return searchRecursive(current.left, studentId);
        }

        return searchRecursive(current.right, studentId);
    }

    public void displayStudents() {

        if (root == null) {
            System.out.println("BST is empty.");
            return;
        }

        System.out.println("\n=== STUDENTS IN BST ===");

        inOrderTraversal(root);
    }

    private void inOrderTraversal(StudentTreeNode current) {

        if (current != null) {

            inOrderTraversal(current.left);

            current.student.displayStudent();

            inOrderTraversal(current.right);
        }
    }

    public void delete(String studentId) {

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

        int comparison = studentId.compareTo(current.student.getStudentId());

        if (comparison < 0) {

            current.left = deleteRecursive(
                    current.left,
                    studentId
            );

        } else if (comparison > 0) {

            current.right = deleteRecursive(
                    current.right,
                    studentId
            );

        } else {

            if (current.left == null) {
                return current.right;
            }

            if (current.right == null) {
                return current.left;
            }

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

    private StudentTreeNode findSmallest(
            StudentTreeNode current) {

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }
}