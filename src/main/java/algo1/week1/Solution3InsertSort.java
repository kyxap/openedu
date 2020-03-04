package algo1.week1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Solution3InsertSort {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("output.txt"));
        List<String> stream = Files.readAllLines(Paths.get("input.txt"));

        StringBuilder sb = new StringBuilder();

        for (int streamIndex = 0; streamIndex < stream.size(); streamIndex =+2) {
            int size = Integer.parseInt(stream.get(streamIndex));
            int[] ar = Arrays.stream(stream.get(streamIndex + 1).split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            sb.append(1).append(" ");
            for (int j = 1; j < size; j++) {
                int i = j - 1;

                while (i >= 0 && ar[i] > ar[i + 1]) {
                    int tmp = ar[i];
                    ar[i] = ar[i + 1];
                    ar[i + 1] = tmp;
                    i--;
                }
                sb.append(i+2).append(" ");

            }

//            sb.setLength(sb.length() - 1);

            writer.write(sb.toString());
            writer.newLine();
            for (int a : ar) {
                writer.write(String.valueOf(a));
                writer.append(" ");
            }
        }

        writer.close();

    }
}
