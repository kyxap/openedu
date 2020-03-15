package algo1.week2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Sol3 {

    static Deque<Integer> deque = new ArrayDeque<>();
    public static BufferedWriter writer;
    public static BigInteger inv = BigInteger.valueOf(0);
    public static int[] rez = null;

    public static String out = "output.txt";
    public static String in = "input.txt";

    public static void main(final String[] args) throws Exception {

        final String path = "txt/w2/sol3/";

        if (Files.exists(Paths.get(path))) {
            out = path + out;
            in =  path + in;
        }

        writer = Files.newBufferedWriter(Paths.get(out));
        final List<String> stream = Files.readAllLines(Paths.get(in));

        final int n = Integer.parseInt(stream.get(0));
        rez = new int[n];
        final int plus1 = 1;
        for (int i = 0; i < n; i++) {
            rez[i] = i + plus1;
            deque.push(i + plus1);
        }
        aquicksort(rez, 0, rez.length - 1);

        for (final int a : rez) {
            writer.write(String.valueOf(a));
            writer.append(" ");
        }


        writer.close();
    }


    public static int[] aquicksort2(final int[] numbers, final int left, final int right) {
        int i = left, j = right;
        // Get the pivot element from the middle of the list
        final int pivot = numbers[(right + left) / 2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (numbers[j] < pivot) {
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
            aquicksort2(numbers, left, j);
        if (i < right)
            aquicksort2(numbers, i, right);

        return numbers;
    }

    public static int[] aquicksort(final int[] numbers, final int low, final int high) {
        if (high - low == 1) {
            numbers[low] = deque.pollFirst();
            numbers[high] = deque.pollLast();

            return numbers;
        }
        final int pivotIndex = (low + high) / 2;
        numbers[pivotIndex] = deque.pollFirst();

        for (int index = low; index < pivotIndex; index++) {
            if (deque.size() > 1 && index > low) {
                final int tmp = deque.pollFirst();
                numbers[index] = deque.pollFirst();
                deque.push(tmp);

            } else {
                numbers[index] = deque.pollLast();
            }

//            numbers[index] = deque.pollLast();

        }


        if (pivotIndex + 1 < numbers.length)
            aquicksort(numbers, pivotIndex + 1, high);

        return numbers;
    }


    public static int[] quicksort(final int[] numbers, final int left, final int right) {
        int i = left, j = right;
        // Get the pivot element from the middle of the list
        final int pivot = numbers[(right + left) / 2];

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

    public static int[] mergeSort(final int[] ar, final int offset) throws IOException {
        final int n = ar.length;

        if (n == 1) return ar;

        final int mid = n / 2;
        int[] l = Arrays.copyOfRange(ar, 0, mid);
        int[] r = Arrays.copyOfRange(ar, mid, n);
        l = mergeSort(l, offset);
        r = mergeSort(r, offset + mid);

        final int[] rez = merge(l, r);

        return rez;

    }

    /**
     * TODO: get rid of 3rd arr
     */
    public static int[] merge(final int[] l, final int[] r) throws IOException {
        final int[] rez = new int[l.length + r.length];

        int li = 0;
        int ri = 0;
        for (int i = 0; i < rez.length; i++) {
            if (li < l.length && ri < r.length) {
                if (l[li] < r[ri]) {
                    rez[i] = l[li];
                    li++;
                } else if (l[li] > r[ri]) {
                    inv = inv.add(BigInteger.valueOf(l.length - (li + 1) + 1));
                    rez[i] = r[ri];
                    ri++;
                } else {
                    rez[i] = l[li];
                    li++;
                }
            } else {
                if (li < l.length) {
                    rez[i] = l[li];
                    li++;
                } else if (ri < r.length) {
                    rez[i] = r[ri];
                    ri++;
                }
            }
        }
        return rez;
    }
}
