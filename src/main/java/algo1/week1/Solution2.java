package algo1.week1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author rkukharuk
 */

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("output.txt"));
        Stream<String> stream = Files.lines(Paths.get("input.txt"));
        stream.forEach(s -> {
            final String[] ar = s.split(" ");
            BigInteger bi = new BigInteger(ar[1]);
            bi = bi.multiply(bi);
            bi = bi.add(new BigInteger(ar[0]));


            try {
                writer.write(bi.toString());
                writer.newLine();
            } catch (IOException e) {
                System.out.println("OOOPS");
            }
        });

        writer.close();


    }
}
