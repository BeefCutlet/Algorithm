package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 사용 알고리즘 : 그래프 이론, 그래프 탐색, 트리, 너비우선탐색, 깊이우선탐색
 * 각 노드들의 연결 상태를 인접 리스트로 만들고, 1번 노드부터 BFS로 탐색하면서 부모 노드를 기록한다.
 * 부모 노드 정보는 parent 배열에 기록하고, 방문 정보는 visited 배열에 기록한다.
 */
public class Baekjoon11725 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        int[] parent = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        List<Integer>[] nodeList = new ArrayList[N + 1];
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            if (nodeList[node1] != null) {
                nodeList[node1].add(node2);
            } else {
                nodeList[node1] = new ArrayList<>();
                nodeList[node1].add(node2);
            }

            if (nodeList[node2] != null) {
                nodeList[node2].add(node1);
            } else {
                nodeList[node2] = new ArrayList<>();
                nodeList[node2].add(node1);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            visited[currentNode] = true;
            List<Integer> edges = nodeList[currentNode];

            if (edges != null) {
                for (int edge : edges) {
                    if (!visited[edge]) {
                        parent[edge] = currentNode;
                        queue.add(edge);
                    }
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }
}