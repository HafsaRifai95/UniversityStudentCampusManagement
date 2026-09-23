public class Student {

    private String studentId;
    private String name;
    private String programme;
    private double marks;

 fix-student-data-structures

    // Constructor
 main
    public Student(String studentId, String name, String programme, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.programme = programme;
        this.marks = marks;
    }

 fix-student-data-structures

    // Getters
 main
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getProgramme() {
        return programme;
    }

    public double getMarks() {
        return marks;
    }

 fix-student-data-structures

    // Setters
 main
    public void setName(String name) {
        this.name = name;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

 fix-student-data-structures

    // Display student details
 main
    public void displayStudent() {
        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + name);
        System.out.println("Programme  : " + programme);
        System.out.println("Marks      : " + marks);
        System.out.println("----------------------------");
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId +
               " | Name: " + name +
               " | Programme: " + programme +
               " | Marks: " + marks;
    }
}