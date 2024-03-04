package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 사용 알고리즘 : 자료구조, 문자열, 스택
 * 스택을 활용하여 괄호가 좌우대칭인지 확인
 */
public class Baekjoon4949 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = reader.readLine();
            if (str.equals(".")) {
                break;
            }

            String result = "";
            String[] words = str.split("");
            Stack<String> bracket = new Stack<>();
            for (String word : words) {
                if (word.equals("(")) {
                    bracket.add("(");
                } else if (word.equals(")")) {
                    if (bracket.isEmpty() || !bracket.peek().equals("(")) {
                        bracket.add("no");
                        break;
                    } else {
                        bracket.pop();
                    }
                }

                if (word.equals("[")) {
                    bracket.add("[");
                } else if (word.equals("]")) {
                    if (bracket.isEmpty() || !bracket.peek().equals("[")) {
                        bracket.add("no");
                        break;
                    } else {
                        bracket.pop();
                    }
                }
            }

            result = (bracket.isEmpty()) ? "yes" : "no";
            System.out.println(result);
        }
    }
}