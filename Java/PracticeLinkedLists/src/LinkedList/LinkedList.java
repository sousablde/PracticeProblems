package LinkedList;

public class LinkedList<T extends Comparable<T>> implements ListInterface<T> {

    private Node<T> root;
    private int sizeOfList;

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
            System.out.println(currentNode + " ");
            currentNode = currentNode.getNextNode();
        }

    }

    @Override
    public int size() {
        return this.sizeOfList;
    }
}
