package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : 그래프 이론, 그래프 탐색, 깊이 우선 탐색(사용), 넓이 우선 탐색
 */
public class Baekjoon1012 {

    static int N, M, K;
    static int count;
    static boolean[][] isChecked;
    static int[][] cabbage;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) {
            count = 0;
            StringTokenizer st = new StringTokenizer(reader.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            cabbage = new int[M][N];
            isChecked = new boolean[M][N];

            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(reader.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cabbage[x][y] = 1;
            }

            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (cabbage[x][y] == 1 && !isChecked[x][y]) {
                        dfs(x, y);
                        count++;
                    }
                }
            }

            writer.write(count + "\n");
            writer.flush();
        }

        reader.close();
        writer.close();
    }

    static void dfs(int x, int y) {
        isChecked[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
                if (!isChecked[cx][cy] && cabbage[cx][cy] == 1) {
                    dfs(cx, cy);
                }
            }
        }
    }
}