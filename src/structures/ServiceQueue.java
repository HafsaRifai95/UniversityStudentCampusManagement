package structures;

/**
 * ServiceQueue
 *
 * This class implements a Queue data structure
 * for managing student service requests.
 *
 * Queue principle:
 * FIFO - First In, First Out
 */
public class ServiceQueue {

    private ServiceRequest[] queue;

    private int front;

    private int rear;

    private int size;

    /**
     * Constructor.
     *
     * @param capacity maximum queue capacity
     */
    public ServiceQueue(int capacity) {

        if (capacity <= 0) {
            capacity = 10;
        }

        queue = new ServiceRequest[capacity];

        front = 0;

        rear = -1;

        size = 0;
    }

    /**
     * Adds a request to the rear of the queue.
     *
     * @param request service request
     */
    public void enqueue(ServiceRequest request) {

        if (request == null) {

            System.out.println("Invalid service request.");

            return;
        }

        if (isFull()) {

            System.out.println("Service request queue is full.");

            return;
        }

        rear = (rear + 1) % queue.length;

        queue[rear] = request;

        size++;
    }

    /**
     * Removes the first request from the queue.
     *
     * @return processed request
     */
    public ServiceRequest dequeue() {

        if (isEmpty()) {

            return null;
        }

        ServiceRequest request = queue[front];

        queue[front] = null;

        front = (front + 1) % queue.length;

        size--;

        return request;
    }

    /**
     * Returns the first request without removing it.
     *
     * @return next request
     */
    public ServiceRequest peek() {

        if (isEmpty()) {

            return null;
        }

        return queue[front];
    }

    /**
     * Checks whether queue is empty.
     *
     * @return true if empty
     */
    public boolean isEmpty() {

        return size == 0;
    }

    /**
     * Checks whether queue is full.
     *
     * @return true if full
     */
    public boolean isFull() {

        return size == queue.length;
    }

    /**
     * Returns number of requests.
     *
     * @return queue size
     */
    public int size() {

        return size;
    }

    /**
     * Displays all waiting requests.
     */
    public void display() {

        if (isEmpty()) {

            System.out.println(
                    "\nNo pending service requests."
            );

            return;
        }

        System.out.println(
                "\n========== SERVICE QUEUE =========="
        );

        for (int i = 0; i < size; i++) {

            int index =
                    (front + i) % queue.length;

            System.out.println(
                    (i + 1) + ". " + queue[index]
            );
        }

        System.out.println(
                "==================================="
        );
    }
}