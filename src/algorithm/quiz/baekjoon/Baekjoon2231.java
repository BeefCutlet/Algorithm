package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 사용 알고리즘 : 브루트포스 알고리즘
 * 자리수의 각 숫자는 최대 9이므로 생성자가 될 수 있는 숫자는 (N - 자리수 * 9)보다 작을 수 없다.
 */
public class Baekjoon2231 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        int length = input.length();

        int N = Integer.parseInt(input);
        boolean isGenerator = false;
        for (int num = N - length * 9; num <= N; num++) {
            int generator = num;
            int temp = num;
            while (temp > 0) {
                generator += temp % 10;
                temp /= 10;
            }
            if (generator == N) {
                isGenerator = true;
                System.out.println(num);
                break;
            }
        }

        if (!isGenerator) {
            System.out.println(0);
        }
    }
}