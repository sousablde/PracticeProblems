package BeaStackQueue;

public class StackArr<U> {
    private U[] stack;
    private int nOItems;

    public StackArr() {
        this.stack = (U[]) new Object[1];
    }

    public void push(U newData) {
        if (nOItems == this.stack.length) {
            resize(2 * this.stack.length);
        }
        this.stack[nOItems++] = newData;
    }

    public U pop() {
        U item2pop = this.stack[--nOItems];
        if (nOItems > 0 && nOItems == this.stack.length / 4) {
            resize(this.stack.length / 2);
        }
        return item2pop;
    }

    private void resize(int capacity) {
        U[] stackCopy = (U[]) new Object[capacity];

        for (int i = 0; i < nOItems; ++i) {
            stackCopy[i] = this.stack[i];
            this.stack = stackCopy;
        }
    }

    public boolean isEmpty() {
        return this.nOItems == 0;

    }

    public int size() {
        return this.nOItems;
    }

}
