package org.backjoon.datastructures;

import java.io.*;
import java.util.*;
public class bj9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            String text = br.readLine();

            for (int j=0; j < text.length(); j++) {
                if (text.charAt(j) == ' ') {
                    while (!stack.empty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(" ");
                } else {
                    stack.push(text.charAt(j));
                }
            }
            while (!stack.empty()) {
                sb.append(stack.pop());
            }
            sb.append("\n");
        }
        br.close();
        System.out.println(sb.toString());
    }
}
