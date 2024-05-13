package org.programmers;

import java.util.*;

public class Lv2_기능개발 {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) {
                queue.offer((100 - progresses[i]) / speeds[i]);
            } else {
                queue.offer(((100 - progresses[i]) / speeds[i]) + 1);
            }
        }

        int now = queue.poll();
        int count = 1;

        while (!queue.isEmpty()) {
            if (now >= queue.peek()) {
                count++;
                queue.poll();
            } else {
                answer.add(count);
                count = 1;
                now = queue.poll();
            }
        }
        answer.add(count);

        return answer.stream().mapToInt(i -> i).toArray();
    }

}
