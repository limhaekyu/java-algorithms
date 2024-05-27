package org.programmers;

import java.util.HashSet;
import java.util.Set;

public class Lv2_소수찾기 {
    static Set<Integer> set;
    static boolean[] visited = new boolean[7];
    public static void main(String[] args) {
        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }

    public static int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();

        // dfs() 로 만들 수 있는 숫자를 다 만든다.
        dfs(numbers, "", 0);
        // prime()으로 소수 찾기
        for (Integer num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }

    public static void dfs(String numbers, String temp, int depth) {
        if (depth > numbers.length()) {
            return;
        }

        for (int i=0; i<numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;

                set.add(Integer.parseInt(temp + numbers.charAt(i)));
                dfs(numbers, temp + numbers.charAt(i), depth+1);
                visited[i] = false;
            }
        }
    };

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i=2; i*i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
         return true;
    }
}
