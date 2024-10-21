package com.example.someexample.sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Supplier;

/*
 * -- Принцип действия --
 * Алгоритм использует дек с кольцевым буфером.
 * Для определения начала и конца используются указалели индекса head и tail.
 * Текущий размер буфера дека - size, а максимальный - maxSize.
 *
 * -- push --
 * При попытке добавления элемента в полный массив - реализована логика вывода "error"
 * При добавлении в начало(push_front) - значение индекса в указателе head перемещается левее
 * те head будет равен остаточному делению на maxSize суммы его(head) деинкремента и maxSize.
 *
 * Прибавление maxSize после деинкремента указателя индекса производится для избежания получения отрицательного
 * значения после вычитания индекса добавляется maxSize
 *
 * При добавлении в конец(push_back) - значение индекса в указателе tail перемещается правее при помощи инкримента
 * индекса и получаем остаток от деления на maxSize, затем сохраняется в массив по полученному индесу.
 *
 * -- pop --
 * При выводе элемента из дека он удаляется из буфера.
 * При попытке вывода/удаления элемента из пустого массива реализована логика вывода "error"
 *
 * При выводе перового элемента(pop_first) значение выводится по текущему значению индекса из указателя head,
 * затем head будет равен остаточному делению на maxSize его(head) инкремента
 *
 * При выводе последнего элемента(pop_back) значение выводится по текущему значению индекса из указателя tail,
 * затем tail будет равен остаточному делению на maxSize суммы его(tail) деинкремента и maxSize
 *
 *
 * -- Временная и пространственная сложность --
 * Временная сложность: Получение и добавление элемента происходит за O(1) тк нет необходимости сдвига элементов.
 *   Сдвиг реализован за счет изменения значения индекса в указателях head и tail.
 * Пространственная сложность: O(n) где n - maxSize
 *
 * Задача https://contest.yandex.ru/contest/22781/problems/A/?success=121936529#3484683/2020_05_25/sXAjV3Ufy3
 * Проверка https://contest.yandex.ru/contest/22781/run-report/122621796/
 */

public class DequeSolution {

  public static void main(String[] args) throws IOException {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      Deque deque = new Deque(m);

      for (int i = 0; i < n; i++) {
        String command = br.readLine();
        if (command.startsWith("push_back")) {
          int value = Integer.parseInt(command.split(" ")[1]);
          printPush(deque::pushBack, value);
        } else if (command.startsWith("push_front")) {
          int value = Integer.parseInt(command.split(" ")[1]);
          printPush(deque::pushFront, value);
        } else if (command.equals("pop_front")) {
          printPop(deque::popFront);
        } else if (command.equals("pop_back")) {
          printPop(deque::popBack);
        }
      }
    }
  }


  private static void printPush(Consumer<Integer> push, Integer toPush) {
    try {
      push.accept(toPush);
    } catch (NoSuchElementException ex) {
      System.out.println(ex.getMessage());
    }
  }

  private static void printPop(Supplier<Integer> pop) {
    try {
      System.out.println(pop.get());
    } catch (NoSuchElementException ex) {
      System.out.println(ex.getMessage());
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
      throw new NoSuchElementException(ERROR);
    }
    head = (head - 1 + maxSize) % maxSize;
    buffer[head] = value;
    size++;
  }

  public void pushBack(int value) {
    if (size == maxSize) {
      throw new NoSuchElementException(ERROR);
    }
    buffer[tail] = value;
    tail = (tail + 1) % maxSize;
    size++;
  }

  public Integer popFront() {
    if (size == 0) {
      throw new NoSuchElementException(ERROR);
    }
    var result = buffer[head];
    head = (head + 1) % maxSize;
    size--;
    return result;
  }

  public Integer popBack() {
    if (size == 0) {
      throw new NoSuchElementException(ERROR);
    }
    tail = (tail - 1 + maxSize) % maxSize;
    var result = buffer[tail];
    size--;
    return result;
  }
}
