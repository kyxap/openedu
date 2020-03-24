package algo1.week4;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Stack;

public class Sol1 {

    public static BufferedWriter writer;

    public static String out = "output.txt";
    public static String in = "input.txt";
    /**
     * Стек
     */
    public static void main(final String[] args) throws Exception {

        final String path = "txt/w4/sol1/";

        if (Files.exists(Paths.get(path))) {
            out = path + out;
            in = path + in;
        }

        writer = Files.newBufferedWriter(Paths.get(out));
        final List<String> stream = Files.readAllLines(Paths.get(in));
        final int size = Integer.parseInt(stream.get(0));

        final Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= size; i++) {
            final String cmd = stream.get(i);
            if (cmd.charAt(0) == '+') {
                stack.push(Integer.valueOf(cmd.split(" ")[1]));
            } else { // supposed to be -
                writer.write(String.valueOf(stack.pop()));
                writer.newLine();
            }

        }



        writer.close();


    }
}



