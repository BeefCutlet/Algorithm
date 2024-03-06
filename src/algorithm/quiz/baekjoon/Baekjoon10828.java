package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 사용 알고리즘 : 구현, 자료구조, 스택
 */
public class Baekjoon10828 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            String command = reader.readLine();
            if (command.startsWith("push")) {
                String[] commands = command.split(" ");
                stack.push(Integer.parseInt(commands[1]));
            } else if (command.equals("pop")) {
                if (!stack.isEmpty()) {
                    System.out.println(stack.pop());
                } else {
                    System.out.println(-1);
                }
            } else if (command.equals("size")) {
                System.out.println(stack.size());
            } else if (command.equals("empty")) {
                if (!stack.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(1);
                }
            } else if (command.equals("top")) {
                if (!stack.isEmpty()) {
                    System.out.println(stack.peek());
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}