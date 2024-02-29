package org.backjoon.datastructures;

import java.util.*;
import java.io.*;

public class bj10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int top = 0;
        Integer[] stack = new Integer[n+1];

        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String order = st.nextToken();
            switch (order) {
                case "push":
                    stack[top++] = Integer.parseInt(st.nextToken());
                    break;
                case "pop":
                    if (top == 0) {
                        sb.append("-1");
                    } else {
                        sb.append(stack[--top]);
                    }
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(top);
                    sb.append("\n");
                    break;
                case "empty":
                    if (top == 0) {
                        sb.append("1");
                    } else {
                        sb.append("0");
                    }
                    sb.append("\n");
                    break;
                case "top":
                    if (top == 0) {
                        sb.append("-1");
                    } else {
                        sb.append(stack[top-1]);
                    }
                    sb.append("\n");
                    break;
            }
        }
        br.close();
        System.out.println(sb.toString());
    }
}