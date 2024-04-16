package org.programmers;

public class Lv1_덧칧하기 {
    public static void main(String[] args) {
        int n = 8;
        int m = 4;
        int[] section = {2,3,6};
        System.out.println(solution(n, m, section));
    }

    public static int solution(int n, int m, int[] section) {
        int cnt = 0;
        int currSection = section[0];
        cnt++;
        for (int paint : section) {
            if (currSection + m > paint) {
                continue;
            }
            cnt++;
            currSection = paint;
        }
        return cnt;
    }
}
