package algo1.week4;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Sol4v1 {

    public static BufferedWriter writer;

    public static String out = "output.txt";
    public static String in = "input.txt";

    /**
     * Очередь с минимумом
     *  38 test passed ( doesnt increase speed to much
     */
    public static void main(final String[] args) throws Exception {

        final String path = "txt/w4/sol4/";

        if (Files.exists(Paths.get(path))) {
            out = path + out;
            in = path + in;
        }

        Integer min = null;

        writer = Files.newBufferedWriter(Paths.get(out));
        final List<String> stream = Files.readAllLines(Paths.get(in));
        final int size = Integer.parseInt(stream.get(0));

        final Queue<Integer> queue = new LinkedList<>();
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        final PriorityQueue<Integer> pqNext = new PriorityQueue<>();

        for (int i = 1; i <= size; i++) {
            final String cmd = stream.get(i);
            if (cmd.charAt(0) == '+') {
                final int a = Integer.parseInt(cmd.split(" ")[1]);
                if (min == null) {
                    min = a;
                    pq.offer(a);
                } else {
                    if (a < min) {
                        pq.offer(a);
                        min = a;
                    } else {
                        pqNext.offer(a);
                    }
                }
                queue.offer(a);
//                pq.offer(a);
            } else if (cmd.charAt(0) == '?') {
                Integer rez = pq.peek();
                if (rez == null) rez = pqNext.peek();
                writer.write(String.valueOf(rez));
                writer.newLine();
            } else { // supposed to be -
                final Integer el = queue.poll();
                final boolean rez = pq.remove(el);
                if (!rez) pqNext.remove(el);
            }

        }

        writer.close();
    }


}



