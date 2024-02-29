package algorithm.baekjoon.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 사용 알고리즘 : 자료구조, 스택
 * 스택에서 꺼낸 숫자가 배열의 숫자보다 크면 불가능
 */
public class Baekjoon1874 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int[] base = new int[N];
        String[] order = new String[N * 2];

        for (int i = 0; i < N; i++) {
            base[i] = Integer.parseInt(reader.readLine());
        }

        int num = 1;
        int orderIndex = 0;
        Stack<Integer> stack = new Stack<>();

        boolean isRight = true;
        for (int i = 0; i < N; i++) {
            if (stack.empty() && num <= N) {
                stack.add(num);
                order[orderIndex] = "+";
                orderIndex++;
                num++;
            }

            while (!stack.empty()) {
                int compare = stack.peek();
                if (compare > base[i]) {
                    isRight = false;
                    break;
                }

                if (compare < base[i]) {
                    stack.add(num);
                    order[orderIndex] = "+";
                    orderIndex++;
                    num++;
                } else if (compare == base[i]) {
                    stack.pop();
                    order[orderIndex] = "-";
                    orderIndex++;
                    break;
                }
            }

            if (!isRight) {
                break;
            }
        }

        if (isRight) {
            for (String str : order) {
                System.out.println(str);
            }
        } else {
            System.out.println("NO");
        }
    }
}
