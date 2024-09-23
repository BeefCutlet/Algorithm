package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 사용 알고리즘 : 그래프 이론, 브루트포스 알고리즘, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
 * 수면 높이를 하나씩 높여가면서 다음 조건에 맞는 지점을 기준으로 깊이 우선 탐색을 한다.
 * 1. 아직 방문하지 않은 지점
 * 2. 수면 높이보다 높은 지점
 * 깊이 우선 탐색이 끝나면 안전 지역 카운트를 하나 높인다.
 * 전체 지역을 모두 검토했다면 현재 안전 지역 카운트와 최대 안전 지역 카운트를 비교해서 큰 값을 갱신한다.
 * -----------------------------------------
 * 너비 우선 탐색을 할 경우, Queue에 x, y값을 모두 저장해야 하기 때문에 배열이나 객체를 계속 생성하게 된다.
 * 이로 인해 메모리 부족이 발생할 수 있다.
 */
public class Baekjoon2468 {

    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        map = new int[N][N];
        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        int max = 0;
        for (int rainHeight = 0; rainHeight <= maxHeight; rainHeight++) {
            visited = new boolean[N][N];
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] > rainHeight) {
                        dfs(i, j, rainHeight);
                        count++;
                    }
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }

    static void dfs(int x, int y, int height) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];
            if (nX >= 0 && nX < visited.length && nY >= 0 && nY < visited.length && !visited[nX][nY] && map[nX][nY] > height) {
                dfs(nX, nY, height);
            }
        }
    }
}