package algorithm;

import java.util.Arrays;

public class BubbleSort {
	
	static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	static void sort(int[] array, int n) {
		int exchange = 0;
		int compare = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = n - 1; j > i; j--) {
				if (array[j - 1] > array[j]) {
					swap(array, j - 1, j);
					exchange++;
				}
				compare++;
			}
		}
		System.out.println("비교 : " + compare + "회");
		System.out.println("교환 : " + exchange + "회");
	}
	
	static void sort2(int[] array, int n) {
		int exchange = 0;
		int compare = 0;
		for (int i = 0; i < n - 1; i++) {
			int count = 0;
			for (int j = n - 1; j > i; j--) {
				if (array[j - 1] > array[j]) {
					swap(array, j - 1, j);
					count++;
					exchange++;
				}
				compare++;
			}
			if (count == 0) break;
		}
		System.out.println("비교 : " + compare + "회");
		System.out.println("교환 : " + exchange + "회");
	}
	
	static void sort3(int[] array, int n) {
		int exchange = 0;
		int compare = 0;
		int k = 0;
		while(k < n - 1) {
			int last = n - 1;
			for (int j = n - 1; j > k; j--) {
				if (array[j - 1] > array[j]) {
					swap(array, j - 1, j);
					last = j;
					exchange++;
				}
				compare++;
			}
			k = last;
		}
		System.out.println("비교 : " + compare + "회");
		System.out.println("교환 : " + exchange + "회");
	}
	
	//양방향 버블 정렬 (== 칵테일 정렬, 셰이커 정렬)
	static void sort4(int[] array, int n) {
		int exchange = 0;
		int compare = 0;
		
		int i;
		int left = 0;
		int right = n - 1;
		int last = right;
		
		while(left < right) {
			for (i = right; i > left; i--) {
				if (array[i - 1] > array[i]) {
					swap(array, i - 1, i);
					last = i;
					exchange++;
				}
				compare++;
			}
			left = last;
			
			for (i = left; i < right; i++) {
				if (array[i] > array[i + 1]) {
					swap(array, i, i + 1);
					last = i;
					exchange++;
				}
				compare++;
			}
			right = last;
		}
		
		System.out.println("비교 : " + compare + "회");
		System.out.println("교환 : " + exchange + "회");
	}
	
	public static void main(String[] args) {
//		int[] array = {1, 3, 9, 4, 7, 8, 6};
		int[] array = {9, 1, 3, 4, 6, 7, 8};
		
//		sort(array, array.length);
//		sort2(array, array.length);
//		sort3(array, array.length);
		sort4(array, array.length);
		
		System.out.println(Arrays.toString(array));
		//결과 : 1, 2, 3, 5, 6, 7
	}
}
