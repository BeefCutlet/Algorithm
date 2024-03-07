package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : 자료구조, 정렬, 이분탐색, 해시를 사용한 집합과 맵
 * HashMap을 사용 (Key : 입력된 숫자, Value : 숫자의 개수)
 * 입력된 M개의 숫자를 Key로 검색하여 숫자의 개수를 구함
 */
public class Baekjoon10816 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Integer, Integer> count = new HashMap<>();

        int N = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            count.put(input, count.getOrDefault(input, 0) + 1);
        }

        int M = Integer.parseInt(reader.readLine());
        st = new StringTokenizer(reader.readLine());
        reader.close();

        for (int i = 0; i < M; i++) {
            writer.write(count.getOrDefault(Integer.parseInt(st.nextToken()), 0) + " ");
        }

        writer.flush();
        writer.close();
    }
}