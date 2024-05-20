package org.programmers;

import java.util.PriorityQueue;

public class Lv2_더맵게 {
    public static void main(String[] args) {
        int[] scovile = {1,2,3,9,10,12};
        int K = 7;
        System.out.println(solution(scovile, K));
    }

    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> scovileQ = new PriorityQueue<>();
        int answer = 0;
        for (int scov : scoville) {
            scovileQ.offer(scov);
        }

        while (scovileQ.peek() < K) {
            if (scovileQ.size() >= 2) {
                int plusScovile = scovileQ.poll() + (scovileQ.poll() * 2);
                scovileQ.offer(plusScovile);
                answer++;
            } else {
                return -1;
            }
        }
        return answer;
    }
}
