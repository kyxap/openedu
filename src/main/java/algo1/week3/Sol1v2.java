package algo1.week3;

import java.io.BufferedWriter;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Sol1v2 {

    public static BufferedWriter writer;

    public static String out = "output.txt";
    public static String in = "input.txt";
    static boolean r = true;

    /**
     * Сортировка целых чисел
     * didn't test it against website bc run of the time
     */
    public static void main(final String[] args) throws Exception {

        final String path = "txt/w3/sol1/";

        if (Files.exists(Paths.get(path))) {
            out = path + out;
            in = path + in;
        }

        writer = Files.newBufferedWriter(Paths.get(out));
        final List<String> stream = Files.readAllLines(Paths.get(in));
        final int[] ar0 = Arrays.stream(stream.get(1).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        final int[] ar1 = Arrays.stream(stream.get(2).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int index = 0;
        final int[]  pq = new int[ar0.length * ar1.length];

        for (int i = 0; i < ar0.length; i++) {
            for (int j = 0; j < ar1.length; j++) {
                pq[index] = ar0[i] * ar1[j];
                index++;
            }
        }

        //sort
        quicksort(pq, 0, pq.length - 1);

        BigInteger sum = new BigInteger(String.valueOf(0));
        int count = 1;
        for (final int a : pq) {
            if (count == 1) {
                sum = sum.add(BigInteger.valueOf(a));
            }

            count++;
            if (count == 11) {
                count = 1;
            }
        }

        writer.write(String.valueOf(sum));

        writer.close();


    }

    public static int[] quicksort(final int[] numbers, final int left, final int right) {
        int i = left, j = right;
        // Get the pivot element from the middle of the list
        final int pivot = numbers[(right + left) / 2];
//                 final int pivot = numbers[new Random().nextInt(right - left)]; // TODO doesnt work

        // Divide into two lists
        while (i < j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(numbers, i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (left < j)
            quicksort(numbers, left, j);
        if (i < right)
            quicksort(numbers, i, right);

        return numbers;
    }

    private static int[] exchange(final int[] numbers, final int i, final int j) {
        final int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;

        return numbers;
    }


}



