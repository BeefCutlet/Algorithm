package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : 플로이드 워셔
 * 플로이드-워셜 : 시작 노드 start, 끝 노드 end, 중간 노드 mid 일 때, 가중치 D[start][end] = D[start][mid] + D[mid][end]
 */
public class Baekjoon1389 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] distance = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = 987654321;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(reader.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            distance[S][E] = 1;
            distance[E][S] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int result = -1;
        for (int i = 1; i <= N; i++) {
            int temp = 0;
            for (int j = 1; j <= N; j++) {
                temp += distance[i][j];
            }
            if (temp < min) {
                min = temp;
                result = i;
            }
        }

        System.out.println(result);
    }
}