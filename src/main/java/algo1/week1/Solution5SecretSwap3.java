package algo1.week1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Solution5SecretSwap3 {

    private static BufferedWriter writer;

    public static void main(String[] args) throws Exception {

        writer = Files.newBufferedWriter(Paths.get("output.txt"));
        List<String> stream = Files.readAllLines(Paths.get("input.txt"));

        for (int streamIndex = 0; streamIndex < stream.size(); streamIndex = +2) {
            int size = Integer.parseInt(stream.get(streamIndex));
            int[] ar = Arrays.stream(stream.get(streamIndex + 1).split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            ar = quicksort(ar, 0, size - 1);
//            for (int j = 1; j < size; j++) {
//                int i = j - 1;
//
//                while (i < ar.length -1 && ar[i] > ar[i + 1]) {
////                    int tmp = ar[i];
////                    int toMove = ar[i + 1];
//
//                    int newIndex = binarySearch(ar, j, ar[i + 1]);
//
//                    for (int z = i + 1; z-1 >= newIndex; z--) {
//                        int t = ar[z-1];
//                        ar[z-1] = ar[z];
//                        ar[z] = t;
//
//                        if (z != newIndex) writer.write(String.format("Swap elements at indices %d and %d.\n", z , z +1));
//
//                    }
//
////                    ar[i] = ar[i + 1];
////                    ar[i + 1] = tmp;
////                    j++;
//                    i++;
//                }
//            }

            // print int to file from array
            writer.write("No more swaps needed.\n");
            for (int a : ar) {
                writer.write(String.valueOf(a));
                writer.append(" ");
            }
        }

        writer.close();
    }

    private static int[] quicksort(int[] numbers, int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high-low)/2];

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

    private static int[] exchange(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;

        try {
            if (i < j) writer.write(String.format("Swap elements at indices %d and %d.\n", i + 1, j + 1));
        } catch (IOException e) {
//            log.warn("", e);

        }

        return numbers;
    }

    static int binarySearch(int[] ar, int high, int val) throws Exception {
        int low = 0;
        while (low <= high) {
            int mid = (low + high) / 2;

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
