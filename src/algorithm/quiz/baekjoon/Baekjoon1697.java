package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : 그래프 이론, 그래프 탐색, 너비 우선 탐색
 * 현재 위치에서 n - 1, n + 1, n * 2 위치에 이동했을 때를 모두 비교
 */
public class Baekjoon1697 {

    private static int N, K;
    private static int[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[100001];
        int result = bfs(N);
        System.out.println(result);
    }

    private static int bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(node);
        int n;
        visited[node] = 1;
        while (!queue.isEmpty()) {
            n = queue.poll();
            if (n == K) {
                return visited[n] - 1;
            }

            if (n - 1 >= 0 && visited[n - 1] == 0) {
                visited[n - 1] = visited[n] + 1;
                queue.add(n - 1);
            }

            if (n + 1 <= 100000 && visited[n + 1] == 0) {
                visited[n + 1] = visited[n] + 1;
                queue.add(n + 1);
            }

            if (n * 2 <= 100000 && visited[n * 2] == 0) {
                visited[n * 2] = visited[n] + 1;
                queue.add(n * 2);
            }
        }

        return -1;
    }
}