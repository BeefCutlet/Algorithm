package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : 정렬 (기수정렬)
 * 나이만 이용하여 기수정렬을 하면, 큐를 통해 순서대로 정렬되기 때문에 입력된 순서까지 유지된다.
 */
public class Baekjoon10814 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        String[][] strArr = new String[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            strArr[i][0] = st.nextToken();
            strArr[i][1] = st.nextToken();
        }

        int jarisu = 1;
        int count = 0;
        while (count != 3) {
            int[] order = new int[10];
            String[][] temp = new String[N][2];
            for (String[] str : strArr) {
                order[Integer.parseInt(str[0]) / jarisu % 10]++;
            }

            for (int i = 1; i <= 9; i++) {
                order[i] += order[i - 1];
            }

            for (int i = N - 1; i >= 0; i--) {
                int index = Integer.parseInt(strArr[i][0]) / jarisu % 10;
                temp[order[index] - 1] = strArr[i];
                order[index]--;
            }

            for (int i = 0; i < N; i++) {
                strArr[i] = temp[i];
            }

            jarisu *= 10;
            count++;
        }

        for (String[] str : strArr) {
            System.out.print(str[0] + " " + str[1] + "\n");
        }
    }
}