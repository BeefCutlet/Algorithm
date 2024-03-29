package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * 사용 알고리즘 : 자료구조, 문자열, 정렬, 해시를 사용한 집합과 맵
 */
public class Baekjoon1764 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> look = new HashSet<>();
        for (int i = 0; i < N; i++) {
            look.add(reader.readLine());
        }

        List<String> names = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = reader.readLine();
            if (look.contains(name)) {
                names.add(name);
            }
        }

        Collections.sort(names);

        writer.write(names.size() + "\n");
        for (String name : names) {
            writer.write(name + "\n");
        }

        reader.close();
        writer.flush();
        writer.close();
    }
}