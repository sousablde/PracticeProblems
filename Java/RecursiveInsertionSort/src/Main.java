/*
we traverse the sorted partition from right to left and compare the elements in the unsorted partition
to the ones in the sorted partition, we try to find values that are less than or equal to what we are
trying to insert
it is an in-place algorithm and it is a stable algorithm
 */

public class Main {

    public static void main(String[] args) {

        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        recInsertionSort(intArray, intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }

    }

    public static void recInsertionSort(int[] input, int numItems) {
        if (numItems < 2) {//base case is when we reach just one item
            return;
        }
        recInsertionSort(input, numItems - 1);

        int newElement = input[numItems - 1];

        int i;

        //looking for the insertion position,if we haven't hit the front of the array (meaning the element we
        //are trying to insert is the smallest
            /*
            to walk through what is happening: when we want to insert -15 (assuming first iteration is done and 20 and
            35 are in the sorted partition) -15 has an i=2 in the unsorted partition, we check if i>0 (true), i-1
            corresponds to 35 in the sorted partition and this is greater than -15,  so we will assign 35 to i=2
            in the sorted partition, do it again for 20 and assign i=1 to 20, since we drop out fo the loop
             here (is i>0? (false) putting -15 in the i=0 position through the newElement
             */
        for (i = numItems - 1; i > 0 && input[i - 1] > newElement; i--) {
            input[i] = input[i - 1];
        }

        input[i] = newElement;

        System.out.println("State of array at numItems = " + numItems);
        for (i = 0; i < input.length; i++) {
            System.out.print(input[i]);
            System.out.print(", ");
        }
        System.out.println();
        System.out.println("____________________________");
    }

}
/*
"C:\Program Files\Java\jdk1.8.0_102\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2018.1.5\lib\idea_rt.jar=63769:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2018.1.5\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_102\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_102\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_102\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_102\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_102\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_102\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_102\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_102\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_102\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_102\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_102\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_102\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_102\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_102\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_102\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_102\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_102\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_102\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_102\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_102\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_102\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_102\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_102\jre\lib\rt.jar;C:\Users\sousa\Desktop\github\PracticeProblems\Java\RecursiveInsertionSort\out\production\RecursiveInsertionSort" Main
State of array at numItems = 2
20, 35, -15, 7, 55, 1, -22,
____________________________
State of array at numItems = 3
-15, 20, 35, 7, 55, 1, -22,
____________________________
State of array at numItems = 4
-15, 7, 20, 35, 55, 1, -22,
____________________________
State of array at numItems = 5
-15, 7, 20, 35, 55, 1, -22,
____________________________
State of array at numItems = 6
-15, 1, 7, 20, 35, 55, -22,
____________________________
State of array at numItems = 7
-22, -15, 1, 7, 20, 35, 55,
____________________________
-22
-15
1
7
20
35
55

Process finished with exit code 0
 */
