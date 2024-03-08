package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : 구현, 자료구조, 큐
 * 큐로 풀면 되지만, 큐 없이 풀었다..
 */
public class Baekjoon11866 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        reader.close();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int deathCount = 0;
        boolean[] isDeath = new boolean[N + 1];
        int index = 0;

        writer.write("<");
        index += K;
        isDeath[index] = true;
        deathCount++;
        writer.write(index + "");

        while (!(deathCount == isDeath.length - 1)) {
            int move = 0;
            while (move < K) {
                index++;
                if (index > N) {
                    index -= N;
                }

                if (isDeath[index]) {
                    continue;
                }

                move++;
            }

            isDeath[index] = true;
            deathCount++;
            writer.write(", " + index);
        }
        writer.write(">");

        writer.flush();
        writer.close();
    }
}