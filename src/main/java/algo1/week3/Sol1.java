package algo1.week3;

import java.io.BufferedWriter;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Sol1 {

    public static BufferedWriter writer;

    public static String out = "output.txt";
    public static String in = "input.txt";
    static boolean r = true;

    /**
     * Сортировка целых чисел
     * 24tests passed
     */
    public static void main(final String[] args) throws Exception {

        final String path = "txt/w3/sol1/";

        if (Files.exists(Paths.get(path))) {
            out = path + out;
            in = path + in;
        }

        writer = Files.newBufferedWriter(Paths.get(out));
        final List<String> stream = Files.readAllLines(Paths.get(in));
        final int[] ar0 = Arrays.stream(stream.get(1).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        final int[] ar1 = Arrays.stream(stream.get(2).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        final PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < ar0.length; i++) {
            for (int j = 0; j < ar1.length; j++) {
                pq.add(ar0[i] * ar1[j]);
            }
        }

//        final StringBuffer sb = new StringBuffer();

        BigInteger sum = new BigInteger(String.valueOf(0));
        int count = 1;
        while (!pq.isEmpty()) {
            final int a = pq.poll();
//            sb.append(a).append(" ");
            if (count == 1) {
                sum = sum.add(BigInteger.valueOf(a));
            }

            count++;
            if (count == 11) {
                count = 1;
            }
        }

        writer.write(String.valueOf(sum));

        writer.close();


    }


}



