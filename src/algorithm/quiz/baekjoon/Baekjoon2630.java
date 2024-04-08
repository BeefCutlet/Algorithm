package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : 분할 정복, 재귀
 * 사각형 전체에서 판별
 * 전부 파란색 혹은 하얀색이면 결과 + 1
 * 아니면 재귀 함수로 사등분하여 다시 판별
 */
public class Baekjoon2630 {

    private static int[][] papers;
    private static int blue = 0;
    private static int white = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        papers = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int j = 1; j <= N; j++) {
                papers[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(1, N, 1, N);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void dfs(int startX, int endX, int startY, int endY) {
        //사각형 내에서 파랑, 하양 사각형 개수
        int tempBlue = 0;
        int tempWhite = 0;
        int total = (endX - startX + 1) * (endY - startY + 1);

        //큰 사각형을 돌면서 작은 사각형
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (papers[i][j] == 0) {
                    tempWhite++;
                } else {
                    tempBlue++;
                }
            }
        }

        //한 색으로 채워졌으면 끝, 안 채워졌으면 4등분 재귀
        if (tempBlue == total) {
            blue++;
        } else if (tempWhite == total) {
            white++;
        } else {
            dfs(startX, (startX + endX - 1) / 2, startY, (startY + endY - 1) / 2); //1사분면
            dfs((startX + endX - 1) / 2 + 1, endX, startY, (startY + endY - 1) / 2); //2사분면
            dfs(startX, (startX + endX - 1) / 2, (startY + endY - 1) / 2 + 1, endY); //3사분면
            dfs((startX + endX - 1) / 2 + 1, endX, (startY + endY - 1) / 2 + 1, endY); //4사분면
        }
    }
}