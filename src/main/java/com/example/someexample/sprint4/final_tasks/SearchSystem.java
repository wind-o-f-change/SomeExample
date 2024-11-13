package com.example.someexample.sprint4.final_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * -- Принцип алгоритма --
 *  Задача решена при помощи построения реверсивных индексов во время считывания первого набора данных.
 *  Т.е. от слова к номеру документа до количества его вхождений в сам документ.
 *
 *  Далее считывается второй набор данных. Для экономии времени поиск осучествляется во время чтения этих данных.
 *
 * -- Временная и пространственная сложность --
 * Временная сложность:
 *  На однократное построение самих реверсивных индексов O(n*m*l), где n - кол-во док-ов, m - кол-во слов,
 *  а l - длина слов
 *  На поиск числа вхождений O(n*m(k + k log k)), где n - кол-во поисковых запросов, m - кол-во искомых слов,
 *  y - кол-во документов, а O(k log k) уходит на сортировку для выдачи топ-5, где k - кол-во док-тов
 *
 * Пространственная сложность:
 *  На построение реверсивных индексов O(n*m*l), где n - кол-во уникальных слов,
 *  m - кол-во документов в которых оно присутствует, а l - длина строки
 *  На сбор данных для результата: O(n) - кол-во поисковых запросов
 *
 * Sptint 4 final A
 * Задача: https://contest.yandex.ru/contest/24414/problems/A/?success=124813388#51450/2021_01_14/vpped1t2Rn
 * Отчет: https://contest.yandex.ru/contest/24414/run-report/124813388/
 */
class SearchSystem {

  public static void main(String[] args) throws IOException {
    try (var br = new BufferedReader(new InputStreamReader(System.in))) {
      var reversedIdexes = reversedIdexes(br);
      printAllTopFive(br, reversedIdexes);
    }
  }


  private static Map<String, Map<Integer, Integer>> reversedIdexes(BufferedReader br)
          throws IOException {
    int n = Integer.parseInt(br.readLine());
    Map<String, Map<Integer, Integer>> wordMapDocIdx2Count = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String[] words = br.readLine().split("\\s");
      for (String word : words) {
        wordMapDocIdx2Count.computeIfAbsent(word, k -> new HashMap<>()).merge(i, 1, Integer::sum);
      }
    }
    return wordMapDocIdx2Count;
  }

  private static void printAllTopFive(
      BufferedReader br, Map<String, Map<Integer, Integer>> documents) throws IOException {
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      var queryWords = Arrays.stream(br.readLine().split("\\s")).collect(Collectors.toSet());
      var relationsIdx2Sum = getDocIdx2Sum(queryWords, documents);
      appendTop5Relations(relationsIdx2Sum, sb);
    }
  }

  private static Map<Integer, Integer> getDocIdx2Sum(
      Set<String> queryWords, Map<String, Map<Integer, Integer>> documents) {
    Map<Integer, Integer> idx2Sum = new HashMap<>();

    for (String word : queryWords) {
      if (!documents.containsKey(word)) {
        continue;
      }
      var idxMap = documents.get(word);
      for (var entry : idxMap.entrySet()) {
        idx2Sum.merge(entry.getKey(), entry.getValue(), Integer::sum);
      }
    }
    return idx2Sum;
  }

  private static void appendTop5Relations(Map<Integer, Integer> relations, StringBuilder sb) {
    relations.entrySet().stream()
            .sorted(((Comparator<Entry<Integer, Integer>>)
                (e1, e2) -> Integer.compare(e2.getValue(), e1.getValue())).thenComparingInt(Entry::getKey))
            .limit(5)
            .forEach(e -> sb.append(e.getKey() + 1).append(" "));
    sb.append('\n');
  }
}
