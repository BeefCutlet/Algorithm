package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
 * 노드를 연결 리스트로 만든 뒤, DFS 수행
 */
public class Baekjoon11724 {

    private static boolean[] visited;
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int count = 0;
        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(reader.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        for (int node = 1; node <= N; node++) {
            boolean isVisited = visited[node];
            if (!isVisited) {
                visited[node] = true;
                for (int target : graph[node]) {
                    dfs(target);
                }
                count++;
            }
        }

        System.out.println(count);
    }

    private static void dfs(int startNode) {
        if (visited[startNode]) {
            return;
        }
        visited[startNode] = true;

        for (int targetNode : graph[startNode]) {
            dfs(targetNode);
        }
    }
}