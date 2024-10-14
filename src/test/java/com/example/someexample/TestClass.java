package com.example.someexample;


import org.junit.jupiter.api.Test;

class TestClass {

  @Test
  void contextLoads() {
    var arr = new int[][]{{1,2,3},{3,2,1}};
    System.out.println(arr.length+" - "+arr[0].length+" - "+arr[1].length);
  }

  static long[] calcEntranceAndFloorNums(long m, long f, long k2) {
    long countFloorInEntrance = m * f;
    long entranceNum = Math.round((double) k2 / countFloorInEntrance);
    long floorNum =  Math.round((double) ((k2 - entranceNum * countFloorInEntrance) / m) + 1);
    ++entranceNum;
    return new long[]{entranceNum, floorNum};
  }
}
