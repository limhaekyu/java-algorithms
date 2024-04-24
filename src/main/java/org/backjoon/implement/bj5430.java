package org.backjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());

            String arrStr = br.readLine();
            Deque<Integer> deque = new LinkedList<>();
            for (String s : arrStr.substring(1, arrStr.length() - 1).split(","))
                if (!s.isEmpty())
                    deque.add(Integer.valueOf(s));

            System.out.println(ac(deque, p));
        }
    }

    static String ac(Deque<Integer> deque, String commands) {
        boolean reverse = false;

        for (char command : commands.toCharArray()) {
            if (command == 'R')
                reverse = !reverse;
            else {
                if (deque.isEmpty())
                    return "error";

                if (reverse)
                    deque.removeLast();
                else
                    deque.removeFirst();
            }
        }

        StringBuilder sb = new StringBuilder("[");
        while (!deque.isEmpty()) {
            sb.append(reverse ? deque.removeLast() : deque.removeFirst());
            if (!deque.isEmpty())
                sb.append(',');
        }
        sb.append(']');

        return sb.toString();
    }

}
