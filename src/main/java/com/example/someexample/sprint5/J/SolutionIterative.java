package com.example.someexample.sprint5.J;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionIterative{
  public static Node insert(Node root, int key) {
    // “ヽ(´▽｀)ノ”

    Node curr = null;
    Node next = root;

    while(next != null) {
      curr = next;
      if (key < curr.getValue()) {
        next = curr.getLeft();
      } else {
        next = curr.getRight();
      }
    }
    if (key < curr.getValue()) {
      curr.setLeft(new Node(null, null, key));
    } else {
      curr.setRight(new Node(null, null, key));
    }

    return root;
  }



  // <template>
  private static class Node {
    private int value;
    private Node left;
    private Node right;

    Node(Node left, Node right, int value) {
      this.left = left;
      this.right = right;
      this.value = value;
    }

    public int getValue() {
      return value;
    }

    public Node getRight() {
      return right;
    }

    public void setRight(Node right) {
      this.right = right;
    }

    public Node getLeft() {
      return left;
    }

    public void setLeft(Node left) {
      this.left = left;
    }

    public void setValue(int value) {
      this.value = value;
    }
  }

  // <template>

  public static void main(String[] args) {
    test();
  }

  private static void test() {
    Node node1 = new Node(null, null, 7);
    Node node2 = new Node(node1, null, 8);
    Node node3 = new Node(null, node2, 7);
    Node newHead = insert(node3, 6);
    assertTrue(newHead == node3);
    assertTrue(newHead.getLeft().getValue() == 6);
  }
}
