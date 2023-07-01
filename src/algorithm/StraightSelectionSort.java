package algorithm;

import java.util.Arrays;

public class StraightSelectionSort {

	static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	static void sort(int[] array, int n) {
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (array[min] > array[j]) {
					min = j;
				}
			}
			swap(array, i, min);
		}
	}
	
	public static void main(String[] args) {
		int[] array = {9, 1, 3, 4, 6, 7, 8};
		sort(array, array.length);
		System.out.println(Arrays.toString(array));
		//결과 : 1, 3, 4, 6, 7, 8, 9
	}
}
