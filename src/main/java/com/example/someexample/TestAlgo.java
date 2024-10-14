package com.example.someexample;

import java.util.Arrays;

public class TestAlgo {
  public static void main(String[] args) {
    boolean[] res = eratosthenesEffective(15);
    StringBuilder sb_f = new StringBuilder("false:\t");
    StringBuilder sb_t = new StringBuilder("true:\t");
    for (int i = 0; i < res.length; i++) {
      boolean re = res[i];
      if (re) sb_t.append(i).append('\t');
      else sb_f.append(i).append('\t');
    }
    System.out.println(sb_t + "\n");
    System.out.println(sb_f);
  }

  public static boolean[] eratosthenesEffective(int n) {
    boolean[] numbers = new boolean[n + 1];
    Arrays.fill(numbers, true);
    numbers[0] = false;
    numbers[1] = false;
    for (int num = 2; num < n; num++) {
      if (numbers[num]) {
        for (int j = num * num; j < n + 1; j = j + num) {
          numbers[j] = false;
        }
      }
    }
    return numbers;
  }
}
