import java.util.Random;

/*
Our task is to design an algorithm thats capable of selecting k items from an array!
The problem is that the n size of the array is unknown (or infinitely large)!

Reservoir sampling algorithms randomly choose a sample of k items from a list S with n items
n is either a very large or an unknown number

choosing a random sample is quite easy if you know the size of the array
just use:
new Random().nextInt(int bound)
and this returns a uniformly distributed integer between 0 and bound

not knowing the bound requires the reservoir sampling

1-create a distinct array of size k

2-iterate from k+1 to n: for loop
        for i=k+1 to n
3-with probability k/i (i is the index of the next item in the for loop)
we keep the new item so selecting a random bucket in the array to replace with ~ probability 1-k/i
we ignore the new item (the i item)
which means all the items form the original S list will be considered
i will be replaced with a random value from the reservoir array
 */
public class ReservoirSampling {

    private Random random;

    public ReservoirSampling(Random random) {
        this.random = random;
    }

    //O(n) get k items at random from an array
    public void sample(int[] arr2, int k) {

        //create a new array for k items
        int[] reservoir = new int[k];

        //copy the first k items from the original array to the new array
        for (int i = 0; i < reservoir.length; i++) {
            reservoir[i] = arr2[i];
        }

        //the items from the original array are k+1 (k items copied)
        //the ith item is chosen to be included in the reservoir with the probability k/i
        for (int i = k + 1; i < arr2.length; i++) {
            int j = random.nextInt(i) + 1;

            if (j < k) {
                reservoir[j] = arr2[i];
            }
        }
        System.out.println();
        //show the k random items
        for (int i = 0; i < reservoir.length; i++) {
            System.out.print(reservoir[i] + " ");
        }
    }
}
