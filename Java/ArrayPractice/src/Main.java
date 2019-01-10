import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /*****************************
         * testing if 2 words are anagrams
         ****************************/
        char[] s1 = {'r', 'e', 's', 't', 'f', 'u', 'l'};
        char[] s2 = {'f', 'l', 'u', 's', 't', 'e', 'r'};
        char[] s3 = {'t', 'e', 's', 't'};

        Anagram anagram = new Anagram();

        System.out.println("Testing s1 and s2 " + anagram.solve(s1, s2));
        System.out.println("Testing s1 and s3 " + anagram.solve(s1, s3));
        /*****************************
         * output:
         * Testing s1 and s2 true
         * Testing s1 and s3 false
         ****************************/

        /*****************************
         * Find duplicates in array
         ****************************/
        int[] arr = {2, 3, 1, 2, 4, 3};

        FindDuplicates findDuplicates = new FindDuplicates();
        findDuplicates.dupeFinder(arr);

        /*****************************
         * output:
         * 2 it is repeated
         * 3 it is repeated
         ****************************/

        /*****************************
         * Reservoir Sampling
         * **************************/
        int[] arr2 = new int[40];
        System.out.println("Randomly generated array: ");
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = (int) (Math.random() * 100);
            System.out.print(arr2[i] + " ");
        }

        int k = 5;
        ReservoirSampling reservoirSampling = new ReservoirSampling(new Random());
        reservoirSampling.sample(arr2, k);

        /*****************************
         * output:
         * Randomly generated array:
         * 21 83 95 9 80 80 46 75 57 34 12 99 10 59 48 35 80 7 84 57 79 75 65 77 55 88 18 17 69 30 29 60 49 57 52 78 5 49 38 30
         * 21 88 49 30 49
         ****************************/
    }

}
