package org.backjoon.dp;

import java.io.*;
public class bj2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        while (N%5 != 0) {
            N -= 3;
            ans ++;
        }

        if (N<0) {
            System.out.println(-1);
        } else {
            ans += N/5;
            System.out.println(ans);
        }
    }
}


/*
*   설탕을 정확하게 N킬로그램 배달
* 3킬로 5킬로 봉지가 있다. 최소한의 봉지를 구하라
*
*
* */