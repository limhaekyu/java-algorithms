package org.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Lv2_다리를지나는트럭 {
    public static void main (String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};


        System.out.println(solution(2, 10, truck_weights));
    }
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int totalWeight = 0;
        Queue<Integer> truckQ = new LinkedList<>();
        for (int truck : truck_weights) {
            while(true) {
                if (truckQ.isEmpty()) {
                    truckQ.add(truck);
                    totalWeight+=truck;
                    answer++;
                    break;
                }

                else if (truckQ.size() == bridge_length) {
                    totalWeight -= truckQ.poll();
                }
                else {
                    if (totalWeight + truck <= weight) {
                        truckQ.add(truck);
                        totalWeight+=truck;
                        answer++;
                        break;
                    } else {
                        truckQ.add(0);
                        answer++;
                    }
                }
            }
        }
        answer += bridge_length;
        return answer;
    }
}