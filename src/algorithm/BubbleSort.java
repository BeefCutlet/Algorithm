package algorithm;

import java.util.Arrays;

public class BubbleSort {
	
	static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	static void sort(int[] array) {
		int length = array.length;
		for (int i = 0; i < length - 1; i++) {
			for (int j = length - 1; j > i; j--) {
				if (array[j - 1] > array[j]) {
					swap(array, j - 1, j);
				}
			}
		}
	}
	
	static void sort2(int[] array) {
		int length = array.length;
		for (int i = 0; i < length - 1; i++) {
			int count = 0;
			for (int j = length - 1; j > i; j--) {
				if (array[j - 1] > array[j]) {
					swap(array, j - 1, j);
					count++;
				}
			}
			if (count == 0) break;
		}
	}
	
	static void sort3(int[] array) {
		int length = array.length;
		int k = 0;
		while(k < length - 1) {
			int last = length - 1;
			for (int j = length - 1; j > k; j--) {
				if (array[j - 1] > array[j]) {
					swap(array, j - 1, j);
					last = j;
				}
			}
			k = last;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {5, 2, 6, 1, 7, 3};
//		sort(array);
//		sort2(array);
		sort3(array);
		System.out.println(Arrays.toString(array));
		//결과 : 1, 2, 3, 5, 6, 7
	}
}
