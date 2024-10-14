package com.example.someexample.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class C {
  static int[][] matrix;

  public static void main(String[] args) throws IOException {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int h = Integer.parseInt(br.readLine());
      int w = Integer.parseInt(br.readLine());

      printNeighbors(h, w, br);
    }
  }

  private static void printNeighbors(int h, int w, BufferedReader br) throws IOException {
    matrix = readMatrix(h, w, br);
    int x = Integer.parseInt(br.readLine());
    int y = Integer.parseInt(br.readLine());

    List<Integer> neighbors = new ArrayList<>();
    if (x == 0) {
      addNeighbor(x + 1, y, neighbors);
    } else if (x == h - 1) {
      addNeighbor(x - 1, y, neighbors);
    } else {
      addNeighbor(x - 1, y, neighbors);
      addNeighbor(x + 1, y, neighbors);
    }

    if (y == 0) {
      addNeighbor(x, y + 1, neighbors);
    } else if (y == w - 1) {
      addNeighbor(x, y - 1, neighbors);
    } else {
      addNeighbor(x, y - 1, neighbors);
      addNeighbor(x, y + 1, neighbors);
    }

    StringBuilder sb = new StringBuilder();
    neighbors.forEach(num -> sb.append(num).append(" "));
    StringTokenizer tokinizer = new StringTokenizer(" as d");
    int count = 0;
    int wordLength = 0;
    String result = null;

    while (tokinizer.hasMoreTokens()) {
      count++;
      String word = tokinizer.nextToken();
      if (wordLength < word.length()) {
        result = word;
        wordLength = word.length();
      }
    }

    System.out.print(sb);
  }

  private static void addNeighbor(int x, int y, List<Integer> neighbors) {
    try {
      neighbors.add(matrix[x][y]);
    } catch (Exception e) {
    }
  }

  private static int[][] readMatrix(int h, int w, BufferedReader br) throws IOException {
    int[][] matrix = new int[h][w];

    for (int i = 0; i < h; i++) {
      String str = br.readLine();
      StringTokenizer st = new StringTokenizer(str);
      for (int j = 0; j < w; j++) {
        String s = st.nextToken();
        matrix[i][j] = Integer.parseInt(s);
      }
    }
    return matrix;
  }
}
