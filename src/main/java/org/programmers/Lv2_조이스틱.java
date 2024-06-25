package org.programmers;

public class Lv2_조이스틱 {
    public static void main(String[] args) {
        String name = "JEROEN";
        System.out.println(solution(name));
    }

    public static int solution(String name) {
        int answer = 0;
        int length = name.length();
        int move = length-1;

        for (int i=0; i<name.length(); i++) {
            // 상하 움직임
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            int next = i+1;

            // 연속되는 A 갯수 확인
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }

            // 순서대로 가는것, 뒤로 돌아가는 것 비교
            move = Math.min(move, i * 2 + length - next);

            // 처음부터 뒷부분을 먼저 입력하는 것 비교
            move = Math.min(move, (length - next) * 2 + i);
        }
        answer += move;
        return answer;
    }
}
