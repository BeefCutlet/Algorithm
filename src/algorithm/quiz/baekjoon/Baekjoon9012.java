package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 사용 알고리즘 : 자료구조, 문자열, 스택
 * 스택을 활용하여 괄호가 좌우대칭인지 확인
 */
public class Baekjoon9012 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) {
            String[] words = reader.readLine().split("");
            Stack<String> bracket = new Stack<>();

            for (String word : words) {
                if (word.equals("(")) {
                    bracket.push("(");
                } else if (word.equals(")")) {
                    if (bracket.isEmpty() || !bracket.peek().equals("(")) {
                        bracket.push("NO");
                        break;
                    }
                    bracket.pop();
                }
            }

            String result = (bracket.isEmpty()) ? "YES" : "NO";
            System.out.println(result);
        }
        reader.close();
    }
}