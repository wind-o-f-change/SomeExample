package com.example.someexample.sprint5.I;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://contest.yandex.ru/contest/24809/problems/I/
public class CountBST {

  public static void main(String[] args) throws IOException {
    int n = getCount();
    System.out.println(calculateAmount(n));
  }

  private static int calculateAmount(int nodesCnt) {
    int[] arr = new int[nodesCnt + 1];
    arr[0] = 1;
    arr[1] = 1;

    for (int currCnt = 2; currCnt <= nodesCnt; currCnt++) {
      int summ = 0;

      for (int currNodeVal = 1; currNodeVal <= currCnt; currNodeVal++) {

        int left = currNodeVal - 1;
        int right = currCnt - currNodeVal;
        summ += arr[left] * arr[right];
      }
      arr[currCnt] = summ;
    }

    return arr[nodesCnt];
  }

  private static int getCount() throws IOException {
    try (var br = new BufferedReader(new InputStreamReader(System.in))) {
      return Integer.parseInt(br.readLine());
    }
  }
}
