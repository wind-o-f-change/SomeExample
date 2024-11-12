package com.example.someexample.sprint4;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Competition {

  public static void main(String[] args) throws IOException {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = parseInt(br.readLine());
      String[] input = br.readLine().split(" ");

      // Переменная для отслеживания баланса 0 и 1
      int balance = 0;
      // Хеш-таблица для хранения индексов первого вхождения каждого значения баланса
      Map<Integer, Integer> balanceMap = new HashMap<>();
      balanceMap.put(0, -1); // Инициализируем баланс 0 на позиции -1, чтобы учесть начальный отрезок

      int maxLength = 0;

      // Проход по всем элементам массива
      for (int i = 0; i < n; i++) {
        int curr = parseInt(input[i]);
        // Увеличиваем или уменьшаем баланс в зависимости от значения
        balance = curr == 0 ? balance-1 : balance+1;

        // Проверяем, был ли этот баланс уже встречен
        if (balanceMap.containsKey(balance)) {
          // Если баланс уже встречался, вычисляем длину текущего отрезка
          int prevIndex = balanceMap.get(balance);
          int length = i - prevIndex;
          maxLength = Math.max(maxLength, length);
        } else {
          // Сохраняем первое вхождение данного значения баланса
          balanceMap.put(balance, i);
        }
      }

      // Выводим максимальную длину отрезка с равным количеством 0 и 1
      System.out.println(maxLength);
    }
  }
}