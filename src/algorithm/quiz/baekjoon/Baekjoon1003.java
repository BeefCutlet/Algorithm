package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 사용 알고리즘 : 다이나믹 프로그래밍
 * fibonacci(n)의 0의 개수 == fibonacci(n - 1)의 0의 개수 + fibonacci(n - 2)의 0의 개수
 * fibonacci(n)의 1의 개수 == fibonacci(n - 1)의 1의 개수 + fibonacci(n - 2)의 1의 개수
 * 테스트 케이스에서 최댓값을 미리 구한 뒤, 최댓값까지의 0의 개수와 1의 개수를 미리 구해놓는다.
 */
public class Baekjoon1003 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(reader.readLine());
        int[] numArr = new int[T];
        int max = 0;
        for (int i = 0; i < T; i++) {
            numArr[i] = Integer.parseInt(reader.readLine());
            max = Math.max(max, numArr[i]);
        }
        reader.close();

        int[][] store = new int[max + 3][2];
        store[0][0] = 1;
        store[0][1] = 0;
        store[1][0] = 0;
        store[1][1] = 1;

        for (int i = 2; i <= max; i++) {
            store[i][0] = store[i - 1][0] + store[i - 2][0];
            store[i][1] = store[i - 1][1] + store[i - 2][1];
        }

        for (int num : numArr) {
            writer.write(store[num][0] + " " + store[num][1] + "\n");
            writer.flush();
        }

        writer.close();
    }
}