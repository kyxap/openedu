package algo1.week1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Solution5SecretSwap {
    public static void main(String[] args) throws Exception {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("output.txt"));
        List<String> stream = Files.readAllLines(Paths.get("input.txt"));

        for (int streamIndex = 0; streamIndex < stream.size(); streamIndex = +2) {
            int size = Integer.parseInt(stream.get(streamIndex));
            int[] ar = Arrays.stream(stream.get(streamIndex + 1).split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            //TODO 28 passed issue in alhoryth infisency
            for (int j = 1; j < size; j++) {
                int i = j - 1;

                while (i >= 0 && ar[i] > ar[i + 1]) {
                    int tmp = ar[i];
                    writer.write(String.format("Swap elements at indices %d and %d.\n", i + 1, i + 2));
                    ar[i] = ar[i + 1];
                    ar[i + 1] = tmp;

                    i--;
                }
            }

            // print int to file from array
            writer.write("No more swaps needed.\n");
            for (int a : ar) {
                writer.write(String.valueOf(a));
                writer.append(" ");
            }
        }

        writer.close();
    }

    static int binarySearch(int[] ar, int high, int val) throws Exception {
        int low = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (ar[mid] < val) {
                if (mid + 1 < ar.length - 1 && ar[mid + 1] > val) {
                    return mid + 1;
                }
                low = mid + 1;
            } else if (ar[mid] > val) {
                if (mid == 0) {
                    return mid;
                } else if (mid - 1 >= 0 && ar[mid - 1] < val) {
                    return mid - 1;
                }
                high = mid - 1;
            }
        }
        throw new Exception("UNABLE TO FIND");
    }

}
