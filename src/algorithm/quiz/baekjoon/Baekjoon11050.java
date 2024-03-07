package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : 수학, 구현, 조합론
 * 파스칼의 삼각형 활용 (재귀식으로 표현)
 * nCr = n-1Cr-1 + n-1Cr (0 < K < N)
 * 단, K = 0일 때나 K = N일 때에는 1이 되어야 함
 */
public class Baekjoon11050 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        System.out.println(binomial(N, K));
    }

    public static int binomial(int n, int r) {
        if (r == 0 || r == n) {
            return 1;
        }
        return binomial(n - 1, r - 1) + binomial(n - 1, r);
    }
}