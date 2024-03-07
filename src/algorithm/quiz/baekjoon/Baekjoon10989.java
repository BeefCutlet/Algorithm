package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 사용 알고리즘 : 정렬 (기수정렬)
 */
public class Baekjoon10989 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        int[] baseArr = new int[N];
        for (int i = 0; i < N; i++) {
            baseArr[i] = Integer.parseInt(reader.readLine());
        }
        reader.close();

        int jarisu = 1;
        int count = 0;
        while (count != 5) {
            int[] order = new int[10];
            int[] temp = new int[N];

            for (int base : baseArr) {
                order[base / jarisu % 10]++;
            }

            for (int i = 1; i <= 9; i++) {
                order[i] += order[i - 1];
            }

            for (int i = N - 1; i >= 0; i--) {
                int index = baseArr[i] / jarisu % 10;
                temp[order[index] - 1] = baseArr[i];
                order[index]--;
            }

            for (int i = 0; i < N; i++) {
                baseArr[i] = temp[i];
            }

            jarisu *= 10;
            count++;
        }

        for (int base : baseArr) {
            writer.write(base + "\n");
        }

        writer.flush();
        writer.close();
    }
}