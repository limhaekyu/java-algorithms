package org.backjoon.datastructures;

import java.io.*;
import java.util.*;
public class bj9093 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean stFlag = true;
            while (stFlag) {
                String text = st.nextToken();
                sb.append(reverseText(text));

                if (!st.hasMoreTokens()) {
                    stFlag = false;
                    sb.append("\n");
                } else {
                    sb.append(" ");
                }
            }
        }
        System.out.println(sb.toString());

    }
    public static String reverseText(String txt) {
        StringBuilder reversed = new StringBuilder();
        for (int i = txt.length() - 1; i >= 0; i--) {
            reversed.append(txt.charAt(i));
        }
        return reversed.toString();
    }

}
