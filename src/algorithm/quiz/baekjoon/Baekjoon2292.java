package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 사용 알고리즘 : 수학
 * 밖으로 갈수록 경계값은 6 * 1, 6 * 2, 6 * 3...만큼 증가한다.
 * 경계값이 N보다 커질 때까지 이동횟수가 1씩 증가한다.
 */
public class Baekjoon2292 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int count = 0;
        int start = 1;

        while (true) {
            start += 6 * count;
            if (start >= N) {
                break;
            }
            count++;
        }
        System.out.println(count + 1);
    }
}