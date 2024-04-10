package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : 그래프 이론, 그래프 탐색, 너비 우선 탐색
 */
public class Baekjoon7576 {

    private static int N, M;
    private static int[][] box;
    private static int[] moveX = {0, 1, 0, -1};
    private static int[] moveY = {1, 0, -1, 0};
    private static Queue<PointXY> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 1; j <= M; j++) {
                int tomato = Integer.parseInt(st.nextToken());
                if (tomato == -1) {
                    box[i][j] = tomato;
                } else if (tomato == 1) {
                    queue.add(new PointXY(i, j, 1));
                }
            }
        }

        while (!queue.isEmpty()) {
            bfs(queue.poll());
        }

        int maxDay = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                maxDay = Math.max(maxDay, box[i][j]);
            }
        }

        System.out.println(maxDay - 1);
    }

    private static void bfs(PointXY pointXY) {
        int x = pointXY.getX();
        int y = pointXY.getY();
        int currentDay = pointXY.getDay();

        if (box[x][y] != 0) {
            return;
        }
        box[x][y] = currentDay;

        for (int i = 0; i < 4; i++) {
            int tempX = x + moveX[i];
            int tempY = y + moveY[i];
            int tempDay = currentDay + 1;

            if (tempX >= 1 && tempX <= N && tempY >= 1 && tempY <= M && box[tempX][tempY] == 0) {
                queue.add(new PointXY(tempX, tempY, tempDay));
            }
        }
    }
}

class PointXY {
    private int x;
    private int y;
    private int day;

    public PointXY(int x, int y, int day) {
        this.x = x;
        this.y = y;
        this.day = day;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDay() {
        return day;
    }
}