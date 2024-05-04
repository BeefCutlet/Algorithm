package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : 수학
 * 최대 속도가 maxH인 상황에서,
 * 이동 횟수는 남은 거리가 0일 때 2 * (maxH - 1) + 1,
 * 남은 거리가 1 ~ maxH일 때, 2 * (maxH - 1) + 2,
 * 남은 거리가 maxH + 1 ~ 2 * maxH일 때, 2 * (maxH - 1) + 3
 */
public class Baekjoon1011 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            int gap = Y - X;

            int maxH = 1;
            int move = 1;
            gap -= move;
            while (gap > 2 * maxH) {
                gap -= 2 * maxH + 1;
                maxH += 1;
            }

            int moveCount = 2 * (maxH - 1) + 1;
            if (gap == 0) {
                System.out.println(moveCount);
            } else if (gap > 0 && gap <= maxH)  {
                System.out.println(moveCount + 1);
            } else if (gap > maxH && gap <= 2 * maxH) {
                System.out.println(moveCount + 2);
            }
        }
    }
}