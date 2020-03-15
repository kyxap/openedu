package week2;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author rkukharuk
 */

public class QuickSort {
    @Test
    public void test1() {
        final int[] ar = new int[] {1, 44, 3 , 33, 2, 0 , -1};

//        assertArrayEquals(ar, );
        final int[] ar2 = quicksortBest(ar, 0, ar.length -1);
        assertNotNull(ar2);
    }


    public int[] quicksortBest(final int[] numbers, final int left, final int right) {
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
            quicksortBest(numbers, left, j);
        if (i < right)
            quicksortBest(numbers, i, right);

        return numbers;
    }


    private int[] exchange(final int[] numbers, final int i, final int j) {
        final int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;

        return numbers;
    }
}
