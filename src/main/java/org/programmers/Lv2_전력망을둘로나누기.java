package org.programmers;

import java.util.ArrayList;

public class Lv2_전력망을둘로나누기 {
    static ArrayList<Integer>[] graph;
    static int min;
    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1,3},{2,3}, {3,4},{4,5}, {4,6},{4, 7},{7, 8},{7, 9}};

        System.out.println(solution(n, wires));
    }

    public static int solution(int n, int[][] wires) {
        graph = new ArrayList[n+1];
        min = Integer.MAX_VALUE;

        for (int i=1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];

            boolean[] visited = new boolean[n + 1];

            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));

            int cnt = dfs(1, visited);

            int diff = Math.abs(cnt - (n - cnt));
            min = Math.min(min, diff);

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        return min;
    }

    public static int dfs(int v, boolean[] visited) {
        visited[v] = true;
        int cnt = 1;

        for (int next : graph[v]) {
            if (!visited[next]) {
                cnt += dfs(next, visited);
            }
        }
        return cnt;
    }
}
