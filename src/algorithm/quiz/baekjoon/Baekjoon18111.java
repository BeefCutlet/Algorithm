package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : 구현, 브루트포스 알고리즘
 * 현재 땅의 최소 높이와 최대 높이를 구하고,
 * 최소 높이부터 최대 높이 사이에 목표 높이를 1씩 올려가면서
 * 목표 높이에 도달하기 위해 걸리는 시간을 측정한다.
 * 최소 높이에 가까울수록 블록을 얻는 횟수가 더 많기 때문에 보유하는 블록 숫자가 더 많을 것이고,
 * 최대 높이에 가까울수록 블록을 사용하는 횟수가 더 많기 때문에 보유하는 블록 숫자가 더 적을 것이다.
 * 그렇기에 목표 높이를 올리면서 시간을 측정할 때, 보유 블록 숫자는 계속 줄어들 것이고,
 * 측정 완료 후 보유 블록 숫자가 음수가 되면 해당 높이부터는 만들 수 없는 높이이므로 측정을 중단한다.
 */
public class Baekjoon18111 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] ground = new int[N][M];

        int maxHeight = 0;
        int minHeight = 256;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++) {
                int height = Integer.parseInt(st.nextToken());
                ground[i][j] = height;
                maxHeight = Math.max(maxHeight, height);
                minHeight = Math.min(minHeight, height);
            }
        }
        reader.close();

        int time = Integer.MAX_VALUE;
        int goal = 0;
        for (int height = minHeight; height <= maxHeight; height++) {
            int action = 0;
            int inventory = B;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (ground[i][j] > height) {
                        action += (ground[i][j] - height) * 2;
                        inventory += ground[i][j] - height;
                    } else if (ground[i][j] < height) {
                        action += height - ground[i][j];
                        inventory -= height - ground[i][j];
                    }
                }
            }

            if (inventory < 0) {
                break;
            }

            if (action <= time) {
                time = action;
                goal = height;
            }
        }

        writer.write(time + " " + goal);
        writer.flush();
        writer.close();
    }
}