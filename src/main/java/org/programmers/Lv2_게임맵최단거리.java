package org.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Lv2_게임맵최단거리 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main (String[] args) {
        int[][] maps1 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        int[][] maps2 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
        System.out.println(solution(maps1));
        System.out.println(solution(maps2));
    }

    public static int solution(int[][] maps) {
        int answer = 0;
        int[][] visit = new int[maps.length][maps[0].length];

        bfs(visit, maps);
        answer = visit[maps.length-1][maps[0].length-1];

        if (answer == 0) {
            answer = -1;
        }
        return answer;
    }

    private static void bfs(int[][] visit, int[][] maps) {
        int x=0, y=0;
        visit[x][y] = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int cX = node[0];
            int cY = node[1];

            for (int i=0; i<4; i++) {
                int nX = cX + dx[i];
                int nY = cY + dy[i];

                if (nX < 0 || nX > maps.length-1 || nY < 0 || nY > maps[0].length-1) {
                    continue;
                }

                if (maps[nX][nY] == 1 && visit[nX][nY] == 0) {
                    visit[nX][nY] = visit[cX][cY] + 1;
                    queue.add(new int[]{nX, nY});
                }
            }
        }
    }
}
