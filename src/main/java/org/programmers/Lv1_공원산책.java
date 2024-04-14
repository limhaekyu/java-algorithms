package org.programmers;

import java.util.Arrays;

public class Lv1_공원산책 {
    public static void main(String[] args) {
        String[] park = {"OSO", "OOO", "OXO", "OOO"};
        String[] routes = {"E 2", "S 3", "W 1"};

        System.out.println(Arrays.toString(solution(park, routes)));
    }
    public static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        int maxY = park.length;
        int maxX = park[0].split("").length;

        String[][] P = new String[maxY][maxX];

        for( int i = 0; i < park.length ; i++ ){
            String [] parkMap = park[i].split("");
            for( int j = 0 ; j < parkMap.length ; j++ ){
                P[i][j] = parkMap[j];
                if( "S".equals(parkMap[j])){
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        for( String route : routes ){
            char op = route.charAt(0);
            int n = Integer.parseInt(route.substring( 2 , 3 ));
            boolean okFlag = true;

            int nowY = answer[0];
            int nowX = answer[1];
            for( int cnt = 0; cnt < n ; cnt++ ){
                if(op == 'E') {
                    if( nowX + 1 < maxX && !P[nowY][nowX+1].equals("X") ){
                        nowX++;
                    }
                    else{
                        okFlag = false;
                        break;
                    }
                }
                if(op == 'W'){
                    if( nowX - 1 >= 0 && !P[nowY][nowX-1].equals("X") ){
                        nowX--;
                    }
                    else{
                        okFlag = false;
                        break;
                    }
                }
                if(op == 'S'){
                    if( nowY + 1 < maxY && !P[nowY+1][nowX].equals("X") ){
                        nowY++;
                    }
                    else{
                        okFlag = false;
                        break;
                    }
                }
                if(op == 'N'){
                    if( nowY - 1 >= 0 && !P[nowY-1][nowX].equals("X") ){
                        nowY--;
                    }
                    else{
                        okFlag = false;
                        break;
                    }
                }
            }

            if(okFlag){
                answer[0] = nowY;
                answer[1] = nowX;
            }
        }

        return answer;
    }
}
