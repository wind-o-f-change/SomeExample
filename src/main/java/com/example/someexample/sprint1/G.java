package com.example.someexample.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G {

  private static String getBinaryNumber(Integer num) {
    StringBuilder sb = new StringBuilder();

    while(num > 0) {
      sb.append(num % 2);
      num /= 2;
    }
    return sb.reverse().toString();
  }

  public static void main(String[] args) throws IOException {
    try (var br = new BufferedReader(new InputStreamReader(System.in))) {
      String result = getBinaryNumber(Integer.parseInt(br.readLine()));
      System.out.println(result);
    }
  }
}