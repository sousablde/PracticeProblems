package LinkedList;

//defining the operations we want for the linked list
public interface ListInterface<T> {
    void insert(T data);

    void remove(T data);

    void traverseList();

    int size();
}
