package org.backjoon.dp;

import java.io.*;

public class bj9095 {

    public static StringBuilder sb = new StringBuilder();
    public static Integer[] dp2;
    public static void main (String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {
            int N = Integer.parseInt(br.readLine());
            if (N > 3) {
                int[] dp = new int[N+1];

                dp[1] = 1;
                dp[2] = 2;
                dp[3] = 4;

                btUp(dp, N);
            } else {
                switch(N) {
                    case 1:
                        sb.append("1\n");
                        break;
                    case 2:
                        sb.append("2\n");
                        break;
                    case 3:
                        sb.append("4\n");
                        break;
                }
            }
        }
    }

    public static void btUp(int[] dp, int N) {
        for (int i=4; i<=N; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        sb.append(dp[N]).append("\n");
    }

    public static int topDown(int N) {
        if (dp2[N] == null) {
            dp2[N] = topDown(N-3) + topDown(N-2) + topDown(N-1);
            return dp2[N];
        }
        return dp2[N];
    }
}
