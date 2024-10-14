package com.example.someexample.sprint2.E;

import java.util.ArrayList;
import java.util.List;

// <template>
class Node<V> {
  public V value;
  public Node<V> next;
  public Node<V> prev;

  public Node(V value, Node<V> next, Node<V> prev) {
    this.value = value;
    this.next = next;
    this.prev = prev;
  }
}

// <template>

public class Solution {
  public static Node<String> solution(Node<String> head) {
    List<Integer> stack = new ArrayList<>();
    stack.stream().max(Integer::compareTo)
        .ifPresentOrElse(System.out::println, () -> System.out.println("None"));
    var current = head;
    while (current.next != null) {
      var prev = current.prev;
      var next = current.next;
      current.prev = next;
      current.next = prev;
      current = next;
    }
    current.next = current.prev;
    current.prev =  null;
    return current;
  }

  public static void main(String[] args){
    test();
  }
  private static void test() {
    Node<String> node3 = new Node<>("node3", null, null);
    Node<String> node2 = new Node<>("node2", node3, null);
    Node<String> node1 = new Node<>("node1", node2, null);
    Node<String> node0 = new Node<>("node0", node1, null);
    node1.prev = node0;
    node2.prev = node1;
    node3.prev = node2;
    Node<String> newNode = solution(node0);
    System.out.println(newNode.value);
    while (newNode.next != null) {
      newNode = newNode.next;
      System.out.println(newNode.value);
    }
    /* result is :*/
    assert newNode == node3;
    assert node3.next == node2;
    assert node2.next == node1;
    assert node2.prev == node3;
    assert node1.next == node0;
    assert node1.prev == node2;
    assert node0.prev == node1;
  }
}
