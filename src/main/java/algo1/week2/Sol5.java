package algo1.week2;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Sol5 {

    public static BufferedWriter writer;

    public static String out = "output.txt";
    public static String in = "input.txt";
    static boolean r = true;

    public static void main(final String[] args) throws Exception {

        final String path = "txt/w2/sol5/";

        if (Files.exists(Paths.get(path))) {
            out = path + out;
            in = path + in;
        }

        writer = Files.newBufferedWriter(Paths.get(out));
        final List<String> stream = Files.readAllLines(Paths.get(in));
        final int[] ar0 = Arrays.stream(stream.get(0).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        final int k = ar0[1];
        final int[] ar = Arrays.stream(stream.get(1).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
//        quicksortBestK(ar, 0, ar.length - 1, k);
        r = booble(ar, k);
        writer.write(r ? "YES\n" : "NO\n");

        if (Files.exists(Paths.get(path))) {
            for (final int a : ar) {
                writer.write(String.valueOf(a));
                writer.append(" ");
            }
        }


        writer.close();


    }


    public static int[] quicksortBestK(final int[] numbers, final int left, final int right, final int k) {
        int i = left, j = right;
        // Get the pivot element from the middle of the list
        final int pivot = numbers[(right + left) / 2];
        //         final int pivot = numbers[new Random().nextInt(right - left)]; // TODO doesnt work

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
                if (j - i == k) {
                    exchangeK(numbers, i, j, k);
                    i++;
                    j--;
                } else {
                    j--;
                    if (j > i && j - i <= k) {
                        r = verifySorted(numbers, i, j);
                        return numbers;
                    }
                    if (j - i < 2) {
                        return numbers;

                    }
                }
            }
        }
        // Recursion
        if (left < j && (j - left) >= k)
            quicksortBestK(numbers, left, j, k);
        if (i < right && (right - j) >= k)
            quicksortBestK(numbers, i, right, k);

        return numbers;
    }

    static boolean verifySorted(final int[] numbers, final int i, final int j) {

        int tmp = numbers[i];
        for (int x = i; x <= j; x++) {
            if (tmp > numbers[x]) return false;
            tmp = numbers[x];
        }
        return true;
    }

    static boolean booble(final int[] numbers, final int k) {

        for (int i = 0; i < numbers.length - 1; i++) {
            boolean rep = false;
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    if (j + k < numbers.length) {
                        if (rep) return false;
                        exchangeStatic(numbers, j, j + k);
                        rep = true;
                        j--;
                    } else return false;
                } else rep = false;
            }
        }

        return true;
    }

    static int findNextSmall(final int[] numbers, final int jIndex) {
        for (int x = jIndex; x < numbers.length; x++) {
            if (numbers[x] < numbers[jIndex]) return jIndex;
        }
        return -1;
    }

    private static int[] exchangeStatic(final int[] numbers, final int i, final int j) {
        final int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;

        return numbers;
    }

    private static int[] exchangeK(final int[] numbers, final int i, final int j, final int k) {
        if (j - i == k) {
            final int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }


        return numbers;
    }

//    public class Tools {

}



