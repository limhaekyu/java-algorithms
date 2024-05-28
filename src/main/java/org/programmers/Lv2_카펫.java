package org.programmers;

import java.util.Arrays;

public class Lv2_카펫 {
    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;

        System.out.println(Arrays.toString(solution(brown, yellow)));
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int carpet = brown + yellow;

        for (int i=3; i<=carpet; i++) {
            // 세로
            int col = i;
            // 가로
            int row = carpet/col;

            if (row<3) {
                continue;
            }

            if (row >= col) {
                if ((row -2) * (col -2) == yellow) {
                    answer[0] = row;
                    answer[1] = col;
                    break;
                }
            }
        }
        return answer;
    }
}
