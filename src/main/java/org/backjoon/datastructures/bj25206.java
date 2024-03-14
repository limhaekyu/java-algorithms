package org.backjoon.datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double totalCredit = 0;
        double totalScore = 0;
        double avg = 0;

        for (int i = 0; i < 20; i++) {
            String[] grade = br.readLine().split(" ");
            if (grade[2].equals("P")) {
                continue;
            }
            double credit = Double.parseDouble(grade[1]);
            totalCredit += credit;
            totalScore += gradeToScore(grade[2]) * credit;
        }

        if (totalScore == 0) {
            avg = 0;
        } else {
            avg = totalScore / totalCredit;
        }
        System.out.println(avg);
    }

    public static double gradeToScore(String grade) {
        double score = 0;
        switch (grade) {
            case "A+":
                score = 4.5;
                break;
            case "A0":
                score = 4.0;
                break;
            case "B+":
                score = 3.5;
                break;
            case "B0":
                score = 3.0;
                break;
            case "C+":
                score = 2.5;
                break;
            case "C0":
                score = 2.0;
                break;
            case "D+":
                score = 1.5;
                break;
            case "D0":
                score = 1.0;
                break;
            case "F":
                score = 0.0;
                break;
        }
        return score;
    }
}
