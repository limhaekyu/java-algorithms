package org.programmers;

public class Lv3_네트워크 {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};
        System.out.println(solution(n ,computers));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i=0; i<n; i++) {
            if (visited[i] == false) {
                answer++;
                dfs(i, visited, computers);
            }

        }
        return answer;
    }

    private static void dfs(int n, boolean[] visited,  int[][] computers) {
        visited[n] = true;

        for (int i=0; i<computers.length; i++) {
            if (visited[i] == false && computers[n][i] == 1) {
                dfs(i, visited, computers);
            }

        }
    }


}
