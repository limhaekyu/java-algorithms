package org.programmers;

import java.util.HashMap;

public class Lv1_달리기경주 {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> rank = new HashMap<>();
        for (int i=0; i<players.length; i++) {
            rank.put(players[i], i);
        }

        for (String call : callings) {
            int idx = rank.get(call);
            String frontPlayer = players[idx-1];

            players[idx-1] = call;
            players[idx] = frontPlayer;

            rank.put(call, idx-1);
            rank.put(frontPlayer, idx);
        }
        return players;
    }
}
