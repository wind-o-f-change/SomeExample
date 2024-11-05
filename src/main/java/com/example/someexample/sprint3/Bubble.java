package com.example.someexample.sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Bubble {
  public static void main(String[] args) throws IOException {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());
      int[] array = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

      bubbleSort(array);
    }
  }

  public static void bubbleSort(int[] arr) {
    boolean changed;
    for (int i = 0; i < arr.length; i++) {
      changed = false;

      for (int j = 0; j < arr.length - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          changed = true;
        }
      }

      if (changed || (!changed && i < 1)) {
        printArray(arr);
      }
      if (!changed) {
        break;
      }
    }
  }

  public static void printArray(int[] arr) {
    System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", ""));
  }
}