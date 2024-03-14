package org.backjoon.datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        br.close();

        List<Integer> scores = new ArrayList<>();
        for (int i=0; i<n; i++) {
            scores.add(Integer.parseInt(st.nextToken()));
        }
        scores.sort(Comparator.reverseOrder());

        int max_value = scores.get(0);
        double total = 0;
        for (int score : scores) {
            total += (((double)score/(double)max_value)*100);
        }

        double avg = total/n;
        System.out.println(avg);
    }
}
