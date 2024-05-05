package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : 그래프 이론, 그래프 탐색, 트리, 깊이 우선 탐색
 * 인접 리스트로 노드 구조를 완성하고,
 * 루트 노드를 찾아서 DFS를 적용한다.
 */
public class Baekjoon1068 {

    private static int COUNT = 0;
    private static ArrayList<ArrayList<Integer>> tree;
    private static int remove;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        tree = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int root = 0;
        for (int i = 0; i < N; i++) {
            int node = Integer.parseInt(st.nextToken());
            if (node == -1) {
                root = i;
                continue;
            }
            tree.get(node).add(i);
        }

        remove = Integer.parseInt(reader.readLine());
        dfs(root);
        System.out.println(COUNT);
    }

    static void dfs(int node) {
        if (node == remove) {
            return;
        }

        if (tree.get(node).isEmpty()) {
            COUNT++;
            return;
        }

        for (int i = 0; i < tree.get(node).size(); i++) {
            int child = tree.get(node).get(i);
            if (child != remove) {
                dfs(child);
            } else if (tree.get(node).size() == 1) {
                COUNT++;
                return;
            }
        }
    }
}