package com.example.someexample.sprint4;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

// Один тест не проходит. Неправильно.Пока на паузе
// GPT-4o
public class ManyGoSha {
  public static void main(String[] args) throws IOException {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      // Считывание входных данных
      String[] firstLine = br.readLine().split(" ");
      int n = Integer.parseInt(firstLine[0]);
      int k = Integer.parseInt(firstLine[1]);
      String s = br.readLine();

      // Поиск индексов подходящих подстрок
      List<Integer> result = findSubstrings(n, k, s);

      // Вывод результата
      if (!result.isEmpty()) {
        System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(" ")));
      }
    }
  }

  private static List<Integer> findSubstrings(int n, int k, String s) {
    int L = s.length();
    Map<Long, Integer> substringCount = new HashMap<>();
    Map<Long, Integer> firstOccurrence = new HashMap<>();
    final int base = 31; // Базовое значение для полиномиального хэширования
    final int mod = 1_000_000_007; // Модуль для предотвращения переполнения

    long hash = 0; // Текущий хэш окна
    long power = 1; // base^(n-1)

    // Вычисление начального хэша для первой подстроки
    for (int i = 0; i < n; i++) {
      hash = (hash * base + (s.charAt(i) - 'a' + 1)) % mod;
      if (i < n - 1) {
        power = (power * base) % mod;
      }
    }

    // Обработка всех подстрок
    for (int i = 0; i <= L - n; i++) {
      // Увеличиваем счётчик хэша
      substringCount.put(hash, substringCount.getOrDefault(hash, 0) + 1);

      // Сохраняем индекс первого появления подстроки
      if (!firstOccurrence.containsKey(hash)) {
        firstOccurrence.put(hash, i);
      }

      // Обновляем хэш для следующего окна
      if (i + n < L) {
        hash = (hash - (s.charAt(i) - 'a' + 1) * power % mod + mod) % mod;
        hash = (hash * base + (s.charAt(i + n) - 'a' + 1)) % mod;
      }
    }

    // Формируем список индексов для подстрок, встречающихся >= k раз
    List<Integer> result = new ArrayList<>();
    for (Map.Entry<Long, Integer> entry : substringCount.entrySet()) {
      if (entry.getValue() >= k) {
        result.add(firstOccurrence.get(entry.getKey()));
      }
    }

    return result;
  }
}
