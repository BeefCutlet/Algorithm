package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : 수학
 * A == V일 때, 하루만에 올라가므로 1
 * A != V일 때, 첫날 낮을 제외하고는 A - B만큼 올라가므로 (V - A) / (A - B)를 올림하여 계산
 * 첫날을 미리 뺐으므로 1일 추가
 */
public class Baekjoon2869 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        if (A != V) {
            V -= A;
            System.out.println((int) Math.ceil((double) V / (A - B)) + 1);
        } else {
            System.out.println(1);
        }
    }
}