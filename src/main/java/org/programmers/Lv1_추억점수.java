package org.programmers;

import java.util.HashMap;

public class Lv1_추억점수 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> map = new HashMap<>();
        int[] res = new int[photo.length];
        for (int i=0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        for (int i=0; i < photo.length; i++) {
            int sum = 0;
            String[] photoItem = photo[i];
            for (String photoName: photoItem) {
                if (map.containsKey(photoName)) {
                    sum += map.get(photoName);
                }
            }
            res[i] = sum;
        }
        return res;
    }
}
