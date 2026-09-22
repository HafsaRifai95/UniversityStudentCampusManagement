package structures;

/**
 * Tests the Stack and Queue implementations
 * created by Member 2.
 */
public class Member2Test {

    public static void main(String[] args) {

        /*
         * =========================================
         * STACK TEST
         * =========================================
         */

        System.out.println(
                "========================================"
        );

        System.out.println(
                "          MEMBER 2 - STACK TEST"
        );

        System.out.println(
                "========================================"
        );

        ActionStack actionStack =
                new ActionStack(10);

        // Add actions
        actionStack.push(
                "Student ST001 added"
        );

        actionStack.push(
                "Student ST002 added"
        );

        actionStack.push(
                "Student ST001 updated"
        );

        actionStack.push(
                "Student ST002 deleted"
        );

        // Display stack
        actionStack.display();

        // Peek
        System.out.println(
                "\nLatest Action:"
        );

        System.out.println(
                actionStack.peek()
        );

        // Pop
        System.out.println(
                "\nRemoving Latest Action:"
        );

        System.out.println(
                actionStack.pop()
        );

        // Display after pop
        System.out.println(
                "\nStack After Removing Latest Action:"
        );

        actionStack.display();


        /*
         * =========================================
         * QUEUE TEST
         * =========================================
         */

        System.out.println(
                "\n\n========================================"
        );

        System.out.println(
                "          MEMBER 2 - QUEUE TEST"
        );

        System.out.println(
                "========================================"
        );

        ServiceQueue serviceQueue =
                new ServiceQueue(10);

        // Add request 1
        serviceQueue.enqueue(
                new ServiceRequest(
                        "REQ001",
                        "ST001",
                        "Transcript Request"
                )
        );

        // Add request 2
        serviceQueue.enqueue(
                new ServiceRequest(
                        "REQ002",
                        "ST002",
                        "Student ID Request"
                )
        );

        // Add request 3
        serviceQueue.enqueue(
                new ServiceRequest(
                        "REQ003",
                        "ST003",
                        "Course Registration"
                )
        );

        // Display queue
        serviceQueue.display();

        // Peek
        System.out.println(
                "\nNext Request:"
        );

        System.out.println(
                serviceQueue.peek()
        );

        // Dequeue
        System.out.println(
                "\nProcessing Request:"
        );

        System.out.println(
                serviceQueue.dequeue()
        );

        // Display after processing
        System.out.println(
                "\nQueue After Processing:"
        );

        serviceQueue.display();
    }
}