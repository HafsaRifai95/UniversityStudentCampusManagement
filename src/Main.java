import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        StudentLinkedList studentList = new StudentLinkedList();

        int choice;

        do {
            System.out.println("\n======================================");
            System.out.println(" University Student Record Management ");
            System.out.println("======================================");
            System.out.println("1. Add Student Record");
            System.out.println("2. Update Student Record");
            System.out.println("3. Delete Student Record");
            System.out.println("4. Search Student Record");
            System.out.println("5. Display All Student Records");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            input.nextLine(); // Clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = input.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter Programme: ");
                    String programme = input.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = input.nextDouble();
                    input.nextLine();

                    if (marks < 0 || marks > 100) {
                        System.out.println("Invalid Marks! Enter between 0 and 100.");
                        break;
                    }

                    Student student = new Student(id, name, programme, marks);
                    studentList.addStudent(student);
                    break;

                case 2:
                    System.out.print("Enter Student ID to Update: ");
                    id = input.nextLine();

                    System.out.print("Enter New Name: ");
                    name = input.nextLine();

                    System.out.print("Enter New Programme: ");
                    programme = input.nextLine();

                    System.out.print("Enter New Marks: ");
                    marks = input.nextDouble();
                    input.nextLine();

                    if (marks < 0 || marks > 100) {
                        System.out.println("Invalid Marks! Enter between 0 and 100.");
                        break;
                    }

                    studentList.updateStudent(id, name, programme, marks);
                    break;

                case 3:
                    System.out.print("Enter Student ID to Delete: ");
                    id = input.nextLine();

                    studentList.deleteStudent(id);
                    break;

                case 4:
                    System.out.print("Enter Student ID to Search: ");
                    id = input.nextLine();

                    Student found = studentList.searchStudent(id);

                    if (found != null) {
                        System.out.println("\nStudent Found:");
                        System.out.println(found);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    studentList.displayStudents();
                    break;

                case 6:
                    System.out.println("Exiting Student Management System...");
                    break;

                default:
                    System.out.println("Invalid Choice! Please try again.");
            }

        } while (choice != 6);

        input.close();
    }
}