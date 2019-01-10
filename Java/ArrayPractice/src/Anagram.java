import java.util.Arrays;

/*
Construct an algorithm to check whether two words (or phrases) are anagrams or not!

"An anagram is a word or phrase formed by rearranging the letters of a different word or phrase
 typically using all the original letters exactly once"
example: restful - fluster
 */

public class Anagram {
    public boolean solve(char[] s1, char[] s2) {
        if (s1.length != s2.length) return false;

        //bottleneck O(nlogn)
        //by sorting the arrays of characters we can compare the given letters one by one
        Arrays.sort(s1);
        Arrays.sort(s2);


        //running time O(n)
        //at this point we are ready to compare the characters one by one
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }
        return true;
    }
}
