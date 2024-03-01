package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 사용 알고리즘 : 수학, 구현, 정렬
 * 입력값을 빈도수를 파악할 맵과 배열에 저장
 * 산술평균 : 배열을 이용해 전체 합을 구하고 N을 나누기
 * 중앙값 : 배열에서 인덱스가 N / 2인 값
 * 최빈값 : 맵의 Value가 제일 높은 Key. 중복이 있을 수 있기에 우선순위 큐로 자동정렬하고, 큐의 크기가 2 이상이면 2번째 숫자를 출력
 * 범위 : 배열에서 양 끝의 값들의 차
 */
public class Baekjoon2108 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int[] numArr = new int[N];
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(reader.readLine());
            numArr[i] = num;
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(numArr);

        int sum = 0;
        for (int num : numArr) {
            sum += num;
        }

        System.out.println(Math.round((double) sum / N));
        System.out.println(numArr[N / 2]);

        int max = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Set<Map.Entry<Integer, Integer>> entries = frequency.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer value = entry.getValue();
            if (max < value) {
                queue = new PriorityQueue<>();
                queue.add(entry.getKey());
                max = value;
            } else if (max == value) {
                queue.add(entry.getKey());
            }
        }

        if (queue.size() > 1) {
            queue.poll();
            System.out.println(queue.peek());
        } else {
            System.out.println(queue.peek());
        }

        System.out.println(numArr[N - 1] - numArr[0]);
    }
}