public class ArraysBigO {
    public static void main(String[] args) {
        int[] intArray = new int[7];//array of ints with size 7

        intArray[0] = 20;
        intArray[1] = 35;
        intArray[2] = -15;
        intArray[3] = 7;
        intArray[4] = 1;


        //printing the entire array
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
/*
searching through the array would have a worst case scenario
of the element we are trying to find being in the last position of the array
meaning we would have to loop n times
the number of elements affects the number of steps this particular block of
code-linear time complexity

 */
        int index = -1;
        //printing out a particular element of the array
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == 7) {
                index = i;
                break;
            }
        }

        //printing out the index
        System.out.println("index= " + index);


    }
}
/*
output
20
35
-15
7
1
0
0

 */