package org.programmers;

public class Lv3_단어변환 {
    static boolean[] visited;
    static int answer = 0;
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution(begin, target, words));
    }

    private static int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        dfs(begin, target, words, 0);
        return answer;
    }
    private static void dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {
            answer = cnt;
            return;
        }
        for (int i=0; i<words.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (checkWord(begin, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, cnt+1);
                visited[i] = false;
            }
        }

    }
    private static boolean checkWord(String fromWord, String toWord) {
        int cnt = 0;
        for (int i=0; i<fromWord.length(); i++) {
            if (fromWord.charAt(i) == toWord.charAt(i)) {
                cnt ++;
            }
        }
        return cnt == (fromWord.length() - 1);
    }

}
