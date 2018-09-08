public class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addFront(int data) {
        //create new node
        Node newNode = new Node(data);

        //if head
        if (head == null) {
            head = newNode;
            return;
        }
        //set next pointer to current head
        newNode.next = head;

        //set current head to new head
        head = newNode;//element added to front
        //size++;
    }

    public int getFirst() {
        //if head ==null add argument exception
        return head.data;

    }

    public int getLast() {
        if (head == null) {
            throw new IllegalStateException("Empty List");
        }
        Node current = head;
        //2 parts, start at head pf linked list and parse through all elements
        while (current.next != null) {
            current = current.next;//O(n)
        }
        //when at tail
        return current.data;
    }

    public void addBack(int data) {
        Node newNode = new Node(data);
        //if head set and return
        if (head == null) {
            head = newNode;
            return;
        }
        //for a longer lis we start at the head, parse through all elements set current.next to newNode

        //start at head
        Node current = head;

        //walk back node=null
        while (current.next != null) {
            current = current.next;
        }

        //current.next=newNode
        current.next = newNode;
    }

    public int size() {
        //empty linked list
        if (head == null) {
            return 0;
        }
        int count = 1;
        Node current = head;
        while (current.next != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    public void clear() {
        head = null;
    }

    public void deleteValue(int data) {
        //if single element
        if (head == null) {
            return;
        }
        //if at head
        if (head.data == data) {
            head = head.next;
            return;
        }
        //if in the middle
        //walk the list
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                //bypassing the node we want to remove and point to the next next node
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }

    }

    //storing all the elements of the list
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

    }
}
