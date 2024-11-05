package com.example.someexample.sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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

class Main {
  public static void main(String[] args) {
    List<Integer> array = new ArrayList<>();
    array.add(5);
    array.add(2);
    array.add(4);
    array.add(6);
    array.add(1);
    array.add(3);
    insertionSort(array);
  }

  public static void insertionSort(List<Integer> array) {
    for (int i = 1; i < array.size(); i++) {
      int item_to_insert = array.get(i);
      int j = i;
      while (j > 0 && item_to_insert < array.get(j - 1)) {
        array.set(j, array.get(j - 1));
        j--;
      }
      array.set(j, item_to_insert);
      System.out.printf("step %d, sorted %d elements: %s\n", i, i + 1, array.subList(0, i + 1));
    }
  }
}