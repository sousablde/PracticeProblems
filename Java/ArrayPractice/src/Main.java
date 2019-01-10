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

    }

}
