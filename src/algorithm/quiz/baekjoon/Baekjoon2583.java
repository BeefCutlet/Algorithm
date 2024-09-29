package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 사용 알고리즘 : 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
 * map에서 사각형이 칠해진 곳을 +1
 * DFS로 map이 0인 곳을 탐색
 * => 구역 내 사각형 개수 : DFS를 실행하면서 탐색한 사각형 개수
 * => 구역 개수 : DFS 실행 횟수
 */
public class Baekjoon2583 {

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int squareCount = 0;


    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(reader.readLine());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());

            for (int j = lx; j < rx; j++) {
                for (int k = ly; k < ry; k++) {
                    map[k][j] = ++map[k][j];
                }
            }
        }

        int count = 0;
        List<Integer> districts = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    squareCount = 0;
                    dfs(j, i);
                    districts.add(squareCount);
                    count++;
                }
            }
        }

        Collections.sort(districts);

        System.out.println(count);
        for (int district : districts) {
            System.out.print(district + " ");
        }
    }

    static void dfs(int x, int y) {
        visited[y][x] = true;
        squareCount++;

        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];

            if (nX >= 0 && nX < map[0].length && nY >= 0 && nY < map.length && !visited[nY][nX] && map[nY][nX] == 0) {
                dfs(nX, nY);
            }
        }
    }
}