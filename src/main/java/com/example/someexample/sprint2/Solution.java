package com.example.someexample.sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Задача https://contest.yandex.ru/contest/22781/problems/A/?success=121936529#3484683/2020_05_25/sXAjV3Ufy3
// Проверка https://contest.yandex.ru/contest/22781/run-report/121936529/

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    Deque deque = new Deque(m);

    for (int i = 0; i < n; i++) {
      String command = br.readLine();
      if (command.startsWith("push_back")) {
        int value = Integer.parseInt(command.split(" ")[1]);
        deque.pushBack(value);
      } else if (command.startsWith("push_front")) {
        int value = Integer.parseInt(command.split(" ")[1]);
        deque.pushFront(value);
      } else if (command.equals("pop_front")) {
        deque.popFront();
      } else if (command.equals("pop_back")) {
        deque.popBack();
      }
    }
  }
}

class Deque {
  public static final String ERROR = "error";
  private Integer[] buffer;
  private int maxSize;
  private int head = 0;
  private int tail = 0;
  private int size = 0;

  public Deque(int maxSize) {
    this.maxSize = maxSize;
    this.buffer = new Integer[maxSize];
  }

  public void pushFront(int value) {
    if (size == maxSize) {
      System.out.println(ERROR);
    } else {
      head = (head - 1 + maxSize) % maxSize;
      buffer[head] = value;
      size++;
    }
  }

  public void pushBack(int value) {
    if (size == maxSize) {
      System.out.println(ERROR);
    } else {
      buffer[tail] = value;
      tail = (tail + 1) % maxSize;
      size++;
    }
  }

  public void popFront() {
    if (size == 0) {
      System.out.println(ERROR);
    } else {
      System.out.println(buffer[head]);
      head = (head + 1) % maxSize;
      size--;
    }
  }

  public void popBack() {
    if (size == 0) {
      System.out.println(ERROR);
    } else {
      tail = (tail - 1 + maxSize) % maxSize;
      System.out.println(buffer[tail]);
      size--;
    }
  }
}