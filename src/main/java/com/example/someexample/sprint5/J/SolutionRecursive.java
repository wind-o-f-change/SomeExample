package com.example.someexample.sprint5.J;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class SolutionRecursive {
  public static Node insert(Node root, int key) {
    // “ヽ(´▽｀)ノ”
    addNode(root, key);
    return root;
  }

  static void addNode(Node node, int key) {

    if (key < node.getValue()) {
      if (node.getLeft() == null) {
        node.setLeft(new Node(null, null, key));
      } else {
        addNode(node, key);
      }
    } else {
      if (node.getRight() == null) {
        node.setRight(new Node(null, null, key));
      } else {
        addNode(node, key);
      }
    }
  }

  public static void main(String[] args) {
    test();
  }

  // <template>

  private static void test() {
    Node node1 = new Node(null, null, 7);
    Node node2 = new Node(node1, null, 8);
    Node node3 = new Node(null, node2, 7);
    Node newHead = insert(node3, 6);
    assertSame(newHead, node3);
    assertEquals(6, newHead.getLeft().getValue());
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

    public void setValue(int value) {
      this.value = value;
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
  }
}
