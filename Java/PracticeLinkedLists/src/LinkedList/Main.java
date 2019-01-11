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

        list.traverseList();

        list.remove(12);
        list.traverseList();

        ListInterface<Pet> list2 = new LinkedList<Pet>();
        list2.insert(new Pet(2, "Mocha"));
        list2.insert(new Pet(3, "Sirius"));
        list2.insert(new Pet(1, "Nix"));
        list2.insert(new Pet(5, "Minsk"));
        list2.insert(new Pet(2, "DeeDee"));

        list2.traverseList();






    }
}
