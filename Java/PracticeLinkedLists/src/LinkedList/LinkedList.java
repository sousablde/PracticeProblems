package LinkedList;

public class LinkedList<T extends Comparable<T>> implements ListInterface<T> {

    private Node<T> root;
    private int sizeOfList;


    /*
    Construct an in-place (without extra memory) algorithm that is able to find the middle node
    naive solution: iterate through the list, count how many elements, traverse again return
    index count/2 as the solution
    using 2 pointers: O(N) first pointer traverses the linked list one node at a time
    second pointer a slow pointer will traverse the list 2 nodes at a time
    when the faster pointer reaches the end then the slower pointer is at the middle
    Solution for finding the mid node
     */
    @Override
    public Node<T> getMidNode() {
        Node<T> fastPointer = this.root;
        Node<T> slowPointer = this.root;

        while (fastPointer.getNextNode() != null && fastPointer.getNextNode().getNextNode() != null) {
            fastPointer = fastPointer.getNextNode().getNextNode();
            slowPointer = slowPointer.getNextNode();
        }
        return slowPointer;
    }

    /*
    Construct an in-place algorithm to reverse a linked list!
     */



    @Override
    public void insert(T data) {
        ++this.sizeOfList;

        if (root == null) {
            this.root = new Node<>(data);

        } else {
            insertDataStart(data);
        }
    }

    //O(1)
    private void insertDataStart(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNextNode(root);
        this.root = newNode;//new inserted node becomes the root
    }

    //O(n)-we need to find the end of the list first
    private void insertDataEnd(T data, Node<T> node) {
        if (node.getNextNode() != null) {
            insertDataEnd(data, node.getNextNode());
        } else {
            Node<T> newNode = new Node<>(data);
            node.setNextNode(newNode);
        }
    }

    @Override
    public void remove(T data) {
        if (this.root == null) return;
        --this.sizeOfList;

        if (this.root.getData().compareTo(data) == 0) {
            this.root = this.root.getNextNode();
        } else {
            remove(data, root, root.getNextNode());
        }
    }

    private void remove(T data2Remove, Node<T> previousNode, Node<T> currentNode) {
        while (currentNode != null) {
            if (currentNode.getData().compareTo(data2Remove) == 0) {
                //found the item to remove
                previousNode.setNextNode(currentNode.getNextNode());
                currentNode = null;
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();


        }
    }


    @Override
    public void traverseList() {
        if (this.root == null) return;
        Node<T> currentNode = this.root;

        while (currentNode != null) {
            System.out.print(currentNode + " ");
            currentNode = currentNode.getNextNode();
        }

    }

    @Override
    public int size() {
        return this.sizeOfList;
    }
}
