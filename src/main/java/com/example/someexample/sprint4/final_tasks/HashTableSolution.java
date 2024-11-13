package com.example.someexample.sprint4.final_tasks;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

/*
 * -- Принцип алгоритма --
 *  Хеш-таблица реализована методом цепочек без поддержки расширения сразу
 *  максимального объема вводных данных из задачи.
 *  Объем увеличен до ближайшего простого значения для уменьшения коллизий при вычислении индекса бакета
 *
 * -- Временная и пространственная сложность --
 * Временная сложность операций O(1) как того и требует ТЗ
 *
 * Пространственная сложность:
 *  На построение реверсивных индексов O(n*m), где n - размер хеш-таблицы, m - кол-во коллизий
 *
 * Sptint 4 final B
 * Задача: https://contest.yandex.ru/contest/24414/problems/B/
 * Отчет: https://contest.yandex.ru/contest/24414/run-report/125225070/
 */
class HashTableSolution {

  public static void main(String[] args) throws IOException {
    var hashTable = new HashTable();

    try (var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int n = parseInt(br.readLine());
      br.lines().limit(n)
          .map(str -> str.split(" "))
          .map(doUserAction(hashTable))
          .filter(Objects::nonNull)
          .forEach(c -> {
            try {
              bw.write(c);
              bw.newLine();
            } catch (IOException e) {
              throw new RuntimeException(e);
            }
          });
    }
  }

  private static Function<String[], String> doUserAction(HashTable hashTable) {
    return input -> {
      try {
        switch (input[0]) {
          case "put" -> hashTable.put(parseInt(input[1]), parseInt(input[2]));
          case "get" -> {
            return String.valueOf(hashTable.get(parseInt(input[1])));
          }
          case "delete" -> {
            return String.valueOf(hashTable.delete(parseInt(input[1])));
          }
        }
      } catch (IllegalArgumentException e) {
        return e.getMessage();
      }
      return null;
    };
  }
}

class HashTable {
  LinkedList<Entry>[] table;

  public HashTable() {
    table = new LinkedList[10003];
  }

  public void put(int key, int value) {
    int backet = getBacket(key);
    if (table[backet] == null) {
      table[backet] = new LinkedList<>();
    }

    boolean found = false;
    var entries = table[backet];
    for (int i = 0; i < entries.size(); i++) {
      var entry = entries.get(i);
      if (entry.key == key) {
        entries.set(i, new Entry(key, value));
        found = true;
      }
    }
    if (!found) {
      table[backet].add(new Entry(key, value));
    }
  }

  public int get(int key) {
    int backet = getBacket(key);
    Optional<LinkedList<Entry>> entries = Optional.ofNullable(table[backet]);
    return entries.stream()
        .flatMap(Collection::stream)
        .filter(k -> k.key == key)
        .findFirst()
        .map(e -> e.value)
        .orElseThrow(() -> new IllegalArgumentException("None"));
  }

  public int delete(int key) {
    int backet = getBacket(key);
    if (table[backet] == null) {
      throw new IllegalArgumentException("None");
    }
    var entries = table[backet];
    for (int i = 0; i < entries.size(); i++) {
      if (entries.get(i).key == key) {
        return entries.remove(i).value;
      }
    }
    throw new IllegalArgumentException("None");
  }

  private int getBacket(int key) {
    return Math.abs(key) >>> (32 - Long.numberOfTrailingZeros(table.length)) % table.length;
  }
}

class Entry {
  int key;
  int value;

  Entry(int key, int value) {
    this.key = key;
    this.value = value;
  }
}
