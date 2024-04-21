package org.programmers;

import java.util.HashMap;

public class Lv1_성격유형검사하기 {
    public static void main (String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        System.out.println(solution(survey, choices));
    }

    public static String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> surveyMap = new HashMap<>();

        for (int i=0; i<survey.length; i++) {
            int value = choices[i];

            if (value > 0 && value < 4) {
                char ch = survey[i].charAt(0);
                surveyMap.put(ch, surveyMap.getOrDefault(ch, 0) + 4 - value);
            } else if (value > 4) {
                char ch = survey[i].charAt(1);
                surveyMap.put(ch, surveyMap.getOrDefault(ch, 0) + value -4);
            }
        }

        return new StringBuilder()
                .append(surveyMap.getOrDefault('R', 0) >= surveyMap.getOrDefault('T', 0) ? 'R' : 'T')
                .append(surveyMap.getOrDefault('C', 0) >= surveyMap.getOrDefault('F', 0) ? 'C' : 'F')
                .append(surveyMap.getOrDefault('J', 0) >= surveyMap.getOrDefault('M', 0) ? 'J' : 'M')
                .append(surveyMap.getOrDefault('A', 0) >= surveyMap.getOrDefault('N', 0) ? 'A' : 'N')
                .toString();
    }
}
