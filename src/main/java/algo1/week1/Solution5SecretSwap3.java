package algo1.week1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Solution5SecretSwap3 {

    private static BufferedWriter writer;

    public static void main(final String[] args) throws Exception {

        writer = Files.newBufferedWriter(Paths.get("output.txt"));
        final List<String> stream = Files.readAllLines(Paths.get("input.txt"));

        for (int streamIndex = 0; streamIndex < stream.size(); streamIndex = +2) {
            final int size = Integer.parseInt(stream.get(streamIndex));
            int[] ar = Arrays.stream(stream.get(streamIndex + 1).split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            ar = quicksort(ar, 0, size - 1);

            // print int to file from array
            writer.write("No more swaps needed.\n");
            for (final int a : ar) {
                writer.write(String.valueOf(a));
                writer.append(" ");
            }
        }

        writer.close();
    }

    public static int[] quicksort(final int[] numbers, final int low, final int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        final int pivot = numbers[low + (high-low)/2];

        // Divide into two lists
        while (i <= j) {
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
        if (low < j)
            quicksort(numbers, low, j);
        if (i < high)
            quicksort(numbers, i, high);

        return numbers;
    }

    private static int[] exchange(final int[] numbers, final int i, final int j) {
        final int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;

        try {
            if (i < j) writer.write(String.format("Swap elements at indices %d and %d.\n", i + 1, j + 1));
        } catch (final IOException e) {
//            log.warn("", e);

        }

        return numbers;
    }

    static int binarySearch(final int[] ar, int high, final int val) throws Exception {
        int low = 0;
        while (low <= high) {
            final int mid = (low + high) / 2;

            if (ar[mid] < val) {
                if (mid == high) {
                    if (mid + 1 < ar.length - 1) {
                        return mid + 1;
                    } else return mid;
                }
                if (mid + 1 < ar.length - 1 && ar[mid + 1] > val) {
                    return mid + 1;
                }
                low = mid + 1;
            } else if (ar[mid] > val) {
                if (mid == 0) {
                    return mid;
                } else if (ar[mid - 1] < val) {
                    return mid;
                }
                high = mid - 1;
            } else if (ar[mid] == val) {
                return mid;
            }
        }
        throw new Exception("UNABLE TO FIND");
    }

}
