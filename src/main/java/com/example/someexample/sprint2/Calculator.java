package com.example.someexample.sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/*
* -- Принцип алгоритма --
* Реализован согласно описанному в ТЗ к текущей задаче - используя стек,
* тесты контеста пройдены что и гарантирует его корректность.
* Реализованный в методе calculate алгоритм из ТЗ задачи:
* 1) Обработка входного символа:
*   Если на вход подан операнд, он помещается на вершину стека.
*   Если на вход подан знак операции, то эта операция выполняется над требуемым количеством значений,
*     взятых из стека в порядке добавления. Результат выполненной операции помещается на вершину стека.
* 2) Если входной набор символов обработан не полностью, перейти к шагу 1.
* 3) После полной обработки входного набора символов результат вычисления выражения находится в вершине стека.
*   Если в стеке осталось несколько чисел, то надо вывести только верхний элемент.
*
* Задача https://contest.yandex.ru/contest/22781/problems/B/
* Проверка https://contest.yandex.ru/contest/22781/run-report/121953089/
*
* -- Временная и пространственная сложность --
* Временная сложность: O(n) - тк мы проходимся по всем токенам(операндам и знакам операций) массива
* Пространственная сложность: O(n) - тк в худшем случае все числа попадут в стек
*
*
*   ArrayDeque выбран в качестве стека тк он не синхронизирован, что делает его более производительным
* для однопоточных приложений. ArrayDeque часто рекомендуется для использования в качестве стека из-за хорошей
* производительности и низкой потребности в памяти. LinkedList использует больше памяти, так как требует хранить
* ссылки на предыдущие и следующие элементы, а вставка в произвольную позицию не требуется.
* В Stack и ConcurrentLinkedDeque нет нужны тк в задача выполняется в одном потоке и соответственно
* они медленнее для такой реализации (https://www.baeldung.com/java-array-deque#overview)
*/
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
          default -> {}
        }
      }
    }
    System.out.println(stack.pop());
  }
}
