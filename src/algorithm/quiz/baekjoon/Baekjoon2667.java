package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 사용 알고리즘 : 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
 * DFS를 활용하여 탐색
 */
public class Baekjoon2667 {

    private static boolean[][] visited;
    private static int[] x = {0, 1, 0, -1};
    private static int[] y = {1, 0, -1, 0};
    private static int count = 0;
    private static int N;
    private static int[][] apartment;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        List<Integer> result = new ArrayList<>();
        visited = new boolean[N][N];

        apartment = new int[N][N];
        count = 1;
        for (int i = 0; i < N; i++) {
            char[] houses = reader.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                apartment[i][j] = houses[j] - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (apartment[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    result.add(count);
                    count = 1;
                }
            }
        }

        System.out.println(result.size());

        Collections.sort(result);
        for (Integer num : result) {
            System.out.println(num);
        }
    }

    private static void dfs(int a, int b) {
        visited[a][b] = true;

        for (int i = 0; i < 4; i++) {
            int X = a + x[i];
            int Y = b + y[i];
            if (X >= 0 && Y >= 0 && X < N && Y < N && !visited[X][Y] && apartment[X][Y] == 1) {
                count++;
                dfs(X, Y);
            }
        }
    }
}