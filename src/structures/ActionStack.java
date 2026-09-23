package structures;

/**
 * ActionStack
 *
 * This class implements a Stack data structure
 * for storing recent actions performed in the system.
 *
 * Stack principle:
 * LIFO - Last In, First Out
 */
public class ActionStack {

    private String[] actions;
    private int top;

    /**
     * Constructor
     *
     * @param capacity maximum number of actions
     */
    public ActionStack(int capacity) {

        if (capacity <= 0) {
            capacity = 10;
        }

        actions = new String[capacity];

        // -1 means the stack is empty
        top = -1;
    }

    /**
     * Adds an action to the top of the stack.
     *
     * @param action action description
     */
    public void push(String action) {

        if (action == null || action.trim().isEmpty()) {
            System.out.println("Invalid action.");
            return;
        }

        if (isFull()) {
            System.out.println("Action history is full.");
            return;
        }

        top++;

        actions[top] = action;
    }

    /**
     * Removes the most recent action.
     *
     * @return removed action
     */
    public String pop() {

        if (isEmpty()) {
            return null;
        }

        String action = actions[top];

        actions[top] = null;

        top--;

        return action;
    }

    /**
     * Returns the most recent action
     * without removing it.
     *
     * @return latest action
     */
    public String peek() {

        if (isEmpty()) {
            return null;
        }

        return actions[top];
    }

    /**
     * Checks whether the stack is empty.
     *
     * @return true if empty
     */
    public boolean isEmpty() {

        return top == -1;
    }

    /**
     * Checks whether the stack is full.
     *
     * @return true if full
     */
    public boolean isFull() {

        return top == actions.length - 1;
    }

    /**
     * Returns number of stored actions.
     *
     * @return stack size
     */
    public int size() {

        return top + 1;
    }

    /**
     * Displays recent actions.
     * The newest action is displayed first.
     */
    public void display() {

        if (isEmpty()) {

            System.out.println("\nNo recent actions.");

            return;
        }

        System.out.println("\n========== RECENT ACTIONS ==========");

        for (int i = top; i >= 0; i--) {

            int number = top - i + 1;

            System.out.println(
                    number + ". " + actions[i]
            );
        }

        System.out.println("====================================");
    }
}