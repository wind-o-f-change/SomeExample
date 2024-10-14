package com.example.someexample.sprint1;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://contest.yandex.ru/contest/22450/run-report/119417910/
public class NearestZero {

  public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int count = parseInt(reader.readLine());
      System.out.println(countingNearestHouses(reader.readLine(), count));
    }
  }

  private static String countingNearestHouses(String data, int count) {
    if (count == 1) {
      return "0";
    }
    StringTokenizer tokenizer = new StringTokenizer(data, " ");

    int counter = -count;
    int[] result = new int[count];
    for (int i = 0; i < count; i++) {
      int val = parseInt(tokenizer.nextToken());
      if (val == 0) {
        counter = i;
      } else {
        result[i] = i - counter;
      }
    }
    counter = count * 2;
    for (int i = count - 1; i >= 0; i--) {
      int val = result[i];
      if (val == 0) {
        counter = i;
      } else {
        result[i] = Math.min(val, Math.abs(counter - i));
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < count - 1; i++) {
      sb.append(result[i]).append(' ');
    }
    sb.append(result[count - 1]);
    return sb.toString();
  }
}
