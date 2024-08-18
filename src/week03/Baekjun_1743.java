package week03;

import java.io.*;
import java.util.*;

public class Baekjun_1743 {
    // 상하좌우 이동 배열
    public static int[][] move = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    // 쓰레기 위치
    public static boolean[][] room;
    // 방문 여부
    public static boolean[][] visit;
    public static int height, width;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int trashNum = 0, r = 0, c = 0, answer = 0;

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        trashNum = Integer.parseInt(st.nextToken());

        // 음식물 (1부터 시작이므로 +1)
        room = new boolean[height + 1][width + 1];
        // 방문 확인 (1부터 시작이므로 +1)
        visit = new boolean[height + 1][width + 1];

        // 쓰레기 위치 저장
        for (int x = 0; x < trashNum; x++) {
            st = new StringTokenizer(br.readLine());

            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            room[r][c] = true;

        }

        // 음식물, 방문x 탐색 시작
        for(int x=1;x<=height;x++){
            for (int y = 1; y <= width; y++) {
                // 음식물 있고 방문하지 않았다면
                if (room[x][y] && !visit[x][y]) {
                    // dfs로 크기 확인, 갱신
                    answer = Math.max(answer, dfs(x, y)+1);
                }
            }
        }

        System.out.println(answer);

    }

    public static int dfs(int x,int y){

        visit[x][y] = true;

        int next_x = 0, next_y = 0, ret = 0;

        for (int i = 0; i < 4; i++) {
            next_x = x + move[i][0];
            next_y = y + move[i][1];

            if(next_x<=0 || next_y<=0 || next_x>height || next_y>width){
                continue;
            }
            if(room[next_x][next_y] && !visit[next_x][next_y]){
                ret += dfs(next_x, next_y) + 1;
            }
        }
        return ret;
    }
}