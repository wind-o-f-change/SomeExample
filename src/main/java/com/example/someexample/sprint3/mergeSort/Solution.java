package com.example.someexample.sprint3.mergeSort;

import static java.util.Arrays.copyOfRange;

import java.util.Arrays;

public class Solution {
	public static int[] merge(int[] arr, int left, int mid, int right) {
		// Your code
		// “ヽ(´▽｀)ノ”
		int[] l_part = copyOfRange(arr, left, mid);
		int[] r_part = copyOfRange(arr, mid, right);

		int l = 0;
		int r = 0;
		int k = left;
		while(l < l_part.length && r < r_part.length) {
			if (l_part[l] <= r_part[r]) {
				arr[k] = l_part[l];
				l++;
			} else {
				arr[k] = r_part[r];
				r++;
			}
			k++;
		}

		while (l < l_part.length) {
			arr[k] = l_part[l];
			l++;
			k++;
		}

		while (r < r_part.length) {
			arr[k] = r_part[r];
			r++;
			k++;
		}
		return arr;
	}

	public static void merge_sort(int[] arr, int left, int right) {
		// Your code
		// “ヽ(´▽｀)ノ”
		if (right - left == 1) {
			return;
		}

		int mid = left + (right - left)/2;

		merge_sort(arr, left, mid);
		merge_sort(arr, mid, right);

		merge(arr, left, mid, right);

	}

  public static void main(String[] args) {
    int[] a = {1, 4, 9, 2, 10, 11};
    int[] b = merge(a, 0, 3, 6);
    int[] expected = {1, 2, 4, 9, 10, 11};
    System.out.println("\t\t--merge--\nexp " + Arrays.toString(expected) + ";\nact " + Arrays.toString(b));
    assert Arrays.equals(expected, b);
    int[] c = {1, 4, 2, 10, 1, 2};
    merge_sort(c, 0, 6);
    int[] expected2 = {1, 1, 2, 2, 4, 10};
    System.out.println("\n\t\t--merge_sort--\nexp " + Arrays.toString(expected2)+ ";\nact " + Arrays.toString(c));
    assert Arrays.equals(c, expected2);
  }
}
