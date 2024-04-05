package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 사용 알고리즘 : 구현, 자료구조, 문자열, 파싱, 덱
 * 명령어 R일 경우, Deque를 활용하여 다른 방향에서 접근하도록 설정
 */
public class Baekjoon5430 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(reader.readLine());
        LOOP: for (int i = 0; i < T; i++) {
            //명령어 입력
            char[] commands = reader.readLine().toCharArray();
            //배열 길이 입력
            int N = Integer.parseInt(reader.readLine());
            //배열의 수를 담을 Deque
            Deque<Integer> deque = new ArrayDeque<>();
            String str = reader.readLine();
            String substring = str.substring(1, str.length() - 1);
            String[] strArr = substring.split(",");
            int index = 1;
            //배열에 있는 수를 Deque에 입력
            for (int j = 0; j < N; j++) {
                deque.add(Integer.parseInt(strArr[j]));
            }

            boolean isReversed = false;
            //명령어 실행
            for (char command : commands) {
                if (command == 'R') {
                    isReversed = !isReversed;
                    continue;
                }
                if (command == 'D') {
                    if (deque.isEmpty()) {
                        writer.write("error\n");
                        writer.flush();
                        continue LOOP;
                    }
                    if (!isReversed) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                }
            }

            //Deque에 남아있는 숫자로 배열 생성
            writer.write("[");
            int length = deque.size();
            for (int k = 0; k < length; k++) {
                if (!isReversed) {
                    writer.write(String.valueOf(deque.pollFirst()));
                } else {
                    writer.write(String.valueOf(deque.pollLast()));
                }
                if (k != length - 1) {
                    writer.write(",");
                }
            }
            writer.write("]\n");
            writer.flush();
        }
    }
}