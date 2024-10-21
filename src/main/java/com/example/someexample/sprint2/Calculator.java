package com.example.someexample.sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

// Задача https://contest.yandex.ru/contest/22781/problems/B/
// Проверка https://contest.yandex.ru/contest/22781/run-report/121953089/

public class Calculator {

  public static void main(String[] args) throws IOException {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      String[] tokens = br.lines().findFirst().orElse("").split(" ");
      calculate(tokens);
    }
  }

  private static void calculate(String[] tokens) {
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    for (String token : tokens) {
      try {
        int value = Integer.parseInt(token);
        stack.push(value);
      } catch (NumberFormatException e) {
        int b = stack.pop();
        int a = stack.pop();

        switch (token) {
          case "+" -> stack.push(a + b);
          case "-" -> stack.push(a - b);
          case "*" -> stack.push(a * b);
          case "/" -> stack.push((int) Math.floor((double) a / b));
          default -> throw new IllegalArgumentException("Неподдерживаемый оператор: " + token);
        }
      }
    }
    System.out.println(stack.pop());
  }
}
