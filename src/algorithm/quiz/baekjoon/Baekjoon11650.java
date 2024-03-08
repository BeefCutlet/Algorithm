package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : 정렬
 */
public class Baekjoon11650 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        int[][] numArr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            numArr[i][0] = Integer.parseInt(st.nextToken());
            numArr[i][1] = Integer.parseInt(st.nextToken());
        }
        reader.close();

        Arrays.sort(numArr, (int[] o1, int[] o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        for (int[] nums : numArr) {
            writer.write(nums[0] + " " + nums[1] + "\n");
        }

        writer.flush();
        writer.close();
    }
}