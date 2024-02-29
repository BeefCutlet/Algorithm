package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : 수학, 정수론, 소수 판정, 에라토스테네스의 체
 * 에라토스테네스의 체 : 특정 수가 소수로 판명된 경우, 그 수의 배수는 모두 소수가 아니다.
 * 0과 1은 소수에서 배제한다.
 */
public class Baekjoon1929 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] isNotPrime = new boolean[N + 1];
        isNotPrime[0] = isNotPrime[1] = true;

        for (int i = M; i <= N; i++) {
            if (!isNotPrime[i]) {
                boolean isPrime = isPrime(i);
                if (isPrime) {
                    for (int j = 2 * i; j <= N; j += i) {
                        isNotPrime[j] = true;
                    }
                } else {
                    isNotPrime[i] = true;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (!isNotPrime[i]) {
                System.out.println(i);
            }
        }
    }

    static boolean isPrime(int num) {
        int divCount = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                divCount++;
            }
            if (divCount > 1) {
                return false;
            }
        }
        return true;
    }
}
