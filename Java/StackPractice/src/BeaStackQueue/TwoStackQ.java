package BeaStackQueue;
/*
we are expected to implement an abstract data type queue using the enqueue and dequeue operations with stacks
we can use 2 stacks to solve this problem
-one stack to do the enqueue operation
-one stack for the dequeue operation
 */

public class TwoStackQ {
    //use one stack for enqueue operation
    private Stack<Integer> enqueueStack;
    //use another stack for the dequeue operation
    private Stack<Integer> dequeueStack;

    public TwoStackQ() {
        this.enqueueStack = new Stack<>();
        this.dequeueStack = new Stack<>();
    }

    //adding an item to the queue is O(1) operation
    public void enqueue(int item) {
        this.enqueueStack.push(item);
    }

    public int dequeue() {

        //no items in the stacks
        if (enqueueStack.isEmpty() && dequeueStack.isEmpty())
            throw new RuntimeException("Stacks are empty...");

        //if the dequeueStack is empty we have to add items O(N) time
        if (dequeueStack.isEmpty()) {

            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }

        //otherwise we just have to pop off an item in O(1)
        return dequeueStack.pop();
    }
}
