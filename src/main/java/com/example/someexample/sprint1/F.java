package com.example.someexample.sprint1;

import static java.lang.Character.isLetterOrDigit;
import static java.lang.Character.toLowerCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F {

  private static boolean isPalindrome(String text) {
    char[] textArray = text.toCharArray();
    int count2forward = 0;
    int length = textArray.length - 1;
    for(int i = length; i >= 0; i--) {
      if (!isLetterOrDigit(textArray[i])) {
        continue;
      }

      while (!isLetterOrDigit(textArray[count2forward])) {
        count2forward++;
        if (count2forward == length) {
          return false;
        }
      }
      if (toLowerCase(textArray[i]) != toLowerCase(textArray[count2forward])) {
        return false;
      }
      count2forward++;
    }
    return true;
  }

  public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      System.out.println(isPalindrome(reader.readLine()) ? "True" : "False");
    }
  }
}