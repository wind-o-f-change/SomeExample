package com.example.someexample.sprint5.E.traversal;

public class Solution {

  public static boolean treeSolution(Node head) {
    // Инициализируем переменные для отслеживания пределов и текущего узла
    Node current = head;
    Node prev = null;
    Node min = null, max = null;

    while (current != null) {
      if (current.left == null) {
        // Проверяем значение узла в пределах min и max
        if ((min != null && current.value <= min.value)
            || (max != null && current.value >= max.value)) {
          return false;
        }
        min = current; // Обновляем минимальный предел
        current = current.right; // Переходим к правому поддереву
      } else {
        // Ищем предшественника (предыдущий узел в порядке in-order)
        prev = current.left;
        while (prev.right != null && prev.right != current) {
          prev = prev.right;
        }

        if (prev.right == null) {
          // Создаем связь с текущим узлом
          prev.right = current;
          max = current; // Обновляем максимальный предел
          current = current.left;
        } else {
          // Убираем связь и проверяем значение узла
          prev.right = null;
          if ((min != null && current.value <= min.value)
              || (max != null && current.value >= max.value)) {
            return false;
          }
          min = current; // Обновляем минимальный предел
          current = current.right; // Переходим к правому поддереву
        }
      }
    }
    return true;
  }

  // Определение структуры узла дерева
  static class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
      this.value = value;
    }
  }

  // Пример использования
  public static void main(String[] args) {
    Node root = new Node(2);
    root.left = new Node(1);
    root.right = new Node(3);

    System.out.println(treeSolution(root)); // true

    Node invalidRoot = new Node(5);
    invalidRoot.left = new Node(1);
    invalidRoot.right = new Node(4);
    invalidRoot.right.left = new Node(3);
    invalidRoot.right.right = new Node(6);

    System.out.println(treeSolution(invalidRoot)); // false
  }
}
