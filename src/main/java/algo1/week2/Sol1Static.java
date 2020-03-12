package algo1.week2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Sol1Static {

    private static BufferedWriter writer;

    /**
     * Сортировка слиянием
     */
    public static void main(final String[] args) throws Exception {

        writer = Files.newBufferedWriter(Paths.get("output.txt"));
        final List<String> stream = Files.readAllLines(Paths.get("input.txt"));

        for (int streamIndex = 0; streamIndex < stream.size(); streamIndex = +2) {
            final int size = Integer.parseInt(stream.get(streamIndex));
            int[] ar = Arrays.stream(stream.get(streamIndex + 1).split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            ar = mergeSort(ar);
            // print int to file from array
            for (final int a : ar) {
                writer.write(String.valueOf(a));
                writer.append(" ");
            }
        }

        writer.close();
    }


    public static int[] mergeSort(final int[] ar) throws IOException {

        final int n = ar.length;
        if (n == 1) return ar;


        final int li1 = 0;
        final int li2 = n / 2;
        final int ri1 = n / 2;
        final int ri2 = n;

        writer.write(li1 + 1 + " " + (li2 + 1) + " " + ar[li1] + " " + ar[li2]);
        writer.newLine();
        writer.write(ri1 + 1 + " " + (ri2) + " " + ar[ri1] + " " + ar[ri2 - 1]);
        writer.newLine();

        final int[] left = Arrays.copyOfRange(ar, li1, li2);
        final int[] right = Arrays.copyOfRange(ar, ri1, ri2);
        mergeSort(left);
        mergeSort(right);
//        writer.write(ri1 + 1 + " " + (ri2 + 1) + " " + ar[ri1] + " " + ar[ri2 - 1]);
//        writer.newLine();


        return merge(left, right);

    }

    public static int[] merge(final int[] l, final int[] r) {
        final int[] rez = new int[l.length + r.length];

        int li = 0;
        int ri = 0;
        for (int i = 0; i < rez.length; i++) {
            if (li < l.length && ri < r.length) {
                if (l[li] < r[ri]) {
                    rez[i] = l[li];
                    li++;
                } else if (l[li] > r[ri]) {
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
