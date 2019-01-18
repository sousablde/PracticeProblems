/*
Linked lists are composed of nodes and references that point to a subsequent node
The tail of a list points to null


A single node contains data (it can be an int, a double or an object itself)
Contains a reference pointing to the next node in the linked list

They require a Node class, a node class has the data we want to store plus the reference to the next node in the
sequence

LL do not allow random access
most operations require sequential scanning of most of the list elements

they are dynamic data structures
they can allocate memory at run-time
but
use more memory for the pointers
hard to navigate backwards in singly linked lists

 */
package LinkedList;
public class Main {

    public static void main(String[] args) {
        ListInterface<Integer> list = new LinkedList<Integer>();

        list.insert(10);
        list.insert(11);
        list.insert(12);
        list.insert(13);
        list.insert(14);
        list.insert(15);
        list.insert(16);
        list.insert(17);
        list.insert(18);
        list.insert(19);
        list.insert(20);

        System.out.println("Traversing initial list of integers: ");
        list.traverseList();
        System.out.println();
        System.out.println("****************************************");

        System.out.println("Traversing list of integers post removal of 12: ");
        list.remove(12);
        list.traverseList();
        System.out.println();
        System.out.println("****************************************");

        list.insert(12);
        System.out.println("Traversing list of integers post insertion of 12: ");
        list.traverseList();
        System.out.println();
        System.out.println("****************************************");

        ListInterface<Pet> list2 = new LinkedList<Pet>();
        list2.insert(new Pet(2, "Mocha"));
        list2.insert(new Pet(3, "Sirius"));
        list2.insert(new Pet(1, "Nix"));
        list2.insert(new Pet(5, "Minsk"));
        list2.insert(new Pet(2, "DeeDee"));


        list2.traverseList();
        System.out.println();
        System.out.println("****************************************");
        System.out.println("Trying to find the middle node (case one is 10 to 20): " + list.getMidNode());
        System.out.println("****************************************");
        System.out.println("Trying to find the middle node (case two are pets): " + list2.getMidNode());

    }
}
