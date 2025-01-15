package com.example.someexample.sprint4;

import java.io.*;

// GPT-4o
// https://contest.yandex.ru/contest/23991/problems/H/
public class Substrings {
  public static int getMaxUniqueStringLen(String str) {
    int[] letterToPos = new int[256]; // Храним позиции символов (ASCII 256)
    int result = 0; // Максимальная длина уникальной подстроки
    int prev = 0; // Начало текущей уникальной подстроки

    for (int i = 0; i < str.length(); i++) {
      char currentChar = str.charAt(i);

      // Обновляем начало подстроки, чтобы не было повторений
      prev = Math.max(prev, letterToPos[currentChar]);

      // Сохраняем позицию текущего символа
      letterToPos[currentChar] = i + 1;

      // Обновляем максимальную длину
      result = Math.max(result, i + 1 - prev);
    }

    return result;
  }

  public static void main(String[] args) throws IOException {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      // Считывание входной строки
      String input = br.readLine();

      // Вычисление максимальной длины уникальной подстроки
      int maxLength = getMaxUniqueStringLen(input);

      // Вывод результата
      System.out.println(maxLength);
    }
  }
}
