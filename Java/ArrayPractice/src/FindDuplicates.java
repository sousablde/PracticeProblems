/*
the problem is to find duplicates ina  one-directional array in O(n)
-we can use brute force: comparing items one by one O(n^2)
-we can use hashmaps: traverse the array and insert each element in a hastable with the value as a key
when it is not possible to insert an element it means that key already exists it is not in-place requires
more memory
-using absolute values: O(n) and is in-place

consider all the i items of the array arr[]:
        check the sign of arr[abs(arr[i]):
            if it is positive:
                flip the sign arr[abs(arr[i])] = -arr[abs(arr[i])]
            else:
                the given i item is a repetition
example:
| 0| 1| 2| 3| 4| 5| index
| 2| 3| 1| 2| 4| 3| array

the current array has 6 elements and all the values in it are smaller than the array size itself
for example for the first element:
arr[abs(arr[0])] = arr[2] = 1>0 so the sign of arr[2] needs to be flipped to turn negative



 */
public class FindDuplicates {
    public void dupeFinder(int[] arr) {

        //O(n)
        for (int i = 0; i < arr.length; i++) {

            //if value positive turn negative
            if (arr[Math.abs(arr[i])] > 0) {

                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            }
            //if a negative is found it means it was a repetition
            else {
                System.out.println(Math.abs(arr[i]) + " it is repeated ");
            }
        }
    }

}
