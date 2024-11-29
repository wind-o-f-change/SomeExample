package com.example.someexample.sprint5.E.recursive;

public class Solution {

  public static boolean treeSolution(Node head) {
    // Your code
    // “ヽ(´▽｀)ノ”
    return isBinThree(head, null, null);
  }

  static boolean isBinThree(Node root, Node min, Node max) {
    if (root == null) {
      return true;
    }
    if (min != null && root.value <= min.value) {
      return false;
    }
    if (max != null && root.value >= max.value) {
      return false;
    }
    return isBinThree(root.left, min, root) && isBinThree(root.right, root, max);
  }

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

  // <template>

  private static void test() {
    Node node1 = new Node(1, null, null);
    Node node2 = new Node(4, null, null);
    Node node3 = new Node(3, node1, node2);
    Node node4 = new Node(8, null, null);
    Node node5 = new Node(5, node3, node4);
    assert treeSolution(node5);
    node2.value = 5;
    assert !treeSolution(node5);
  }
}
