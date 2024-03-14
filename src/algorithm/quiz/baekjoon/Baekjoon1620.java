package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 사용 알고리즘 : 자료구조, 해시를 이용한 집합과 맵
 * 맵1 => 키 : 문자, 값 : 숫자
 * 맵2 => 키 : 숫자, 값 : 문자
 * 들어온 값의 첫 글자만 확인해서 영어 대문자면 맵1에서, 숫자면 맵2에서 확인
 */
public class Baekjoon1620 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> noToName = new HashMap<>();
        Map<String, String> nameToNo = new HashMap<>();
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String name = reader.readLine();
            noToName.put(String.valueOf(i), name);
            nameToNo.put(name, String.valueOf(i));
        }

        for (int i = 0; i < M; i++) {
            String call = reader.readLine();
            char firstLetter = call.charAt(0);
            if (firstLetter >= 'A' && firstLetter <= 'Z') {
                System.out.println(nameToNo.get(call));
            } else {
                System.out.println(noToName.get(call));
            }
        }
    }
}