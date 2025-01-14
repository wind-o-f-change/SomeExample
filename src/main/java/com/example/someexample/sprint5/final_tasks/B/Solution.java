package com.example.someexample.sprint5.final_tasks.B;

import org.junit.jupiter.api.Assertions;

// <template>
class Node {
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

public class Solution {

  public static Node remove(Node root, int key) {

    if (key < root.getValue()) {
      root.setLeft(remove(root.getLeft(), key));
    } else if (key > root.getValue()) {
      root.setRight(remove(root.getRight(), key));
    } else {

      if (root.getLeft() == null && root.getRight() == null) {
        return null;
      } else if (root.getLeft() == null) {
        return root.getRight();
      } else if (root.getRight() == null) {
        return root.getLeft();
      } else {
        Node minNode = findMin(root.getRight());
        root.setValue(minNode.getValue());
        root.setRight(remove(root.getRight(), minNode.getValue()));
      }
    }
    return root;
  }

  static Node findMin(Node node) {
    if (node == null) {
      return null;
    }
    while (node.getLeft() != null) {
      node = node.getLeft();
    }
    return node;
  }


  public static void main(String[] args) {
    test();
  }

  public static void test() {
    Node node1 = new Node(null, null, 2);
    Node node2 = new Node(node1, null, 3);
    Node node3 = new Node(null, node2, 1);
    Node node4 = new Node(null, null, 6);
    Node node5 = new Node(node4, null, 8);
    Node node6 = new Node(node5, null, 10);
    Node node7 = new Node(node3, node6, 5);
    Node newHead = remove(node7, 10);

    Assertions.assertEquals(5, newHead.getValue());
    Assertions.assertSame(newHead.getRight(), node5);
    Assertions.assertEquals(8, newHead.getRight().getValue());
  }
}
