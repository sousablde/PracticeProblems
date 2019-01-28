import BeaBST.BST;
import BeaBST.BSTfromObject;
import BeaBST.Tree;

/*
sorted arrays                                            linked list

inserting is slow because                                inserting is fast O(1)
we need to rearrange O(N)

searching is fast withe binary search o(logN)            searching is sequential O(N)

removing an item is slow  O(N)                           removing is fast because of the references O(1)

BST are going to make all these operations logN making it more predictable and fast
nodes hold the data
the connection between the nodes are the edges
all the other nodes are accessed through the root node

base height of a tree is 2^h-1

minimum tree height is h = log n

if a tree is unbalanced the h = log n relation is no more valid and the operations running time
is no longer logarithmic

balanced tree: same number of left and right subtrees

BSTs are data structures

to delete from BSTS logN
we can either mark the node to remove but not actually remove it

1)leaf: just remove/set to null: find the item plus removal is logN
2)single child: set parents pointer to point to grandchild instead of child
3)two children/root: find largest or smallest item of left or right subtree (predecessor or successor)
so look for predecessor that is case one or 2 and swap them
swapping with successor we just set root node to point to the successor child node
 */
public class Main {

    public static void main(String[] args) {
        Tree<Integer> bst = new BST<>();
        bst.insert(10);
        bst.insert(-1);
        bst.insert(2);
        bst.insert(20);
        bst.insert(0);
        bst.insert(18);

        System.out.println(bst.getMaxV());

        bst.traversal();

        System.out.println("******************************");
        System.out.println("Custom objects in a tree");
        Tree<BSTfromObject> bstfromObjectBST = new BST<>();

        bstfromObjectBST.insert(new BSTfromObject("Bea", 35));
        bstfromObjectBST.insert(new BSTfromObject("Slava", 31));
        bstfromObjectBST.insert(new BSTfromObject("Barb", 32));

        bstfromObjectBST.traversal();

        System.out.println(bstfromObjectBST.getAgesSum());
    }
}
