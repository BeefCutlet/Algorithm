package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : 수학, 정수론, 소수 판정
 */
public class Baekjoon1978 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int[] numArr = new int[N];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int num : numArr) {
            if (num == 1) {
                continue;
            }
            boolean isPrime = true;

            int divCount = 0;
            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    divCount++;
                }
                if (divCount > 1) {
                    isPrime = false;
                }
            }

            if (isPrime) {
                count++;
            }
        }

        System.out.println(count);
    }
}
