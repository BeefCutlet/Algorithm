package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : 구현, 자료구조, 시뮬레이션, 큐
 * 우선순위 큐를 이용하여 문서의 우선순위를 내림차순으로 정렬
 * 문서를 배열로 만들고, 인덱스를 순서대로 이동하면서 큐 형태로 사용
 * 우선순위 큐에서 우선순위가 제일 높은 문서를 하나씩 꺼내가면서 비교하고, 몇 번째로 인쇄되는지 궁금한 문서를 출력할 때 중단
 */
public class Baekjoon1966 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] docArr = new int[N];

            PriorityQueue<Integer> orderedQueue = new PriorityQueue<>(Collections.reverseOrder());
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                int document = Integer.parseInt(st.nextToken());
                orderedQueue.offer(document);
                docArr[j] = document;
            }

            int index = 0;
            int count = 0;
            while (!orderedQueue.isEmpty()) {
                int num = docArr[index];
                int compare = orderedQueue.peek();
                if (num == compare) {
                    count++;
                    if (index == M) {
                        System.out.println(count);
                        break;
                    }
                    orderedQueue.poll();
                }

                index++;
                if (index == docArr.length) {
                    index = 0;
                }
            }
        }
    }
}