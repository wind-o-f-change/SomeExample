package com.example.someexample.sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PSP {

  public static void main(String[] args) throws IOException {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());
      recursivePsp(n, n, "");
    }
  }

  static void recursivePsp(int left, int right, String prefix) {
    if (left == 0 && right == 0) {
      System.out.println(prefix);
      return;
    }
    if (left > 0) {
      recursivePsp(left - 1, right, prefix + "(");
    }
    if (right > left) {
      recursivePsp(left, right - 1, prefix + ")");
    }
  }
}
