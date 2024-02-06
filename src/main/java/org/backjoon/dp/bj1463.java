package org.backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1463 {
    public static Integer[] dp2;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int[] dp = new int[N+1];
        dp[0] = dp[1] = 0;

        btUp(dp,N);
    }

    public static void btUp(int[] dp, int N) {
        for (int i=2; i<=N; i++) {
            dp[i] = dp[i-1] + 1;
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3]+1);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            }
        }

        System.out.println(dp[N]);
    }

    public static int topDown(int N) {
        while (dp2[N] == null) {
            if (N % 6 == 0) {
                dp2[N] = Math.min(topDown(N - 1), Math.min(topDown(N / 3), topDown(N / 2))) + 1;
            } else if (N % 3 == 0) {
                dp2[N] = Math.min(topDown(N/3), topDown(N-1)) + 1;
            } else if (N % 2 == 0) {
                dp2[N] = Math.min(topDown(N/2), topDown(N-1)) + 1;
            } else {
                dp2[N] = topDown(N-1) + 1;
            }
        }
        return dp2[N];
    }
}
