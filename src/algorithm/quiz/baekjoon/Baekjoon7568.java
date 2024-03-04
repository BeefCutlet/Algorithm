package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : 구현, 브루트포스 알고리즘
 * 각 회원끼리 차례대로 비교해서 본인보다 덩치가 큰 사람이 있는 경우 순위가 뒤로 밀림
 * 이차원 배열로 데이터 저장 : int[][] => [[사람1, 순위1], [사람2, 순위2], ...]
 */
public class Baekjoon7568 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int[][] spec = new int[N][2];
        int[][] grade = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            spec[i][0] = weight;
            spec[i][1] = height;
        }

        for (int i = 0; i < N; i++) {
            grade[i][0] = i;
            int baseWeight = spec[i][0];
            int baseHeight = spec[i][1];
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                if (baseWeight < spec[j][0] && baseHeight < spec[j][1]) {
                    grade[i][1]++;
                }
            }
            grade[i][1]++;
        }

        for (int[] result : grade) {
            System.out.println(result[1]);
        }
    }
}