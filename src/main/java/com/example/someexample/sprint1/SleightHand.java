package com.example.someexample.sprint1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;

// https://contest.yandex.ru/contest/22450/run-report/119713162/
public class SleightHand {

  public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int count = parseInt(reader.readLine()) * 2;
      System.out.println(countingSleightPoints(reader, count));
    }
  }

  private static Integer countingSleightPoints(BufferedReader reader, int count) throws IOException{
    Map<Integer, Integer> num2count = new HashMap<>();
    for (int i = 0; i < 4; i++) {
      char[] row = reader.readLine().toCharArray();
      for (char ch : row) {
        if (Character.isDigit(ch)) {
          int num = Character.getNumericValue(ch);
          num2count.put(num, num2count.getOrDefault(num, 0) + 1);
        }
      }
    }
    int result = 0;
    for (int value : num2count.values()) {
      if (value <= count) {
        result++;
      }
    }
    return result;
  }
}
