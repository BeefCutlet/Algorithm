package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : 매개변수 알고리즘
 * K = 1, N = 1 일 때를 고려
 */
public class Baekjoon1654 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] cableLength = new long[K];

        long min = 1;
        long max = 0;
        for (int i = 0; i < K; i++) {
            cableLength[i] = Integer.parseInt(reader.readLine());
            max = Math.max(cableLength[i], max);
        }

        long maxLength = 0;
        while (min <= max) {
            long mid = (min + max) / 2;
            long cuttingCount = 0;

            for (long cable : cableLength) {
                cuttingCount += cable / mid;
            }

            if (cuttingCount < N) {
                max = mid - 1;
            } else {
                min = mid + 1;
                maxLength = Math.max(mid, maxLength);
            }
        }

        System.out.println(maxLength);
    }
}
