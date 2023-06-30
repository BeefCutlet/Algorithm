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
	
	public static void main(String[] args) {
		int[] array = {5, 2, 6, 1, 7, 3};
		sort(array);
		System.out.println(Arrays.toString(array));
	}
}
