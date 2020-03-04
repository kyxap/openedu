package algo1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Solution4Sportland {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("output.txt"));
        List<String> stream = Files.readAllLines(Paths.get("input.txt"));

        for (int streamIndex = 0; streamIndex < stream.size(); streamIndex =+2) {
            int size = Integer.parseInt(stream.get(streamIndex));
            double[] ar = Arrays.stream(stream.get(streamIndex + 1).split(" "))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            int[] indexes = new int[size];
            for (int i = 0; i < size; i++) {
                indexes[i] = i + 1;
            }

            for (int j = 1; j < size; j++) {
                int i = j - 1;

                while (i >= 0 && ar[i] > ar[i + 1]) {
                    double tmp = ar[i];
                    ar[i] = ar[i + 1];
                    ar[i + 1] = tmp;

                    int tmp2 = indexes[i];
                    indexes[i] = indexes[i + 1];
                    indexes[i + 1] = tmp2;

                    i--;
                }

            }


            writer.write(String.valueOf(indexes[0]));
            writer.append(" ");
            writer.write(String.valueOf(indexes[size/2]));
            writer.append(" ");
            writer.write(String.valueOf(indexes[size-1]));
            writer.append(" ");
        }

        writer.close();
    }
}
