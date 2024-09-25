package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
 * DFS로 상하좌우 대각선까지 모두 탐색하면서 탐색이 끝날 때 섬 count +1
 */
public class Baekjoon4963 {

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> results = new ArrayList<>();
        while (true) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            visited = new boolean[h][w];
            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(reader.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            results.add(count);
        }

        for (int result : results) {
            System.out.println(result);
        }
    }

    static void dfs(int h, int w) {
        visited[h][w] = true;

        for (int i = 0; i < 8; i++) {
            int nH = h + dx[i];
            int nW = w + dy[i];

            if (nH >= 0 && nH < map.length && nW >= 0 && nW < map[0].length && !visited[nH][nW] && map[nH][nW] == 1) {
                dfs(nH, nW);
            }
        }
    }
}