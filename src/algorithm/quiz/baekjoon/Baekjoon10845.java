package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 사용 알고리즘 : 자료구조, 큐
 * Deque 사용
 */
public class Baekjoon10845 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String command = reader.readLine();
            if (command.startsWith("push")) {
                String[] commands = command.split(" ");
                queue.offer(Integer.parseInt(commands[1]));
            } else if (command.equals("pop")) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.poll());
                } else {
                    System.out.println(-1);
                }
            } else if (command.equals("size")) {
                System.out.println(queue.size());
            } else if (command.equals("empty")) {
                if (!queue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(1);
                }
            } else if (command.equals("front")) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.peek());
                } else {
                    System.out.println(-1);
                }
            } else if (command.equals("back")) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.peekLast());
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}