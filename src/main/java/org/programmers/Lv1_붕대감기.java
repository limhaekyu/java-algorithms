package org.programmers;

public class Lv1_붕대감기 {
    public int solution(int[] bandage, int health, int[][] attacks) {

        int bandageTime = bandage[0];
        int bandageHealPerSec = bandage[1];
        int bandageBonusHeal = bandage[2];

        int currentHealth = health;
        int currentTime = 0;
        int healCnt = 0;

        for (int[] attack : attacks) {
            int attackTime = attack[0];
            int attackDamage = attack[1];

            while (currentTime < attackTime) {
                if (currentHealth == health) {
                    currentTime++;
                    continue;
                }

                if ((health - currentHealth) > bandageHealPerSec) {
                    currentHealth += bandageHealPerSec;
                    healCnt++;
                    currentTime++;
                } else {
                    currentHealth = health;
                    currentTime++;
                }

                if (healCnt == bandageTime) {
                    if ((health - currentHealth) > bandageBonusHeal) {
                        currentHealth += bandageBonusHeal;
                        healCnt = 0;
                    } else {
                        currentHealth = health;
                        healCnt = 0;
                    }
                }
            }

            if (currentHealth <= attackDamage) {
                return -1;
            } else {
                currentHealth -= attackDamage;
                currentTime++;
                healCnt = 0;
            }
        }

        return currentHealth;
    }
}