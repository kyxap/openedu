package algo1.week2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Sol2 {

    private static BufferedWriter writer;
    static BigInteger inv = BigInteger.valueOf(0);

    /**
     * Число инверсий
     */
    public static void main(final String[] args) throws Exception {

        writer = Files.newBufferedWriter(Paths.get("output.txt"));
        final List<String> stream = Files.readAllLines(Paths.get("input.txt"));

        for (int streamIndex = 0; streamIndex < stream.size(); streamIndex = +2) {
            final int[] ar = Arrays.stream(stream.get(streamIndex + 1).split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();


            mergeSort(ar, 0);

            writer.write(inv + "\n");


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
                    inv = inv.add(BigInteger.valueOf(l.length - (li + 1) + 1)) ;
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
