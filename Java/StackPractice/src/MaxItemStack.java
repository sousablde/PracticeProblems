import BeaStackQueue.Stack;

/*
The aim is to design an algorithm that can return the maximum item of a stack in O(1) running time complexity. We can use O(N) extra memory!

Hint: we can use another stack to track the max item
I want to track the largest item during the insertion itself
 */
public class MaxItemStack {
    //the original stack
    private Stack<Integer> mainStack;

    //stack to store largest elements
    private Stack<Integer> maxStack;

    public MaxItemStack() {
        this.mainStack = new Stack<>();
        this.maxStack = new Stack<>();
    }

    public void push(int item) {
        //push new item to stack
        mainStack.push(item);

        //first item is the same in both stacks
        if (mainStack.size() == 1) {
            maxStack.push(item);
            return;
        }

        //if the current item is the largest that appeared so far
        if (item > maxStack.peek()) {
            maxStack.push(item);
        } else {
            //if not the largest one then we duplicate the largest one in the maxstack
            maxStack.push(maxStack.peek());
        }
    }

    public int pop() {
        maxStack.pop();
        return mainStack.pop();
    }

    public int getMaxItem() {
        return maxStack.peek();
    }

}
