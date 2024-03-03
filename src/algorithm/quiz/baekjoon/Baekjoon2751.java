package algorithm.quiz.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 사용 알고리즘 : 정렬
 * 병합정렬 (Merge Sort)
 * => 분할 정복을 이용하여 정렬
 */
public class Baekjoon2751 {

    //분할 정복 시 numArr 배열의 데이터를 복사할 임시 배열
    public static int[] temp;
    //정렬해야할 데이터가 담긴 배열
    public static int[] numArr;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        numArr = new int[N + 1];
        temp = new int[N + 1];

        //1~N까지 데이터 저장 (인덱스와 저장할 숫자를 동일하게 맞춤)
        for (int i = 1; i <= N; i++) {
            numArr[i] = Integer.parseInt(reader.readLine());
        }
        reader.close();
        //병합 정렬
        mergeSort(1, N);

        for (int i = 1; i <= N; i++) {
            writer.write(numArr[i] + "\n");
        }
        writer.flush();
        writer.close();
    }

    //병합 정렬 로직
    public static void mergeSort(int s, int e) {
        //s : 시작값, e : 끝값
        //재귀 함수를 이용하여 분할 정복을 할 때, 재귀를 멈출 지점
        if (e - s < 1) {
            return;
        }
        //중앙값 구하기
        int m = s + (e - s) / 2;
        //재귀 함수를 이용하여 분할 정복
        mergeSort(s, m);
        mergeSort(m + 1, e);

        //데이터 복사
        for (int i = s; i <= e; i++) {
            temp[i] = numArr[i];
        }

        //numArr의 인덱스
        int k = s;
        //왼쪽 그룹의 인덱스
        int index1 = s;
        //오른쪼 그룹의 인덱스
        int index2 = m + 1;

        //왼쪽 그룹과 오른쪽 그룹을 비교해서 작은 수를 numArr에 순서대로 배치
        //배치한 그룹의 인덱스는 1씩 증가
        while (index1 <= m && index2 <= e) {
            if (temp[index1] > temp[index2]) {
                numArr[k] = temp[index2];
                k++;
                index2++;
            } else {
                numArr[k] = temp[index1];
                k++;
                index1++;
            }
        }
        //왼쪽 그룹에서 배치되지 않은 숫자들을 순서대로 배치
        while (index1 <= m) {
            numArr[k] = temp[index1];
            k++;
            index1++;
        }
        //오른쪽 그룹에서 배치되지 않은 숫자들을 순서대로 배치
        while (index2 <= e) {
            numArr[k] = temp[index2];
            k++;
            index2++;
        }
    }
}