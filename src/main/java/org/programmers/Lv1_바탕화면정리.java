package org.programmers;

import java.util.Arrays;

public class Lv1_바탕화면정리 {
    public static void main(String[] args) {
//        String[] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
        String[] wallpaper = {".#...", "..#..", "...#."};
        System.out.println(Arrays.toString(solution(wallpaper)));
    }
    public static int[] solution(String[] wallpaper) {
        int[] answer = {0, 0, 0, 0};
        boolean isVisited = false;
        int y = 0;
        for (String paper : wallpaper) {
            int x = 0;
            String[] files = paper.split("");
            for (String file : files) {
                if (file.equals("#")) {
                    if (!isVisited) {
                        answer[0] = y;
                        answer[1] = x;
                        answer[2] = y+1;
                        answer[3] = x+1;
                        isVisited = true;
                    } else {
                        answer[0] = Math.min(answer[0], y);
                        answer[1] = Math.min(answer[1], x);
                        answer[2] = Math.max(answer[2], y+1);
                        answer[3] = Math.max(answer[3], x+1);
                    }
                }
                x++;
            }
            y++;
        }
        return answer;
    }
}
