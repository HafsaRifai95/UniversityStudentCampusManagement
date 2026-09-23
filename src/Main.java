import java.util.Scanner;

import structures.ActionStack;
import structures.ServiceQueue;
import structures.ServiceRequest;

import graph.Graph;
import graph.GraphTraversal;

public class Main {

    // Data structures
    private static StudentLinkedList studentList = new StudentLinkedList();
    private static StudentBST studentBST = new StudentBST();
    private static StudentHashTable hashTable = new StudentHashTable(20);
    private static ActionStack actionStack = new ActionStack(20);
    private static ServiceQueue serviceQueue = new ServiceQueue(20);
    private static Graph campusGraph = new Graph();

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            displayMainMenu();
            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    studentManagementMenu();
                    break;

                case 2:
                    bstMenu();
                    break;

                case 3:
                    hashTableMenu();
                    break;

                case 4:
                    serviceQueueMenu();
                    break;

                case 5:
                    actionStackMenu();
                    break;

                case 6:
                    graphMenu();
                    break;

                case 7:
                    System.out.println("\nThank you for using the University Student Campus Management System.");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 7.");
            }

        } while (choice != 7);

        input.close();
    }

    // =========================================================
    // MAIN MENU
    // =========================================================

    private static void displayMainMenu() {

        System.out.println("\n==============================================");
        System.out.println(" UNIVERSITY STUDENT CAMPUS MANAGEMENT SYSTEM");
        System.out.println("==============================================");
        System.out.println("1. Student Management");
        System.out.println("2. BST Operations");
        System.out.println("3. Hash Table Operations");
        System.out.println("4. Service Request Queue");
        System.out.println("5. Recent Actions Stack");
        System.out.println("6. Campus Graph");
        System.out.println("7. Exit");
        System.out.println("==============================================");
    }

    // =========================================================
    // STUDENT MANAGEMENT - LINKED LIST
    // =========================================================

    private static void studentManagementMenu() {

        int choice;

        do {

            System.out.println("\n========== STUDENT MANAGEMENT ==========");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Back to Main Menu");

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    updateStudent();
                    break;

                case 3:
                    deleteStudent();
                    break;

                case 4:
                    searchStudent();
                    break;

                case 5:
                    studentList.displayStudents();
                    break;

                case 6:
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 6);
    }

    private static void addStudent() {

        System.out.println("\n========== ADD STUDENT ==========");

        String id = readNonEmptyString("Enter Student ID: ");

        if (studentList.searchStudent(id) != null) {
            System.out.println("Student ID already exists.");
            return;
        }

        String name = readNonEmptyString("Enter Student Name: ");
        String programme = readNonEmptyString("Enter Programme: ");
        double marks = readMarks();

        Student student = new Student(id, name, programme, marks);

        if (studentList.addStudent(student)) {

            // Also add the student to BST and Hash Table
            studentBST.insert(student);
            hashTable.insert(student);

            actionStack.push("Added student " + id);

            System.out.println("Student added to all required structures.");
        }
    }

    private static void updateStudent() {

        System.out.println("\n========== UPDATE STUDENT ==========");

        String id = readNonEmptyString("Enter Student ID to update: ");

        Student student = studentList.searchStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        String name = readNonEmptyString("Enter New Name: ");
        String programme = readNonEmptyString("Enter New Programme: ");
        double marks = readMarks();

        if (studentList.updateStudent(id, name, programme, marks)) {

            // Rebuild BST and Hash Table later if needed.
            // The main student record has been updated.
            actionStack.push("Updated student " + id);
        }
    }

    private static void deleteStudent() {

        System.out.println("\n========== DELETE STUDENT ==========");

        String id = readNonEmptyString("Enter Student ID to delete: ");

        Student student = studentList.searchStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        studentList.deleteStudent(id);

        // Delete from BST and Hash Table
        studentBST.delete(id);
        hashTable.delete(id);

        actionStack.push("Deleted student " + id);
    }

    private static void searchStudent() {

        System.out.println("\n========== SEARCH STUDENT ==========");

        String id = readNonEmptyString("Enter Student ID to search: ");

        Student student = studentList.searchStudent(id);

        if (student != null) {

            System.out.println("\nStudent Found:");
            student.displayStudent();

        } else {

            System.out.println("Student not found.");
        }
    }

    // =========================================================
    // BST
    // =========================================================

    private static void bstMenu() {

        int choice;

        do {

            System.out.println("\n========== BST OPERATIONS ==========");
            System.out.println("1. Insert Student into BST");
            System.out.println("2. Search Student in BST");
            System.out.println("3. Delete Student from BST");
            System.out.println("4. Display BST Students");
            System.out.println("5. Back to Main Menu");

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    insertBST();
                    break;

                case 2:
                    searchBST();
                    break;

                case 3:
                    deleteBST();
                    break;

                case 4:
                    studentBST.displayStudents();
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);
    }

    private static void insertBST() {

        String id = readNonEmptyString("Enter Student ID: ");

        Student student = studentList.searchStudent(id);

        if (student == null) {
            System.out.println("Student does not exist in the student records.");
            return;
        }

        studentBST.insert(student);
        actionStack.push("Inserted student " + id + " into BST");
    }

    private static void searchBST() {

        String id = readNonEmptyString("Enter Student ID to search: ");

        Student student = studentBST.search(id);

        if (student != null) {

            System.out.println("\nStudent Found in BST:");
            student.displayStudent();

        } else {

            System.out.println("Student not found in BST.");
        }
    }

    private static void deleteBST() {

        String id = readNonEmptyString("Enter Student ID to delete from BST: ");

        if (studentBST.search(id) == null) {
            System.out.println("Student not found in BST.");
            return;
        }

        studentBST.delete(id);
        actionStack.push("Deleted student " + id + " from BST");
    }

    // =========================================================
    // HASH TABLE
    // =========================================================

    private static void hashTableMenu() {

        int choice;

        do {

            System.out.println("\n========== HASH TABLE OPERATIONS ==========");
            System.out.println("1. Insert Student");
            System.out.println("2. Search Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display Hash Table");
            System.out.println("5. Back to Main Menu");

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    insertHashTable();
                    break;

                case 2:
                    searchHashTable();
                    break;

                case 3:
                    deleteHashTable();
                    break;

                case 4:
                    hashTable.displayHashTable();
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);
    }

    private static void insertHashTable() {

        String id = readNonEmptyString("Enter Student ID: ");

        Student student = studentList.searchStudent(id);

        if (student == null) {
            System.out.println("Student does not exist in the student records.");
            return;
        }

        hashTable.insert(student);
        actionStack.push("Inserted student " + id + " into Hash Table");
    }

    private static void searchHashTable() {

        String id = readNonEmptyString("Enter Student ID to search: ");

        Student student = hashTable.search(id);

        if (student != null) {

            System.out.println("\nStudent Found in Hash Table:");
            student.displayStudent();

        } else {

            System.out.println("Student not found in Hash Table.");
        }
    }

    private static void deleteHashTable() {

        String id = readNonEmptyString("Enter Student ID to delete: ");

        if (hashTable.search(id) == null) {
            System.out.println("Student not found in Hash Table.");
            return;
        }

        hashTable.delete(id);
        actionStack.push("Deleted student " + id + " from Hash Table");
    }

    // =========================================================
    // SERVICE REQUEST QUEUE
    // =========================================================

    private static void serviceQueueMenu() {

        int choice;

        do {

            System.out.println("\n========== SERVICE REQUEST QUEUE ==========");
            System.out.println("1. Add Service Request");
            System.out.println("2. Process Next Request");
            System.out.println("3. View Next Request");
            System.out.println("4. Display All Requests");
            System.out.println("5. Back to Main Menu");

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addServiceRequest();
                    break;

                case 2:
                    processServiceRequest();
                    break;

                case 3:
                    viewNextRequest();
                    break;

                case 4:
                    serviceQueue.display();
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);
    }

    private static void addServiceRequest() {

        System.out.println("\n========== ADD SERVICE REQUEST ==========");

        String requestId = readNonEmptyString("Enter Request ID: ");
        String studentId = readNonEmptyString("Enter Student ID: ");

        if (studentList.searchStudent(studentId) == null) {
            System.out.println("Student not found. Request cannot be added.");
            return;
        }

        String requestType =
                readNonEmptyString("Enter Request Type: ");

        ServiceRequest request =
                new ServiceRequest(requestId, studentId, requestType);

        serviceQueue.enqueue(request);

        actionStack.push(
                "Added service request " + requestId
        );
    }

    private static void processServiceRequest() {

        ServiceRequest request = serviceQueue.dequeue();

        if (request == null) {

            System.out.println("No service requests available.");

        } else {

            System.out.println("\nProcessed Request:");
            System.out.println(request);

            actionStack.push(
                    "Processed service request "
                            + request.getRequestId()
            );
        }
    }

    private static void viewNextRequest() {

        ServiceRequest request = serviceQueue.peek();

        if (request == null) {

            System.out.println("No pending service requests.");

        } else {

            System.out.println("\nNext Request:");
            System.out.println(request);
        }
    }

    // =========================================================
    // ACTION STACK
    // =========================================================

    private static void actionStackMenu() {

        int choice;

        do {

            System.out.println("\n========== RECENT ACTIONS STACK ==========");
            System.out.println("1. View Latest Action");
            System.out.println("2. Remove Latest Action");
            System.out.println("3. Display All Actions");
            System.out.println("4. Display Stack Size");
            System.out.println("5. Back to Main Menu");

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    viewLatestAction();
                    break;

                case 2:
                    removeLatestAction();
                    break;

                case 3:
                    actionStack.display();
                    break;

                case 4:
                    System.out.println(
                            "Number of stored actions: "
                                    + actionStack.size()
                    );
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);
    }

    private static void viewLatestAction() {

        String action = actionStack.peek();

        if (action == null) {

            System.out.println("No recent actions.");

        } else {

            System.out.println("Latest Action: " + action);
        }
    }

    private static void removeLatestAction() {

        String action = actionStack.pop();

        if (action == null) {

            System.out.println("No recent actions to remove.");

        } else {

            System.out.println(
                    "Removed Latest Action: " + action
            );
        }
    }

    // =========================================================
    // CAMPUS GRAPH
    // =========================================================

    private static void graphMenu() {

        int choice;

        do {

            System.out.println("\n========== CAMPUS GRAPH ==========");
            System.out.println("1. Add Campus Location");
            System.out.println("2. Remove Campus Location");
            System.out.println("3. Add Connection");
            System.out.println("4. Remove Connection");
            System.out.println("5. Display Campus Network");
            System.out.println("6. BFS Traversal");
            System.out.println("7. DFS Traversal");
            System.out.println("8. Back to Main Menu");

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addCampusLocation();
                    break;

                case 2:
                    removeCampusLocation();
                    break;

                case 3:
                    addCampusConnection();
                    break;

                case 4:
                    removeCampusConnection();
                    break;

                case 5:
                    displayCampusNetwork();
                    break;

                case 6:
                    performBFS();
                    break;

                case 7:
                    performDFS();
                    break;

                case 8:
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 8);
    }

    private static void addCampusLocation() {

        int location = readInt("Enter Campus Location ID: ");

        if (campusGraph.getAdjacencyList().containsKey(location)) {

            System.out.println("Campus location already exists.");

        } else {

            campusGraph.addVertex(location);

            System.out.println(
                    "Campus location added successfully."
            );

            actionStack.push(
                    "Added campus location " + location
            );
        }
    }

    private static void removeCampusLocation() {

        int location = readInt("Enter Campus Location ID to remove: ");

        if (!campusGraph.getAdjacencyList().containsKey(location)) {

            System.out.println("Campus location not found.");

        } else {

            campusGraph.removeVertex(location);

            System.out.println(
                    "Campus location removed successfully."
            );

            actionStack.push(
                    "Removed campus location " + location
            );
        }
    }

    private static void addCampusConnection() {

        int location1 =
                readInt("Enter First Location ID: ");

        int location2 =
                readInt("Enter Second Location ID: ");

        if (location1 == location2) {

            System.out.println(
                    "A location cannot be connected to itself."
            );
            return;
        }

        if (!campusGraph.getAdjacencyList()
                .containsKey(location1)
                || !campusGraph.getAdjacencyList()
                .containsKey(location2)) {

            System.out.println(
                    "Both campus locations must exist first."
            );
            return;
        }

        campusGraph.addEdge(location1, location2);

        System.out.println(
                "Campus connection added successfully."
        );

        actionStack.push(
                "Added connection "
                        + location1 + " - " + location2
        );
    }

    private static void removeCampusConnection() {

        int location1 =
                readInt("Enter First Location ID: ");

        int location2 =
                readInt("Enter Second Location ID: ");

        if (!campusGraph.getAdjacencyList()
                .containsKey(location1)
                || !campusGraph.getAdjacencyList()
                        .containsKey(location2)) {

            System.out.println(
                    "One or both campus locations do not exist."
            );
            return;
        }

        campusGraph.removeEdge(location1, location2);

        System.out.println(
                "Campus connection removed successfully."
        );

        actionStack.push(
                "Removed connection "
                        + location1 + " - " + location2
        );
    }

    private static void displayCampusNetwork() {

        System.out.println("\n========== CAMPUS NETWORK ==========");

        if (campusGraph.getAdjacencyList().isEmpty()) {

            System.out.println("No campus locations available.");

        } else {

            campusGraph.displayGraph();
        }
    }

    private static void performBFS() {

        if (campusGraph.getAdjacencyList().isEmpty()) {

            System.out.println(
                    "No campus locations available."
            );
            return;
        }

        int start =
                readInt("Enter Starting Location ID: ");

        if (!campusGraph.getAdjacencyList().containsKey(start)) {

            System.out.println(
                    "Starting location does not exist."
            );
            return;
        }

        GraphTraversal.BFS(
                campusGraph.getAdjacencyList(),
                start
        );

        actionStack.push(
                "Performed BFS from location " + start
        );
    }

    private static void performDFS() {

        if (campusGraph.getAdjacencyList().isEmpty()) {

            System.out.println(
                    "No campus locations available."
            );
            return;
        }

        int start =
                readInt("Enter Starting Location ID: ");

        if (!campusGraph.getAdjacencyList().containsKey(start)) {

            System.out.println(
                    "Starting location does not exist."
            );
            return;
        }

        GraphTraversal.DFS(
                campusGraph.getAdjacencyList(),
                start
        );

        actionStack.push(
                "Performed DFS from location " + start
        );
    }

    // =========================================================
    // INPUT VALIDATION
    // =========================================================

    private static int readInt(String message) {

        while (true) {

            System.out.print(message);

            String value = input.nextLine().trim();

            try {

                return Integer.parseInt(value);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input! Please enter a valid number."
                );
            }
        }
    }

    private static double readMarks() {

        while (true) {

            System.out.print("Enter Marks (0 - 100): ");

            String value = input.nextLine().trim();

            try {

                double marks = Double.parseDouble(value);

                if (marks >= 0 && marks <= 100) {

                    return marks;
                }

                System.out.println(
                        "Invalid marks! Please enter a value between 0 and 100."
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input! Please enter a numeric mark."
                );
            }
        }
    }

    private static String readNonEmptyString(String message) {

        while (true) {

            System.out.print(message);

            String value = input.nextLine().trim();

            if (!value.isEmpty()) {

                return value;
            }

            System.out.println(
                    "Input cannot be empty. Please try again."
            );
        }
    }
}