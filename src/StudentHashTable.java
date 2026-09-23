public class StudentHashTable {

    private Student[] hashTable;
    private int tableSize;

    // Special marker for deleted positions
    private final Student DELETED =
            new Student("__DELETED__", "DELETED", "NONE", 0);

    // Constructor
    public StudentHashTable(int size) {
        tableSize = size;
        hashTable = new Student[tableSize];
    }

    // Hash function
    private int hashFunction(String studentId) {
        return Math.abs(studentId.hashCode()) % tableSize;
    }

    // Insert student into Hash Table
    public void insert(Student student) {

        int index = hashFunction(student.getStudentId());
        int startIndex = index;

        // Linear probing for collision handling
        while (hashTable[index] != null && hashTable[index] != DELETED) {

            // Check duplicate Student ID
            if (hashTable[index].getStudentId()
                    .equals(student.getStudentId())) {

                System.out.println(
                        "Student ID already exists in Hash Table."
                );
                return;
            }

            index = (index + 1) % tableSize;

            // Hash Table is full
            if (index == startIndex) {
                System.out.println("Hash Table is full.");
                return;
            }
        }

        hashTable[index] = student;

        System.out.println(
                "Student added to Hash Table successfully."
        );
    }

    // Search student using Student ID
    public Student search(String studentId) {

        int index = hashFunction(studentId);
        int startIndex = index;

        while (hashTable[index] != null) {

            // Ignore deleted positions
            if (hashTable[index] != DELETED &&
                    hashTable[index].getStudentId().equals(studentId)) {

                return hashTable[index];
            }

            index = (index + 1) % tableSize;

            if (index == startIndex) {
                break;
            }
        }

        return null;
    }

    // Delete student from Hash Table
    public void delete(String studentId) {

        int index = hashFunction(studentId);
        int startIndex = index;

        while (hashTable[index] != null) {

            if (hashTable[index] != DELETED &&
                    hashTable[index].getStudentId().equals(studentId)) {

                hashTable[index] = DELETED;

                System.out.println(
                        "Student deleted from Hash Table successfully."
                );

                return;
            }

            index = (index + 1) % tableSize;

            if (index == startIndex) {
                break;
            }
        }

        System.out.println(
                "Student not found in Hash Table."
        );
    }

    // Display Hash Table
    public void displayHashTable() {

        System.out.println("\n=== HASH TABLE ===");

        for (int i = 0; i < tableSize; i++) {

            System.out.print("Index " + i + ": ");

            if (hashTable[i] != null && hashTable[i] != DELETED) {

                System.out.println(
                        hashTable[i].getStudentId()
                                + " - "
                                + hashTable[i].getName()
                );

            } else {

                System.out.println("Empty");
            }
        }
    }
}