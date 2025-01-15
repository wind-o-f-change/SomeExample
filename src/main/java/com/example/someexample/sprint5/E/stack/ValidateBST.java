package com.example.someexample.sprint5.E.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateBST {
  public static boolean isValidBST(Node root) {
    if (root == null) return true;

    Deque<Node> stack = new ArrayDeque<>();
    Node current = root;
    Integer prev = null;

    while (!stack.isEmpty() || current != null) {
      // Спускаемся в левое поддерево
      while (current != null) {
        stack.push(current);
        current = current.left;
      }

      // Обрабатываем текущий узел
      current = stack.pop();
      int curr = current.val;
      if (prev != null && prev >= curr) {
        return false;
      }
      prev = curr;

      // Переходим в правое поддерево
      current = current.right;
    }

    return true;
  }

  public static void main(String[] args) {
    Node root = new Node(2);
    root.left = new Node(1);
    root.right = new Node(3);

    System.out.println(isValidBST(root)); // true

    Node invalidRoot = new Node(5);
    invalidRoot.left = new Node(1);
    invalidRoot.right = new Node(4);
    invalidRoot.right.left = new Node(3);
    invalidRoot.right.right = new Node(6);

    System.out.println(isValidBST(invalidRoot)); // false
  }
}

class Node {
  int val;
  Node left;
  Node right;

  Node(int val) {
    this.val = val;
    left = null;
    right = null;
  }

  @Override
  public String toString() {
    return "Node[val="
        + val
        + ", left="
        + (left == null ? "null" : left.val)
        + ", right="
        + (right == null ? "null" : right.val)
        + ']';
  }
}
