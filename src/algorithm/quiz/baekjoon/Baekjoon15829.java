package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 사용 알고리즘 : 구현, 문자열, 해싱
 * 모듈러 분배 법칙 : (a + b) % m == (a % m + b % m) % m
 */
public class Baekjoon15829 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(reader.readLine());
        char[] charArr = reader.readLine().toCharArray();
        long M = 1234567891;
        reader.close();

        long sum = 0;
        long pow = 1;
        for (int i = 0; i < L; i++) {
            sum += ((charArr[i] - 'a' + 1) * pow) % M;
            pow = (pow * 31) % M;
        }

        System.out.println(sum % M);
    }
}