public class Student {

    private int studentId;
    private String name;
    private String programme;
    private double marks;

    // Constructor
    public Student(int studentId, String name, String programme, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.programme = programme;
        this.marks = marks;
    }

    // Getters
    public int getStudentId() {
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

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    // Display student details
    public void displayStudent() {
        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + name);
        System.out.println("Programme  : " + programme);
        System.out.println("Marks      : " + marks);
        System.out.println("----------------------------");
    }
}