package com.example.someexample.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J {

  private static void factorize(int n) {
    // Ваше решение
    while (n % 2 == 0) {
      System.out.print(2 + " ");
      n /= 2;
    }
    for (long i = 3; i * i <= n; i += 2) {
      while (n % i == 0) {
        System.out.print(i + " ");
        n /= i;
      }
    }
    if (n > 1) {
      System.out.print(n);
    }
  }

  public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(reader.readLine());
      factorize(n);
    }
  }
}
