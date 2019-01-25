package BeaStackQueue;

import java.util.Stack;

public class OneStackQ_Recursive {


    // use one stack for enqueue operation
    private java.util.Stack<Integer> stack;

    public OneStackQ_Recursive() {
        this.stack = new Stack<>();
    }

    // adding an item to the queue is O(1) operation
    public void enqueue(int item) {
        this.stack.push(item);
    }

    // NOTE: we use 2 stacks again but instead of explicitly define the second stack we
    // use the call-stack of program (stack memory or execution stack)
    public int dequeue() {

        // base case for the recursive method calls the first item
        //is what we are after (this is what we need for queue's dequeue operation)
        if (stack.size() == 1) {//this would be the first itm showing up in the queue so it is what is returned 
            return stack.pop();
        }

        // we keep popping the items until we find the last one
        int item = stack.pop();

        // we call the method recursively
        int lastDequeuedItem = dequeue();

        // after we find the item we dequeue we have to reinsert the items one by one
        enqueue(item);

        // this is the item we are looking for (this is what have been popped off in the
        // stack.size()==1 section
        return lastDequeuedItem;
    }
}

