package LinkedList;

//defining the operations we want for the linked list
public interface ListInterface<T extends Comparable<T>> {
    void insert(T data);

    void remove(T data);

    void traverseList();

    int size();

    //finding the middle node of a list
    Node<T> getMidNode();

}
