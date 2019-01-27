import BeaBST.Node;

/*
2 trees can have the same values but different topology
we have to do an inorder traversal to figure out the similarity of the 2 trees

 */
public class Compare2Trees<T extends Comparable<T>> {
    public boolean compare2Trees(Node<T> node1, Node<T> node2) {
        //checking a base case in which it might be a leaf, so ==
        if (node1 == null || node2 == null) return node1 == node2;

        //if the values within the nodes are not the same we return false (trees are not the same)
        //so basically if node1 and node2 are not the same then the trees are not equal
        if (node1.getData().compareTo(node2.getData()) != 0) return false;

        //the left subtree and the right subtree values must match as well
        return compare2Trees(node1.getLeftChild(), node2.getLeftChild()) && compare2Trees(node1.getRightChild(), node2.getRightChild());

    }
}
