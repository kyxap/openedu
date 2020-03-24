package algo1.week4;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Sol2 {

    public static BufferedWriter writer;

    public static String out = "output.txt";
    public static String in = "input.txt";
    /**
     * Очередь
     */
    public static void main(final String[] args) throws Exception {

        final String path = "txt/w4/sol2/";

        if (Files.exists(Paths.get(path))) {
            out = path + out;
            in = path + in;
        }

        writer = Files.newBufferedWriter(Paths.get(out));
        final List<String> stream = Files.readAllLines(Paths.get(in));
        final int size = Integer.parseInt(stream.get(0));

        final Queue<Integer> queue = new LinkedList<>();
        final PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= size; i++) {
            final String cmd = stream.get(i);
            if (cmd.charAt(0) == '+') {
                queue.offer(Integer.valueOf(cmd.split(" ")[1]));
            } else { // supposed to be -
                writer.write(String.valueOf(queue.poll()));
                writer.newLine();
            }

        }

        writer.close();
    }


}



