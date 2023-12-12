package algorithm.sort;

import java.util.Arrays;

public class StraightInsertionSort {
	
	static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	static void sort(int[] array, int n) {
		for (int i = 1; i < n; i++) {
			int j;
			int temp = array[i];
			for (j = i; j > 0 && array[j - 1] > temp; j--) {
				array[j] = array[j - 1];
			}
			array[j] = temp;
		}
	}

	public static void main(String[] args) {
		int[] array = {9, 1, 3, 4, 6, 7, 8};
		sort(array, array.length);
		System.out.println(Arrays.toString(array));
		//결과 : 1, 3, 4, 6, 7, 8, 9
	}
}
