package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : 수학, 정수론, 유클리드 호제법
 * 최대공약수 : a > b일 때, a와 b의 최대공약수는 a를 b로 나눈 나머지 r과 b의 최대공약수와 같다.
 * => ex) a % b = r, b % r = 0일 때, 최대공약수는 b
 * 최소공배수 : a와 b를 곱한 수를 최대공약수로 나눈 값과 같다.
 */
public class Baekjoon2609 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int a = A;
        int b = B;

        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        int r;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        System.out.println(a);
        System.out.println(A * B / a);
    }
}