package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : 브루트포스 알고리즘
 * 0~999999의 채널을 돌면서 버튼 클릭 최솟값을 구함
 * M == 0 일 때에는 망가진 버튼 정보를 받을 필요가 없음 (받으면 NPE)
 */
public class Baekjoon1107 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());

        int result = Math.abs(N - 100);
        if (M == 0) {
            result = Math.min(result, String.valueOf(N).length());
            System.out.println(result);
        } else {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            boolean[] broken = new boolean[10];
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }

            for (int i = 0; i <= 999999; i++) {
                String num = String.valueOf(i);
                int length = num.length();

                boolean isBreak = false;
                for (int j = 0; j < length; j++) {
                    if (broken[num.charAt(j) - '0']) {
                        isBreak = true;
                        break;
                    }
                }

                if (!isBreak) {
                    int min = Math.abs(N - i) + length;
                    result = Math.min(min, result);
                }
            }
            System.out.println(result);
        }
    }
}