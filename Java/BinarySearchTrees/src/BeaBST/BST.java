package BeaBST;


public class BST<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root;

    /*
    k-th smallest item in a bst
    in-place algorithm to save memory
    if k is smaller than the number of nodes in the left st-k-th smallest will have to be found in the left subtree
    if k is greater than the number of nodes in the left st then we need to check the right st

    for example if we are looking for the 5-th smallest item
                                12
                             /       \
                            4        20
                           /  \
                          1    5
    first we check the left subtree nodes
    there are 3 nodes in the left subtree +1 root node so numOfNodes < k
    we have to check the right subtree but we have to modify the k value
    we reduce the problem to finding k-numOfNOdes(left subtree)
    smallest item in the right subtree
     */
    @Override
    public Node<T> getKSmallest(Node<T> node, int k) {

        //number of nodes in the left subtree
        //+1 because we count the root node of the subtree as well
        int n = treeSize(node.getLeftChild()) + 1;

        //this is when we find the kth smallest item
        if (n == k) {
            return node;
        }

        //if the number of nodes in the left subtree > k-th smallest item
        //it means the k-th smallest item is in the left subtree
        if (n > k) return getKSmallest(node.getLeftChild(), k);

        //if the number of nodes in the left subtree is smaller then the k-th
        //smallest item then we can discard the left subtree and consider the
        //right substree
        //NOW WE ARE NOT LOOKING FOR THE K-TH BUT THE K-Nth SMALLEST ITEM
        if (n < k) return getKSmallest(node.getRightChild(), k - n);

        return null;
    }

    //calculate the size of a subtree with root node 'node'
    //recursive method
    private int treeSize(Node<T> node) {

        //this is the base case
        if (node == null) return 0;

        //recursively sum up the size of the left subtree + size of right subtree
        // size of tree = size left subtree + size of right subtree + 1 (because of the root)
        return (treeSize(node.getLeftChild()) + treeSize(node.getRightChild()) + 1);
    }

    @Override
    public int getAgesSum() {
        return getAges(this.root);
    }


    /*
    we need an algo that returns the sum of all the parameters in the tree
    we need to visit all the nodes in the tree
    we have to do postOrder traversal yo keep the sum of ages at each node
     */
    private int getAges(Node<T> node) {

        System.out.println("considering node " + node);

        //we have to reinitialize the variables (sum is the parent's node value so the sum of the subtrees so far)
        int sum = 0;
        int leftSum = 0;
        int rightSum = 0;

        //null nodes have sum value 0
        if (node == null) {
            return 0;
        }

        //we do a simple post-order traversal because here we have to calculate both left and right value to
        //be able to calculate the parent's value (sum of childrens' ages)
        //check the left subtree recursively
        leftSum = getAges(node.getLeftChild());
        //check the right subtree recursively
        rightSum = getAges(node.getRightChild());

        //update the sum ... given node's value is the own value + left subtree sum + right subtree sum
        System.out.println("Considering node " + node + " total ages so far is " + (((BSTfromObject) node.getData()).getAge() + leftSum + rightSum));
        sum = ((BSTfromObject) node.getData()).getAge() + leftSum + rightSum;

        return sum;
    }

    @Override
    public Node<T> getRoot() {
        return this.root;
    }

    @Override
    public void insert(T data) {
        if (root == null) {
            root = new Node<T>(data);
        } else {
            insertNode(data, root);
        }

    }

    @Override
    public void traversal() {
        if (root != null) inOrder(root);

    }

    private void inOrder(Node<T> node) {
        if (node.getLeftChild() != null) {
            inOrder(node.getLeftChild());
        }
        System.out.print(node + " --> ");
        if (node.getRightChild() != null) {
            inOrder(node.getRightChild());
        }
    }


    private void insertNode(T newData, Node<T> node) {
        if (newData.compareTo(node.getData()) < 0) {//go to the right
            if (node.getLeftChild() != null) {
                insertNode(newData, node.getLeftChild());
            } else {
                Node<T> newNode = new Node<T>(newData);
                node.setLeftChild(newNode);
            }

        } else {
            if (node.getRightChild() != null) {
                insertNode(newData, node.getRightChild());
            } else {
                Node<T> newNode = new Node<T>(newData);
                node.setRightChild(newNode);
            }
        }

    }

    @Override
    public void delete(T data) {
        if (root != null) {
            root = delete(root, data);
        }

    }

    private Node<T> delete(Node<T> node, T data) {


        if (node == null) return node;

        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(delete(node.getLeftChild(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(delete(node.getRightChild(), data));
        } else {

            // we have found the node we want to remove !!!
            if (node.getLeftChild() == null && node.getRightChild() == null) {
                System.out.println("Removing a leaf node...");
                return null;
            }

            if (node.getLeftChild() == null) {
                System.out.println("Removing the right child...");
                Node<T> tempNode = node.getRightChild();
                node = null;
                return tempNode;
            } else if (node.getRightChild() == null) {
                System.out.println("Removing the left child...");
                Node<T> tempNode = node.getLeftChild();
                node = null;
                return tempNode;
            }

            // this is the node with two children case !!!
            System.out.println("Removing item with two children...");
            Node<T> tempNode = getPredecessor(node.getLeftChild());

            node.setData(tempNode.getData());
            node.setLeftChild(delete(node.getLeftChild(), tempNode.getData()));

        }

        return node;
    }

    private Node<T> getPredecessor(Node<T> node) {

        if (node.getRightChild() != null)
            return getPredecessor(node.getRightChild());

        System.out.println("Predecessor is: " + node);
        return node;
    }

    @Override
    public T getMaxV() {
        if (root == null) return null;
        return getMax(root);
    }


    private T getMax(Node<T> node) {
        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        }
        return node.getData();
    }

    @Override
    public T getMinV() {
        if (root == null) return null;
        return getMin(root);
    }


    private T getMin(Node<T> node) {
        if (node.getLeftChild() != null) {
            return getMin(node.getLeftChild());
        }
        return node.getData();

    }
}
