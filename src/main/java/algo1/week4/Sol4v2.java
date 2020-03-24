package algo1.week4;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Sol4v2 {

    public static BufferedWriter writer;

    public static String out = "output.txt";
    public static String in = "input.txt";

    /**
     * Очередь с минимумом
     * 6 tests passed only
     */
    public static void main(final String[] args) throws Exception {

        final String path = "txt/w4/sol4/";

        if (Files.exists(Paths.get(path))) {
            out = path + out;
            in = path + in;
        }

        writer = Files.newBufferedWriter(Paths.get(out));
        final List<String> stream = Files.readAllLines(Paths.get(in));
        final int size = Integer.parseInt(stream.get(0));

        final Queue<Integer> queue = new LinkedList<>();
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        final Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= size; i++) {
            final String cmd = stream.get(i);
            if (cmd.charAt(0) == '+') {
                final int a = Integer.parseInt(cmd.split(" ")[1]);
                queue.offer(a);
                pq.offer(a);
            } else if (cmd.charAt(0) == '?') {
                if (map.get(pq.peek()) != null) {
                    final int count = map.get(pq.peek());
                    map.remove(pq.peek());
                    for (int x = 0; x < count; x++) {
                        pq.poll();
                    }
                }
                writer.write(String.valueOf(pq.peek()));
                writer.newLine();
            } else { // supposed to be -
                final int el = queue.poll();
                map.put(el, map.getOrDefault(el, 0) + 1);
//                pq.remove(el);
            }

        }

        writer.close();
    }


}



