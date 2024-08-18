package week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjun_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] meets = new int[n][2];

        // 배열에 시ㅏㄱㄴ 할당
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            meets[i][0] = a;
            meets[i][1] = b;
        }

        // 람다식으로 배열 정렬
        Arrays.sort(meets, (a, b) -> {
            // 종료 시간이 같다면 시작 시간 기준 정렬
            if (a[1] == b[1]) {
                // a<b: 음수반환, a>b: 양수 반환하여 정렬 순서 결정
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]); // 종료 시간 기준 정렬
        });

        int lastMeetEnd = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            // 현재 탐색하는 미팅의 시작시간이 이전 미팅 종료시간보다 같거나 크다면
            if (meets[i][0] >= lastMeetEnd) {
                // 이전 미팅 종료시간을 현재 미팅 종료시간으로 설정
                lastMeetEnd = meets[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}

