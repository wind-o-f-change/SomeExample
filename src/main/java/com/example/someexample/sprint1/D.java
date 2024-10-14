package com.example.someexample.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class D {

  private static int getWeatherRandomness(List<Integer> temperatures) {
    // Ваше решение
    int days = temperatures.size();
    if (days == 1) {
      return 1;
    }
    int count = 0;
    if (temperatures.get(0) > temperatures.get(1)) {
      count++;
    }
    for(int i = 1; i < days-1; i++) {
      if (temperatures.get(i-1) < temperatures.get(i)
          && temperatures.get(i) > temperatures.get(i+1)) {
        count++;
      }
    }

    if (temperatures.get(days-1) > temperatures.get(days-2)) {
      count++;
    }
    return count;
  }

  public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int numberOfDays = readInt(reader);
      List<Integer> temperatures = readList(reader);
      int chaosNumber = getWeatherRandomness(temperatures);
      System.out.println(chaosNumber);
    }
  }

  private static int readInt(BufferedReader reader) throws IOException {
    return Integer.parseInt(reader.readLine());
  }

  private static List<Integer> readList(BufferedReader reader) throws IOException {
    return Arrays.stream(reader.readLine().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
  }
}
