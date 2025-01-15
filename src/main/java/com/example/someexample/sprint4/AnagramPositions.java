package com.example.someexample.sprint4;

import java.io.*;
import java.util.*;

// GPT-4o
// https://contest.yandex.ru/contest/23991/problems/I/
public class AnagramPositions {

  public static List<List<Integer>> getAnagramPositions(String[] words) {
    Map<String, List<Integer>> data = new HashMap<>();
    List<String> order = new ArrayList<>();

    // Формируем хэш-таблицу для группировки анаграмм
    for (int i = 0; i < words.length; i++) {
      char[] sortedWord = words[i].toCharArray();
      Arrays.sort(sortedWord);
      String key = new String(sortedWord);

      if (!data.containsKey(key)) {
        order.add(key);
        data.put(key, new ArrayList<>());
      }
      data.get(key).add(i);
    }

    // Формируем список позиций анаграмм
    List<List<Integer>> positions = new ArrayList<>();
    for (String key : order) {
      positions.add(data.get(key));
    }

    return positions;
  }

  public static void main(String[] args) throws IOException {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      // Считывание количества строк
      int n = Integer.parseInt(br.readLine());

      // Считывание всех строк
      String[] words = br.readLine().split(" ");

      // Получение позиций анаграмм
      List<List<Integer>> result = getAnagramPositions(words);

      // Вывод результата
      for (List<Integer> group : result) {
        for (int pos : group) {
          System.out.print(pos + " ");
        }
        System.out.println();
      }
    }
  }
}
