package com.example.someexample.sprint2.B;

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
  public static void solution(Node<String> head) {
    var sb = new StringBuilder(head.value);
    var next = head.next;
    while (next != null) {
      sb.append('\n').append(next.value);
      next = next.next;
    }
    System.out.println(sb.toString());
  }
}
