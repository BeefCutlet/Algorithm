package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : 수학, 기하학, 피타고라스 정리
 * 제일 큰 숫자를 A에 넣고, 피타고라스 정리로 검토
 */
public class Baekjoon4153 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (A == 0 && B == 0 && C == 0) {
                break;
            }

            if (A < B) {
                int temp = A;
                A = B;
                B = temp;
            }

            if (A < C) {
                int temp = A;
                A = C;
                C = temp;
            }

            if (A * A == B * B + C * C) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}