package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 사용 알고리즘 : 수학, 구현, 정렬
 * 오름차순 정렬 후 배열 전체 길이의 15%를 반올림한 수만큼 인덱스를 조정해서 계산
 */
public class Baekjoon18110 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] difficulty = new int[n];
        for (int i = 0; i < n; i++) {
            difficulty[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(difficulty);
        int exclusion = (int) Math.round((double) difficulty.length * 15 / 100);
        int sum = 0;
        for (int i = exclusion; i < difficulty.length - exclusion; i++) {
            sum += difficulty[i];
        }

        System.out.println((int) Math.round((double) sum / (difficulty.length - exclusion * 2)));
    }
}