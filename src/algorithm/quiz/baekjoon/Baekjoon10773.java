package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 사용 알고리즘 : 구현, 자료구조, 스택
 * 스택을 활용하여 0일 때 pop, 0이 아닐 때 push
 */
public class Baekjoon10773 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(reader.readLine());
        Stack<Integer> books = new Stack<>();
        for (int i = 0; i < K; i++) {
            int money = Integer.parseInt(reader.readLine());
            if (money == 0) {
                books.pop();
            } else {
                books.push(money);
            }
        }

        int sum = 0;
        for (int money : books) {
            sum += money;
        }
        System.out.println(sum);
    }
}