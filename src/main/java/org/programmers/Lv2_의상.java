package org.programmers;

import java.util.HashMap;
import java.util.Iterator;

public class Lv2_의상 {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clothMap = new HashMap<>();
        for (String[] cloth : clothes) {
            clothMap.put(cloth[1], clothMap.getOrDefault(cloth[1], 0) + 1);
        }
        Iterator<Integer> iter = clothMap.values().iterator();

        while (iter.hasNext()) {
            answer *= iter.next().intValue() + 1;
        }
        return answer - 1;
    }
}
