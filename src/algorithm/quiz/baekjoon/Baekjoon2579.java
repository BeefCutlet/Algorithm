package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 사용 알고리즘 : 다이나믹 프로그래밍
 */
public class Baekjoon2579 {

    static Integer[] dp;
    static int[] base;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        dp = new Integer[N + 1];
        base = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            base[i] = Integer.parseInt(reader.readLine());
        }
        dp[0] = base[0];
        dp[1] = base[1];

        if (N >= 2) {
            dp[2] = base[1] + base[2];
        }

        System.out.println(find(N));
    }

    static int find(int index) {
        if (dp[index] == null) {
            dp[index] = Math.max(find(index - 2), find(index - 3) + base[index - 1]) + base[index];
        }
        return dp[index];
    }
}