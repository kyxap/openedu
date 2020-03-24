package algo1.week4;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Stack;

public class Sol3 {

    public static BufferedWriter writer;

    public static String out = "output.txt";
    public static String in = "input.txt";

    /**
     * Скобочная последовательность
     */
    public static void main(final String[] args) throws Exception {

        final String path = "txt/w4/sol3/";

        if (Files.exists(Paths.get(path))) {
            out = path + out;
            in = path + in;
        }

        writer = Files.newBufferedWriter(Paths.get(out));
        final List<String> stream = Files.readAllLines(Paths.get(in));
        final int size = Integer.parseInt(stream.get(0));


        for (int i = 1; i <= size; i++) {
            final String cmd = stream.get(i);
            writer.write(verify(cmd) ? "YES" : "NO");
            writer.newLine();

        }

        writer.close();
    }


    static boolean verify(final String str) {
        final Stack<String> stack = new Stack<>();

        final String[] ar = str.split("");

        if (ar.length == 0) return true;

        for (final String s : ar) {
            if (s.equals(")") || s.equals("]")) {
                if (stack.empty()) return false;
                final String lastOpen = stack.pop();
                if (s.equals(")")) {
                    if (!lastOpen.equals("(")) return false;
                } else if (s.equals("]")) {
                    if (!lastOpen.equals("[")) return false;
                }
            } else {
                stack.push(s);
            }
        }

        return stack.isEmpty();

    }


}



