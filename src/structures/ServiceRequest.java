package structures;

/**
 * Represents a service request made by a student.
 */
public class ServiceRequest {

    private String requestId;
    private String studentId;
    private String requestType;

    /**
     * Creates a service request.
     *
     * @param requestId unique request ID
     * @param studentId student ID
     * @param requestType type of service requested
     */
    public ServiceRequest(
            String requestId,
            String studentId,
            String requestType) {

        this.requestId = requestId;
        this.studentId = studentId;
        this.requestType = requestType;
    }

    public String getRequestId() {

        return requestId;
    }

    public String getStudentId() {

        return studentId;
    }

    public String getRequestType() {

        return requestType;
    }

    @Override
    public String toString() {

        return "Request ID: " + requestId
                + " | Student ID: " + studentId
                + " | Request: " + requestType;
    }
}