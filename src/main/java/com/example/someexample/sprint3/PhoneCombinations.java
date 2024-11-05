package com.example.someexample.sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PhoneCombinations {
  static final String[] DICTIONARY = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  public static void main(String[] args) throws IOException {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      char[] secquence = br.readLine().toCharArray();
      System.out.println(buildCombination(secquence, 0, new StringBuilder(), new StringBuilder()).toString().trim());
    }
  }


  public static StringBuilder buildCombination(
          char[] secquence, int num, StringBuilder combination, StringBuilder result) {
    if (secquence.length == num) {
      return result.append(combination).append(' ');
    }

    int n = secquence[num] - '2';

    for (char ch : DICTIONARY[n].toCharArray()) {
      StringBuilder branch = new StringBuilder(combination).append(ch);
      buildCombination(secquence, num + 1, branch, result);
    }
    return result;
  }
}
