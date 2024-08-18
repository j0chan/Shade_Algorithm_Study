package week03;

import java.io.*;
import java.util.*;


public class Baekjun_1697 {

    static int N,K;
    static int[] visit = new int[100001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine()," ");
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        // 수빈 위치=동생위치 -> 0출력, 아니면 bfs로 최소 시간 계산
        if(N==K) {
            System.out.println(0);
        }else {
            bfs(N);
        }
    }

    static void bfs(int num) {

        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        visit[num]=1;

        while(!q.isEmpty()) {
            int tmp=q.poll();
            for(int i=0;i<3;i++) {
                int next;
                if(i==0) {
                    next=tmp+1; // 한 칸 앞으로
                }else if(i==1) {
                    next=tmp-1; // 한 칸 뒤로
                }else {
                    next=tmp*2; // 현위치 2배
                }

                // 동생 위치 도달 시 출력 후 종료
                if(next==K) {
                    System.out.println(visit[tmp]);
                    return;
                }

                // 다음 위치가 범위 내에 있고, 아직 방문 x
                if (next >= 0 && next < visit.length && visit[next] == 0) {
                    q.add(next);
                    visit[next] = visit[tmp] + 1; // 횟수++
                }
            }
        }
    }

}

