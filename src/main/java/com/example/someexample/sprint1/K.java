package com.example.someexample.sprint1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class K {

  private static List<Integer> getSum(List<Integer> nums, int k) {
    // Ваше решение
    int carry = 0;
    var result = new ArrayList<Integer>();
    for (int i = nums.size() - 1; k > 0 || i >= 0; i--) {
      int current = k % 10;
      int num = i >= 0 ? nums.get(i) : 0;
      int sum = num + current + carry;
      carry = sum / 10;
      k /= 10;
      result.add(sum % 10);
    }
    if (carry > 0) {
      result.add(carry);
    }
    return result;
  }

  public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int numberLength = parseInt(reader.readLine());
      List<Integer> numberList = readList(reader);
      int k = parseInt(reader.readLine());
      List<Integer> sum = getSum(numberList, k);
      for (int i = sum.size() - 1; i >= 0; i--) {
        writer.write(sum.get(i) + " ");
      }
    }
  }

  private static List<Integer> readList(BufferedReader reader) throws IOException {
    StringTokenizer st = new StringTokenizer(reader.readLine());
    List<Integer> numberList = new ArrayList<Integer>();
    while (st.hasMoreTokens()) {
      numberList.add(parseInt(st.nextToken()));
    }
    return numberList;
  }
}