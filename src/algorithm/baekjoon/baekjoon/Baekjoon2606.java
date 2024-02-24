package algorithm.baekjoon.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : DFS
 */
public class Baekjoon2606 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());
        boolean[] visited = new boolean[N + 1];
        int[][] matrix = new int[N + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(reader.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            matrix[node1][node2] = 1;
            matrix[node2][node1] = 1;
        }

        dfs(1, visited, matrix);

        int count = 0;
        for (boolean isVisited : visited) {
            if (isVisited) {
                count++;
            }
        }
        if (count > 0) {
            count--;
        }

        writer.write(String.valueOf(count));
        writer.flush();
    }

    static void dfs(int startNode, boolean[] visited, int[][] matrix) {
        for (int i = 1; i < matrix[startNode].length; i++) {
            if (matrix[startNode][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i, visited, matrix);
            }
        }
    }
}
