package org.backjoon.brute_force;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class bj1107 {
    static boolean[] button = new boolean[10];
    static int target;
    static long count;

    public static void dfs(int idx, int click) {
        for (int i=0; i<10; i++) {
            if (!button[i]) {
                int newBtn = click * 10 + i;
                int cnt = Math.abs(target - newBtn) + String.valueOf(newBtn).length();
                count = Math.min(cnt, count);

                if (idx < 6) {
                    dfs(idx + 1, newBtn);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        target = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        if (n != 0) {

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                button[Integer.parseInt(st.nextToken())] = true;
            }
        }
        if (target == 100) {
            System.out.println(0);
            return;
        }
        count = Math.abs(target - 100);

        dfs(0, 0);
        System.out.println(count);

        br.close();
    }
}
