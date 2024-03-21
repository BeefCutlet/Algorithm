package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 사용 알고리즘 : 다이나믹 프로그래밍
 * D[i] = D[i - 1] + 1 =>
 */
public class Baekjoon1463 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        int[] memory = new int[N + 1];
        memory[1] = 0;

        for (int i = 2; i <= N; i++) {
            memory[i] = memory[i - 1] + 1;
            if (i % 2 == 0) {
                memory[i] = Math.min(memory[i], memory[i / 2] + 1);
            }
            if (i % 3 == 0) {
                memory[i] = Math.min(memory[i], memory[i / 3] + 1);
            }
        }
        System.out.println(memory[N]);
    }
}