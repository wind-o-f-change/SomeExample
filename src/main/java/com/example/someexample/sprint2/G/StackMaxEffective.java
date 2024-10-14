package com.example.someexample.sprint2.G;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StackMaxEffective {
  private static List<Integer> stack = new ArrayList<>();
  private static Map<Integer, Integer> stack2max = new TreeMap<>((x, y) -> x.compareTo(y) * -1);

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      var n = br.readLine();
      while (br.ready()) {
        String query = br.readLine();
        if (query.contains("push")) {
          push(query);
        } else if (query.contains("pop")) {
          pop();
        } else if (query.contains("top")) {
          top();
        } else if (query.contains("get_max")) {
          getMax();
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static void push(String query){
    int number = Integer.parseInt(query.split(" ")[1]);
    stack.add(number);
    stack2max.put(number, stack2max.getOrDefault(number, 0) + 1);
    System.out.print("");
  }

  private static void getMax(){
    stack2max.keySet().stream().findFirst()
        .ifPresentOrElse(System.out::println, () -> System.out.println("None"));
  }

  private static void top(){
    if (stack.isEmpty()) {
      System.out.println("error");
    } else {
      System.out.println(stack.getLast());
    }
  }

  private static void pop(){
    if (stack.isEmpty()) {
      System.out.println("error");
    } else {
      int removed = stack.removeLast();
      int removedCount = stack2max.get(removed);
      if (removedCount < 2) {
        stack2max.remove(removed);
      } else {
        stack2max.put(removed, removedCount - 1);
      }
    }
  }
}
