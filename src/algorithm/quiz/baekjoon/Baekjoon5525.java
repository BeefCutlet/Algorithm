package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 사용 알고리즘 : 문자열
 * memo : OI가 몇 번째 연속으로 나왔는지 기록
 * 인덱스 i, i+1에서 OI가 연속으로 나올 경우, memo[i-1] + 1 기록
 * memo[i+1] >= N이면, 조건이 만족하므로 첫번째 문자가 I인지만 확인하고, 만족하면 answer++
 */
public class Baekjoon5525 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());
        char[] S = reader.readLine().toCharArray();
        int[] memo = new int[M];

        int answer = 0;
        for (int i = 1; i < M - 1; i++) {
            if (S[i] == 'O' && S[i + 1] == 'I') {
                memo[i + 1] = memo[i - 1] + 1;
            }
            if (memo[i + 1] >= N && S[i + 1 - 2 * N] == 'I') {
                answer++;
            }
        }

        System.out.println(answer);
    }
}