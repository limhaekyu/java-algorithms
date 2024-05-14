package org.programmers;

import java.util.Stack;

public class Lv2_올바른괄호 {
    public static void main (String[] args) {
        String s = ")()(";
        System.out.println(solution(s));
    }
    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        int close = 0;
        for (int i=0; i<s.length(); i++) {
            stack.push(s.charAt(i));
        }
        while (!stack.isEmpty()) {
            char now = stack.pop();
            if (now == '(') {
                if (close == 0) {
                    return false;
                } else {
                    close--;
                }
            } else {
                close++;
            }
        }
        if (close != 0) {
            return false;
        }
        return true;
    }
}
