package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : 분할 정복, 재귀
 * 사분면으로 나누어서 r, c가 어느 사분면에 속하는지 확인해가면서 재귀
 */
public class Baekjoon1074 {

    static int N, R, C, answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        recurrence(0, 0, (int) Math.pow(2, N));
    }

    static void recurrence(int r, int c, int size) {
        if (size == 1) {
            System.out.println(answer);
            return;
        }

        int newSize = size / 2;
        if (R < r + newSize && C < c + newSize) {
            recurrence(r, c, newSize);
        }
        if (R < r + newSize && c + newSize <= C) {
            answer += (size * size) / 4;
            recurrence(r, c + newSize, newSize);
        }
        if (r + newSize <= R && C < c + newSize) {
            answer += (size * size) / 4 * 2;
            recurrence(r + newSize, c, newSize);
        }
        if (r + newSize <= R && c + newSize <= C) {
            answer += (size * size) / 4 * 3;
            recurrence(r + newSize, c + newSize, newSize);
        }
    }
}