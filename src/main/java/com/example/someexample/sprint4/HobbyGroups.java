package com.example.someexample.sprint4;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class HobbyGroups {
  public static void main(String[] args) throws IOException {
    String act = readHobbyGroups();
    System.out.println(act);
  }


  private static String readHobbyGroups() throws IOException {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = parseInt(br.readLine());
      return br.lines().limit(n).collect(Collectors.toCollection(LinkedHashSet::new))
          .stream().reduce((a, b) -> a + '\n' + b).orElse("");
    }
  }
}
