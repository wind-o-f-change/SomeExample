package com.example.someexample.sprint5.final_tasks.A;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.stream.Stream;

/*
 * -- Принцип алгоритма --
 *  1. Построение максимальной кучи (Max-Heap) из исходного массива.
 *  2. Итеративное извлечение максимального элемента и перестройка оставшейся кучи.
 *
 * -- Временная и пространственная сложность --
 * Временная сложность:
 *  - Построение кучи: O(n), где n — размер массива.
 *  - Перестройка кучи для каждого извлечения: O(log n), итераций n.
 * Итоговая временная сложность: O(n log n).
 *
 * Пространственная сложность:
 *  - Основное использование памяти для входного массива участников (на месте).
 * Итоговая пространственная сложность: O(1).
 *
 * Sptint 5 final A
 * Задача: https://contest.yandex.ru/contest/24810/problems/A/
 * Отчет: https://contest.yandex.ru/contest/24810/run-report/131438387/
 */
public class Solution {

  public static void main(String[] args) throws IOException {
    Participant[] participants = getParticipants();

    heapSort(participants);

    Stream.of(participants)
        .map(p -> p.login)
        .reduce((x, y) -> x + "\n" + y)
        .ifPresent(System.out::println);
  }

  private static Participant[] getParticipants() throws IOException {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      return br.lines()
          .limit(parseInt(br.readLine()))
          .map(Participant::new)
          .toArray(Participant[]::new);
    }
  }

  static void heapSort(Participant[] participants) {
    int n = participants.length;

    for (int i = n / 2 - 1; i >= 0; i--) {
      shiftDown(participants, i, n);
    }

    for (int i = n - 1; i >= 0; i--) {
      swap(participants, 0, i);
      shiftDown(participants, 0, i);
    }
  }

  static void shiftDown(Participant[] participants, int idx, int size) {
    boolean needsShift = true;
    while (needsShift) {
      int largest = idx;
      int left = 2 * idx + 1;
      int right = 2 * idx + 2;

      if (left < size && participants[left].compareTo(participants[largest]) < 0) {
        largest = left;
      }

      if (right < size && participants[right].compareTo(participants[largest]) < 0) {
        largest = right;
      }

      if (largest != idx) {
        swap(participants, idx, largest);
        idx = largest;
      } else {
        needsShift = false;
      }
    }
  }

  static void swap(Participant[] participant, int idx, int largest) {
    Participant temp = participant[idx];
    participant[idx] = participant[largest];
    participant[largest] = temp;
  }
}

class Participant implements Comparable<Participant> {
  String login;
  int tasks;
  int penalty;

  Participant(String line) {
    String[] params = line.split(" ");
    this.login = params[0];
    this.tasks = parseInt(params[1]);
    this.penalty = parseInt(params[2]);
  }

  @Override
  public int compareTo(Participant p) {
    Comparator<Participant> c =
        Comparator.comparingInt((Participant p1) -> -p1.tasks)
            .thenComparingInt((Participant p1) -> p1.penalty)
            .thenComparing((Participant p1) -> p1.login);
    return c.compare(this, p);
  }
}
