package com.example.someexample.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L {

  private static char getExcessiveLetter(String s, String t) {
    char result = 0;
    for (char ch : s.toCharArray()) {
      result ^= ch;
    }
    for (char ch : t.toCharArray()) {
      result ^= ch;
    }
    return result;
  }

  public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      String s = reader.readLine();
      String t = reader.readLine();
      System.out.println(getExcessiveLetter(s, t));
    }
  }
}



