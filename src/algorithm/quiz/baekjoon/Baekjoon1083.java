package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : 그리디 알고리즘, 정렬
 * 비교 방식 : 더 큰 숫자가 앞으로
 * 시작 인덱스부터 S만큼 이동하면서 제일 큰 숫자를 찾아서 인덱스를 기록
 * 기록된 인덱스에 있는 숫자를 앞으로 정렬시키고, 최대 이동 횟수가 남았다면 다음으로 큰 숫자를 찾아서 비교 및 시작 인덱스 + 1 위치로 이동
 * 시작 인덱스가 N - 1에 도달하거나 이동횟수를 S만큼 소진시켰을 때 중단
 */
public class Baekjoon1083 {

    private static List<Integer> A;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());
        A = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }
        int S = Integer.parseInt(reader.readLine());

        for (int startIndex = 0; startIndex < N && S > 0; startIndex++) {
            int maxIndex = startIndex;
            for (int i = startIndex + 1; i < N && i <= startIndex + S; i++) {
                if (A.get(i) > A.get(maxIndex)) {
                    maxIndex = i;
                }
            }

            if (startIndex != maxIndex) {
                int temp = A.get(maxIndex);
                A.remove(maxIndex);
                A.add(startIndex, temp);
            }
            S -= (maxIndex - startIndex);
        }

        for (int a : A) {
            System.out.print(a + " ");
        }
    }
}