package algo1.week2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Sol1 {

    private static BufferedWriter writer;

    /**
     * Сортировка слиянием
     */
    public static void main(final String[] args) throws Exception {

        writer = Files.newBufferedWriter(Paths.get("output.txt"));
        final List<String> stream = Files.readAllLines(Paths.get("input.txt"));

        for (int streamIndex = 0; streamIndex < stream.size(); streamIndex = +2) {
//            final int size = Integer.parseInt(stream.get(streamIndex));
            int[] ar = Arrays.stream(stream.get(streamIndex + 1).split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            ar = mergeSort(ar, 0);

            // print int to file from array
            for (final int a : ar) {
                writer.write(String.valueOf(a));
                writer.append(" ");
            }
        }

        writer.close();
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

        writer.write((offset + 1) + " " + (offset + n) + " " + rez[0] + " " + rez[rez.length - 1]);
        writer.newLine();

        return rez;

    }

    /**
     * TODO: get rid of 3rd arr
     */
    public static int[] merge(final int[] l, final int[] r) throws IOException {


//        writer.write(ri1 + 1 + " " + (ri2 + 1) + " " + ar[ri1] + " " + ar[ri2 - 1]);
//        writer.newLine();

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
