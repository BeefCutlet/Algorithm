package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : 이분 탐색, 매개 변수 탐색
 * 이분 탐색으로 잘라서 자른 나무의 합 비교
 */
public class Baekjoon2805 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int min = 0;
        int max = 0;
        int[] trees = new int[N];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            int tree = Integer.parseInt(st.nextToken());
            trees[i] = tree;
            max = Math.max(max, tree);
        }

        while (min < max) {
            int mid = (min + max) / 2;
            long sum = 0;

            for (int tree : trees) {
                if (tree - mid > 0) {
                    sum += (tree - mid);
                }
            }

            if (sum < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}