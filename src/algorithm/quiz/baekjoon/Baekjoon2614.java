package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 사용 알고리즘 : 자료구조, 큐
 * 큐에 1~N까지 숫자를 넣고,
 * 홀수번째에는 숫자 제거, 짝수번째에는 숫자를 뽑아서 다시 넣기
 */
public class Baekjoon2614 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        int count = 0;
        while (queue.size() > 1) {
            count++;
            if (count % 2 == 1) {
                queue.poll();
            } else {
                int num = queue.poll();
                queue.offer(num);
            }
        }

        System.out.println(queue.poll());
    }
}