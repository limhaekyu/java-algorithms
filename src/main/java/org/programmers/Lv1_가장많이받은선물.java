package org.programmers;

import java.util.*;
public class Lv1_가장많이받은선물 {
    public static int main(String[] args) {
        String[] friends = {"a","b"};
        String[] gifts = {"a b"};

        int friendCnt = friends.length;
        HashMap<String, Integer> friendIdx = new HashMap<>();

        int[] giftCnt = new int[friendCnt];
        int[][] giftGraph = new int[friendCnt][friendCnt];
        int[] result = new int[friendCnt];

        for (int i=0; i<friendCnt; i++) {
            friendIdx.put(friends[i], i);
        }

        for (String gift : gifts) {
            String[] giftSR = gift.split(" ");

            int sendIdx = friendIdx.get(giftSR[0]);
            int recvIdx = friendIdx.get(giftSR[1]);
            giftCnt[sendIdx]++;
            giftCnt[recvIdx]--;

            giftGraph[sendIdx][recvIdx]++;
            giftGraph[recvIdx][sendIdx]--;
        }

        for (int i=0; i<friendCnt; i++) {
            for(int j=i; j<friendCnt; j++) {
                if (giftGraph[i][j] > 0) {
                    result[i]++;
                } else if (giftGraph[i][j] < 0) {
                    result[j]++;
                } else {
                    if (giftCnt[i] == giftCnt[j]) {
                        continue;
                    } else if (giftCnt[i] > giftCnt[j]){
                        result[i]++;
                    } else {
                        result[j]++;
                    }
                }
            }
        }
        return Arrays.stream(result).max().getAsInt();
    }
}
