package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 사용 알고리즘 : 구현, 자료구조, 덱
 */
public class Baekjoon10866 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String command = reader.readLine();
            String[] commands = command.split(" ");
            switch (commands[0]) {
                case "push_front":
                    queue.offerFirst(Integer.parseInt(commands[1]));
                    break;
                case "push_back":
                    queue.offerLast(Integer.parseInt(commands[1]));
                    break;
                case "pop_front":
                    if (!queue.isEmpty()) {
                        System.out.println(queue.pollFirst());
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case "pop_back":
                    if (!queue.isEmpty()) {
                        System.out.println(queue.pollLast());
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    if (!queue.isEmpty()) {
                        System.out.println(0);
                    } else {
                        System.out.println(1);
                    }
                    break;
                case "front":
                    if (!queue.isEmpty()) {
                        System.out.println(queue.peekFirst());
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case "back":
                    if (!queue.isEmpty()) {
                        System.out.println(queue.peekLast());
                    } else {
                        System.out.println(-1);
                    }
            }
        }
    }
}