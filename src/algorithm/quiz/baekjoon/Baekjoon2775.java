package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 사용 알고리즘 : 수학, 구현, 다이나믹 프로그래밍
 * 각 층의 각 호의 거주자 수 = 이전 층 같은 호의 거주자 수 + 같은 층 이전 호의 거주자 수
 */
public class Baekjoon2775 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());
        int[][] apart = new int[15][15];
        for (int i = 1; i <= 14; i++) {
            apart[0][i] = i;
            apart[i][1] = 1;
        }
        for (int i = 1; i <= 14; i++) {
            for (int j = 2; j <= 14; j++) {
                apart[i][j] = apart[i - 1][j] + apart[i][j - 1];
            }
        }

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(reader.readLine());
            int n = Integer.parseInt(reader.readLine());

            System.out.println(apart[k][n]);
        }
    }
}