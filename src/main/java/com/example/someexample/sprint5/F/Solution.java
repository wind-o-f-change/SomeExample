package com.example.someexample.sprint5.F;

// https://contest.yandex.ru/contest/24809/problems/F/
public class Solution {
  public static int treeSolution(Node head) {
    // Your code
    // “ヽ(´▽｀)ノ”
    if (head == null) {
      return 0;
    }

    return Math.max(treeSolution(head.left), treeSolution(head.right)) + 1;
  }

  private static void test() {
    Node node1 = new Node(1, null, null);
    Node node2 = new Node(4, null, null);
    Node node3 = new Node(3, node1, node2);
    Node node4 = new Node(8, null, null);
    Node node5 = new Node(5, node3, node4);
    assert treeSolution(node5) == 3;
  }

  // <template>

  // <template>
  private static class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }

    Node(int value, Node left, Node right) {
      this.value = value;
      this.left = left;
      this.right = right;
    }
  }
}
