package com.example.someexample.sprint2.F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// https://contest.yandex.ru/contest/22779/problems/
public class StackMax {
  private static List<Integer> stack = new ArrayList<>();
  Deque<Integer> maxStack = new ArrayDeque<>();
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());
      for (int i = 0; i < n; i++) {
        String query = br.readLine();
        if (query.contains("push")) {
          int number = Integer.parseInt(query.split(" ")[1]);
          stack.add(number);
        } else if (query.contains("pop")) {
          if (stack.isEmpty()) {
            System.out.println("error");
          } else {
            stack.remove(stack.size() - 1);
          }
        } else if (query.contains("get_max")) {
          stack.stream().max(Integer::compare)
                  .ifPresentOrElse(System.out::println, () -> System.out.println("None"));
        }
      }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
  }
}
