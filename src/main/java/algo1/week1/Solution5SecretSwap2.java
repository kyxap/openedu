package algo1.week1;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Solution5SecretSwap2 {
    public static void main(String[] args) throws Exception {

        BufferedWriter writer = Files.newBufferedWriter(Paths.get("output.txt"));
        List<String> stream = Files.readAllLines(Paths.get("input.txt"));

        for (int streamIndex = 0; streamIndex < stream.size(); streamIndex = +2) {
            int size = Integer.parseInt(stream.get(streamIndex));
            int[] ar = Arrays.stream(stream.get(streamIndex + 1).split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            //TODO 26 test failed
            for (int j = 1; j < size; j++) {
                int i = j - 1;

                while (i < ar.length -1 && ar[i] > ar[i + 1]) {
//                    int tmp = ar[i];
//                    int toMove = ar[i + 1];

                    int newIndex = binarySearch(ar, j, ar[i + 1]);

                    for (int z = i + 1; z-1 >= newIndex; z--) {
                        int t = ar[z-1];
                        ar[z-1] = ar[z];
                        ar[z] = t;

                        if (z != newIndex) writer.write(String.format("Swap elements at indices %d and %d.\n", z , z +1));

                    }

//                    ar[i] = ar[i + 1];
//                    ar[i + 1] = tmp;
//                    j++;
                    i++;
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

    public static int binarySearch(int[] ar, int high, int val) throws Exception {
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
