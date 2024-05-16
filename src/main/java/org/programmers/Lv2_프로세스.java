package org.programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class Lv2_프로세스 {
    public static void main(String[] args) {
         int[] priorities = {2, 1, 3, 2};
         int location = 2;
//        int[] priorities = {1, 1, 9, 1, 1, 1};
//        int location = 0;
        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> prcsQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int process : priorities) {
            prcsQ.offer(process);
        }

        while (!prcsQ.isEmpty()) {
            for (int i=0; i<priorities.length; i++) {
                if (prcsQ.peek() == priorities[i]) {
                    prcsQ.poll();
                    answer++;

                    if (location == i) {
                        return answer;
                    }
                }
            }
        }
        return answer;
    }


}
