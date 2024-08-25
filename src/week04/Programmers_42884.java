package week04;

import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 배열을 진출지점을 기준으로 오름차순 정렬
        Arrays.sort(routes, (a, b)->{
            if(a[1]==b[1]){
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        // 최초 카메라 설치지점은 첫 차량의 진출지점으로
        int camLoc = routes[0][1];

        // 설치한 카메라 개수
        int camNum = 1;

        // 두번째 진입 차량부터 탐색
        for(int i=1 ; i<routes.length ; i++){
            // 카메라 위치보다 i번째 차량의 진입지점이 나중에 있다면
            if(camLoc < routes[i][0]){
                camLoc = routes[i][1]; // i번째 차량의 진출지점에 카메라 설치
                camNum++;
            }
        }

        return camNum;
    }
}