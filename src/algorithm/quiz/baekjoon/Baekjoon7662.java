package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * 사용 알고리즘 : 자료구조, 트리를 사용한 집합과 맵, 우선순위 큐
 * TreeMap은 key를 기준으로 트리 구조로 오름차순 정렬한다.
 */
public class Baekjoon7662 {

    private static int[] A;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(reader.readLine());
            TreeMap<Integer, Integer> queue = new TreeMap<>();
            for (int j = 0; j < K; j++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    queue.put(num, queue.getOrDefault(num, 0) + 1);
                } else {
                    if (queue.size() == 0) {
                        continue;
                    }
                    int key = num == 1 ? queue.lastKey() : queue.firstKey();
                    if (queue.put(key, queue.get(key) - 1) == 1) {
                        queue.remove(key);
                    }
                }
            }

            System.out.println(queue.size() == 0 ? "EMPTY" : queue.lastKey() + " " + queue.firstKey());
        }
    }
}