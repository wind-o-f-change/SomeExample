package com.example.someexample.sprint3.final_tasks;

/*
* -- Принцип алгоритма --
* Задача решена при помощи бинарного поиска который был модифицирован.
* Модификация заключается в изменении логики поиска индекса для сдвига указателя
*
*
* -- Временная и пространственная сложность --
* Временная сложность: O(log n) - сложность поис
* Пространственная сложность: O(1) - тк операции производятся итеративно без создания новых структур данных
*
* Sptint 3 final A
* Задача: https://contest.yandex.ru/contest/23815/problems/A/?success=124404374#3484683/2020_06_08/vbIO4s58Ew
* Отчет: https://contest.yandex.ru/contest/23815/run-report/124404374/
*/
public class Solution {
  public static int brokenSearch(int[] arr, int k) {
    // Your code
    // “ヽ(´▽｀)ノ”

    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
      int mid = left + (right - left)/2;

      if (arr[mid] == k) {
        return mid;
      }

      if (arr[left] <= arr[mid]) {
        if(arr[left] <= k && k < arr[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }

      } else {
        if (arr[mid] < k && k <= arr[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args){
    test();
  }

  private static void test() {
    int[] arr = {19, 21, 100, 101, 1, 4, 5, 7, 12};
    int foundIdx = brokenSearch(arr, 5);
    System.out.println("found idx=" + foundIdx + "; responce is " + (6 == foundIdx));
  }
}
