package com.example.someexample.sprint1;

import static java.lang.Character.isLetter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {

  private static String getLongestWord(String text) {
    // Ваше решение
    char[] chars = text.toCharArray();
    int count2forward = 0;
    for(int i = chars.length - 1; i >= 0; i--) {
      if (!isLetter(chars[i])) {
        continue;
      }
      while (!isLetter(chars[count2forward])) {
        count2forward++;
        if (count2forward == chars.length - 1) {
          return "False";
        }
      }
      if (chars[i] != chars[count2forward]) {
        return "False";
      }
    }
    return "True";
  }

  public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int textLength = readInt(reader);
      String text = reader.readLine();
      String longestWord = getLongestWord(text);
      System.out.println(longestWord);
      System.out.println(longestWord.length());
    }
  }

  private static int readInt(BufferedReader reader) throws IOException {
    return Integer.parseInt(reader.readLine());
  }
}


