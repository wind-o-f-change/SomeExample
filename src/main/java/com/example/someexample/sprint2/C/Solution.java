package com.example.someexample.sprint2.C;

// <template>
class Node<V> {
  public V value;
  public Node<V> next;

  public Node(V value, Node<V> next) {
    this.value = value;
    this.next = next;
  }
}

// <template>

public class Solution {
  public static void main(String[] args){
    test();
  }
  private static void test() {
    Node<String> node3 = new Node<>("3node3", null);
    Node<String> node2 = new Node<>("node2", node3);
    Node<String> node1 = new Node<>("node1", node2);
    Node<String> node0 = new Node<>("node0", node1);

    Node<String> newHead = solution(node0, 3);

    System.out.println(newHead.value);
    while (newHead.next != null) {
      newHead = newHead.next;
      System.out.println(newHead.value);
    }
  }
  public static Node<String> solution(Node<String> head, int idx) {
    if (idx == 0) {
      return head.next;
    }
    int count = 0;
    Node<String> previous = null;
    Node<String> current = head;
    while (count < idx) {
      previous = current;
      current = current.next;
      count++;
    }
    previous.next = current.next;
    return head;
  }
}
/*public static void main(String[] args){
    test();
  }
  private static void test() {
    Node<String> node3 = new Node<>("3node3", null);
    Node<String> node2 = new Node<>("node2", node3);
    Node<String> node1 = new Node<>("node1", node2);
    Node<String> node0 = new Node<>("node0", node1);

    Node<String> newHead = solution(node0, 2); newHead = node0;

    System.out.println(newHead.value);
    while (newHead.next != null) {
      newHead = newHead.next;
      System.out.println(newHead.value);
    }
  }*/