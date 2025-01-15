package com.example.someexample.sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// GPT-o1
//https://contest.yandex.ru/contest/23991/problems/F/?success=131527636#51450/2021_01_02/hqZGchrmvx
public class SubstringHash {
    static long[] prefixHash;
    static long[] pows;
    static int a, m;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // 1. Считываем a, m
            a = Integer.parseInt(br.readLine());
            m = Integer.parseInt(br.readLine());
            
            // 2. Считываем строку
            String s = br.readLine();
            int n = s.length();
            
            // 3. Предварительный расчёт степеней a и префиксных хешей
            pows = new long[n + 1];
            prefixHash = new long[n + 1];
            
            pows[0] = 1; // a^0 = 1
            for (int i = 1; i <= n; i++) {
                pows[i] = (pows[i - 1] * a) % m;
            }
            for (int i = 1; i <= n; i++) {
                prefixHash[i] = (prefixHash[i - 1] * a + s.charAt(i - 1)) % m;
            }

            // 4. Обработка запросов
            int t = Integer.parseInt(br.readLine());
            StringTokenizer st;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < t; i++) {
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                sb.append(getHash(l, r)).append("\n");
            }
            // 5. Вывод ответов
            System.out.print(sb);
        }
    }

    private static long getHash(int l, int r) {
        // hash(l,r) = (prefixHash[r] - prefixHash[l-1] * pows[r-l+1]) mod m
        long hash = prefixHash[r] - (prefixHash[l - 1] * pows[r - l + 1] % m);
        if (hash < 0) {
            hash += m;
        }
        return hash;
    }
}