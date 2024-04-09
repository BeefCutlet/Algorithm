package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : 수학, 브루트포스 알고리즘, 정수론, 중국인의 나머지 정리
 * x가 M만큼 시간이 지나서 다시 x가 되는 동안 걸리는 시간을 N으로 나누어서 나머지가 0이 되는 경우를 찾는다.
 */
public class Baekjoon6064 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(reader.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int A = Math.max(M, N);
            int B = Math.min(M, N);
            int gcd = gcd(A, B);
            int lcm = A * B / gcd;

            int answer = -1;

            x--;
            y--;
            int year = x;
            while (year <= lcm) {
                if (year % N == y) {
                    answer = year + 1;
                    break;
                }
                year += M;
            }
            System.out.println(answer);
        }
    }

    private static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}