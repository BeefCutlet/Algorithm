package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 사용 알고리즘 : 자료구조, 우선순위 큐
 * 자연수 입력 때마다 우선순위 큐로 순서 정렬 후 명령 실행
 */
public class Baekjoon1927 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(reader.readLine());
            if (x == 0) {
                if (queue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(queue.poll());
                }
            } else {
                queue.add(x);
            }
        }
    }
}