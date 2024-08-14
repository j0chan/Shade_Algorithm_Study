package week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjun_1260 {
    static StringBuilder sb = new StringBuilder(); // 결과 출력용

    static int n; // node 개수
    static int m; // edge 개수
    static int v; // 시작 node 번호
    static boolean[] visit; // 방문 여부 확인 배열
    static int[][] arr; // 인접 리스트

    static Queue<Integer> q = new LinkedList<>(); // bfs용 큐

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        // 정점은 1~n까지 이므로, 배열 크기는 n+1을 해주어야 함
        arr = new int[n + 1][n + 1];
        visit = new boolean[n + 1]; // dfs용 visit 초기화

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1; // 이 문제는 방향성이 없기 때문에 반대 경우도 가능
        }

        dfs(v);
        sb.append("\n");
        visit = new boolean[n + 1]; // bfs용 visit 초기화
        bfs(v);

        System.out.println(sb);
    }

    public static void dfs(int start) {
        visit[start] = true; // 방문시 true

        sb.append(start + " ");

        for (int i = 0; i < n + 1; i++) {
            // 방문가능 노드이면서, 방문하지 않은 노드일 때 dfs(i)
            if (arr[start][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        q.add(start);
        visit[start] = true;

        // 큐가 빌때까지 반복
        while (!q.isEmpty()) {
            start = q.poll(); // 큐의 첫번째 요소를 start에 저장
            sb.append(start + " ");
            for (int i = 0; i < n + 1; i++) {
                // 방문가능 노드이면서, 방문하지 않은 노드일때
                if (arr[start][i] == 1 && !visit[i]) {
                    q.add(i); // 큐에 start의 인접 노드를 넣고
                    visit[i] = true; // 방문 여부를 true로 설정
                }
            }

        }
    }
}
