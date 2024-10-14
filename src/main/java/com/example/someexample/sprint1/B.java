package com.example.someexample.sprint1;

import java.util.Scanner;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean first = isEven(sc.nextInt());
    boolean second = isEven(sc.nextInt());
    boolean third = isEven(sc.nextInt());
    boolean result = first == second && first == third;

    System.out.println(result ? "WIN" : "FAIL");
  }

  private static boolean isEven(int num) {
    return num % 2 == 0;
  }
}
