package org.programmers;

import java.util.ArrayList;
import java.util.List;

public class Lv2_모음사전 {
    static String[] arr;
    static List<String> list;
    public static void main(String[] args) {
        String word = "I";
        System.out.println(solution(word));
    }
    public static int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        arr = new String[]{"A", "E", "I", "O", "U"};
        // 완전탐색 메서드 호출
        setDictionary(word, "", 0);

        // 선형 탐색
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    public static void setDictionary(String word, String str, int depth) {
        list.add(str);
        if (depth == 5) {
            return;
        }

        for (int i=0; i< arr.length; i++) {
            setDictionary(word, str + arr[i], depth+1);
        }
    }
}