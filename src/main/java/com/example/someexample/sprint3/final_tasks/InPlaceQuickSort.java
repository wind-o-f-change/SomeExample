package com.example.someexample.sprint3.final_tasks;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

/*
 * -- Принцип алгоритма --
 * Задача решена при помощи in-place quick sort описанной в ТЗ к задаче
 *
 * -- Временная и пространственная сложность --
 * Временная сложность: средняя O(n log n) / худшая O(n^2) (Стандартная для quick sort)
 * Пространственная сложность больше O(1) тк есть глубина рекурсии:
 *  средняя O(log n) - при удачном выборе опорного элемента
 *  худшая O(n) - при сортитированном массиве и выборе макс или мин значения
 *
 * Sptint 3 final B
 * Задача: https://contest.yandex.ru/contest/23815/problems/B/?success=124465781#3484683/2020_05_19/6LnxJCoO7C
 * Отчет: https://contest.yandex.ru/contest/23815/run-report/124465781/
 */
public class InPlaceQuickSort {

  public static void main(String[] args) throws IOException {
    var participants = readPersons();
    inPlaceQuickSort(participants, 0, participants.length - 1);
    printResult(participants);
  }

  private static void printResult(Participant[] participants){
    StringBuilder sb = new StringBuilder();
    for (var participant : participants) {
      sb.append(participant.name).append("\n");
    }
    System.out.print(sb.toString());
  }

  private static Participant[] readPersons() throws IOException {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = parseInt(br.readLine());
      return br.lines()
          .limit(n)
          .map(str -> str.split(" "))
          .map(fields -> new Participant(fields[0], parseInt(fields[1]), parseInt(fields[2])))
          .toArray(Participant[]::new);
    }
  }

  private static void inPlaceQuickSort(Participant[] participants, int left, int right) {
    int l = left;
    int r = right;
    var pivot = participants[right];

    while (l <= r) {
      while (pivot.compareTo(participants[l]) > 0) {
        l++;
      }
      while (pivot.compareTo(participants[r]) < 0) {
        r--;
      }
      if (l <= r) {
        var tmp = participants[l];
        participants[l] = participants[r];
        participants[r] = tmp;
        l++;
        r--;
      }
    }
    if (left >= right) {
      return;
    }
    inPlaceQuickSort(participants, left, r);
    inPlaceQuickSort(participants, l, right);
  }
}

class Participant implements Comparable<Participant> {
  String name;
  int task;
  int penalty;

  Participant(String name, int task, int penalty) {
    this.name = name;
    this.task = task;
    this.penalty = penalty;
  }

  public int compareTo(Participant participant) {
    Comparator<Participant> comparator =
        Comparator.comparingInt((Participant p) -> -p.task)
            .thenComparingInt((Participant p) -> p.penalty)
            .thenComparing((Participant p) -> p.name);

    return comparator.compare(this, participant);
  }
}
