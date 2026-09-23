public class Student {

 member-3
    private int studentId;

    private String studentId;
 main
    private String name;
    private String programme;
    private double marks;

 member-3
    // Constructor
    public Student(int studentId, String name, String programme, double marks) {

    public Student(String studentId, String name, String programme, double marks) {
 main
        this.studentId = studentId;
        this.name = name;
        this.programme = programme;
        this.marks = marks;
    }

 member-3
    // Getters
    public int getStudentId() {

    public String getStudentId() {
 main
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

 member-3
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

 member-3
    // Display student details
    public void displayStudent() {
        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + name);
        System.out.println("Programme  : " + programme);
        System.out.println("Marks      : " + marks);
        System.out.println("----------------------------");

    @Override
    public String toString() {
        return "Student ID: " + studentId +
               " | Name: " + name +
               " | Programme: " + programme +
               " | Marks: " + marks;
 main
    }
}