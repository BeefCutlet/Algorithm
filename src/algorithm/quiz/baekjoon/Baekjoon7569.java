package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : 그래프 이론, 그래프 탐색, 너비 우선 탐색
 */
public class Baekjoon7569 {

    private static int M, N, H;
    private static int[] X = {1, 0, -1, 0, 0, 0};
    private static int[] Y = {0, 1, 0, -1, 0, 0};
    private static int[] Z = {0, 0, 0, 0, 1, -1};
    private static int[][][] box;
    private static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H + 1][N + 1][M + 1];
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
            st = new StringTokenizer(reader.readLine());
                for (int k = 1; k <= M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        queue.add(new Point(i, j, k));
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int height = point.height;
            int row = point.row;
            int column = point.column;

            for (int i = 0; i < 6; i++) {
                int moveHeight = height + Z[i];
                int moveRow = row + X[i];
                int moveColumn = column + Y[i];

                if (isValid(moveHeight, moveRow, moveColumn)) {
                    queue.add(new Point(moveHeight, moveRow, moveColumn));
                    box[moveHeight][moveRow][moveColumn] = box[height][row][column] + 1;
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= M; k++) {
                    if (box[i][j][k] == 0) {
                        return -1;
                    }
                    result = Math.max(box[i][j][k], result);
                }
            }
        }

        if (result == 1) {
            return 0;
        } else {
            return result - 1;
        }
    }

    private static boolean isValid(int height, int row, int column) {
        if (height < 1 || height > H || row < 1 || row > N || column < 1 || column > M) {
            return false;
        }
        return box[height][row][column] == 0;
    }
}

class Point {
    int height;
    int row;
    int column;

    public Point(int height, int row, int column) {
        this.height = height;
        this.row = row;
        this.column = column;
    }
}