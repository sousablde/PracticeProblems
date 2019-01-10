/*
The problem is that we want to reverse a T[] array in O(N)
linear time complexity and we want the algorithm to be in-place as well

we have the following array

| 0| 1| 2| 3| 4| 5| 6|
|22|15| 1| 7|20|35|55|
 ^                  ^
 |                  |
 startIndex         endIndex
we will have 2 pointers, one for the first element of the array and one for the last element of the array

To reverse in place we can swap the first and the last element,
after that increment the first element by one and decrement the last element by one and then swap again
and so on
when start index and end index are the same we should terminate the algorithm
 */
public class Main {

    public static void main(String[] args) {
        int[] intArray = {-22, -15, 1, 7, 20, 35, 55};
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }
        System.out.println();
        reverseArray(intArray);
        System.out.println("After reversal");

        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }

    }


    //this is O(n)+ in-place so no need for extra memory
    public static int[] reverseArray(int[] intArray) {
        //first I will declare the pointer to the first and last item
        int startIndex = 0;
        int endIndex = intArray.length - 1;

        while (endIndex > startIndex) {
            swap(intArray, startIndex, endIndex);

            //after the swap increase the starting index by one and decrement the end index by one
            startIndex++;
            endIndex--;
        }

        return intArray;
    }

    //helper function to swap elements
    private static void swap(int[] intArray, int start, int end) {
        int temp = intArray[start];
        intArray[start] = intArray[end];
        intArray[end] = temp;
    }

}
