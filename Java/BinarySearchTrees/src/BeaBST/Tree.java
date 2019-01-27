package BeaBST;

public interface Tree<T extends Comparable<T>> {
    void traversal();

    void insert(T data);

    void delete(T data);

    T getMaxV();

    T getMinV();

    Node<T> getRoot();
}
