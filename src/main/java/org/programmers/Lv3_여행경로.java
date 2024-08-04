package org.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lv3_여행경로 {

    public static boolean[] visited;
    public static List<String> res = new ArrayList<>();
    public static void main(String[] args) {
        // String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        System.out.println(Arrays.toString(solution(tickets)));
    }

    public static String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        String now = "ICN";
        int idx = 0;

        dfs(idx, now, now, tickets);
        Collections.sort(res);

        return res.get(0).split(",");
    }

    private static void dfs(int idx, String start, String path, String[][] tickets) {
        if (idx == tickets.length) {
            res.add(path);
            return;
        }
        for (int i=0; i<tickets.length; i++) {
            if (tickets[i][0].equals(start) && !visited[i]) {
                visited[i] = true;
                dfs(idx+1, tickets[i][1], path + "," + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}
