package org.programmers;

import java.util.HashMap;
import java.util.Map;

public class Lv2_전화번호목록 {
    public static void main (String[] args) {
        String[] phoneBook = {"119", "97674223", "1195524421"};
        if (solution(phoneBook)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static boolean solution(String[] phoneBook) {
        Map<String, Integer> map = new HashMap<>();

        for (int i=0; i<phoneBook.length; i++) {
            map.put(phoneBook[i], i);
        }

        for (int i=0; i<phoneBook.length; i++) {
            for (int j= 0; j<phoneBook[i].length(); j++) {
                if (map.containsKey(phoneBook[i].substring(0, j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
