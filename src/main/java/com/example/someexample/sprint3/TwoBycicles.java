package com.example.someexample.sprint3;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class TwoBycicles {
  public static void main(String[] args) throws IOException {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = parseInt(br.readLine());
      int[] amounts = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      int price = parseInt(br.readLine());

      printDaysOfPurshase(price, amounts);
    }
  }

  private static void printDaysOfPurshase(int price, int[] amounts) {
    int first = searchDay(price, amounts, 0, amounts.length);
    int second = searchDay(price * 2, amounts, 0, amounts.length);
    System.out.printf("%s %s", first, second);
  }

  private static int searchDay(int toSearch, int[] amounts, int start, int end) {
    if (start >= end) {
      return start < amounts.length && amounts[start] >= toSearch ? ++start : -1;
    }
    int mid = (start + end) / 2;
    if (amounts[mid] >= toSearch) {
      return searchDay(toSearch, amounts, start, mid);
    }
    return searchDay(toSearch, amounts, ++mid, end);
  }
}
