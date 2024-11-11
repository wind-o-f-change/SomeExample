package com.example.someexample.sprint3;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;

public class FlowerBeds {
  public static void main(String[] args) throws IOException {
    var intervals = readIntervals();
    printMergedIntervals(intervals);
  }

  private static List<int[]> readIntervals() throws IOException {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = parseInt(br.readLine());
      return br.lines()
              .limit(n)
              .map(str -> str.split(" "))
              .map(strings -> new int[]{parseInt(strings[0]), parseInt(strings[1])})
              .sorted(
                      Comparator.comparingInt((int[] ints) -> ints[0]).thenComparingInt(ints -> ints[1]))
              .toList();
    }
  }

  private static void printMergedIntervals(List<int[]> intervals) {
    StringBuilder sb = new StringBuilder();

    int[] current = intervals.get(0);
    for (int i = 1; i < intervals.size(); i++) {
      int[] next = intervals.get(i);
      if (current[1] >= next[0]) {
        current[1] = Math.max(current[1], next[1]);
      } else {
        addMerged(sb, current);
        current = next;
      }
    }
    addMerged(sb, current);

    System.out.print(sb.toString());
  }

  private static void addMerged(StringBuilder sb, int[] current){
    sb.append(current[0]).append(' ').append(current[1]).append('\n');
  }
}