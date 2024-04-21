package org.backjoon.datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String inputText = br.readLine();
            if (inputText.equals("0")) {
                break;
            }

            if (inputText.equals(getReverse(inputText))) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static String getReverse(String text) {
        StringBuilder reverseSb = new StringBuilder();
        for (char ch : text.toCharArray()) {
            reverseSb.append(ch);
        }
        return reverseSb.reverse().toString();
    }
}
