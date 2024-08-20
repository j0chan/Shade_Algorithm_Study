package week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjun_1912 { //연속합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = arr[0];
        int sum = arr[0];

        // 시간복잡도 O(n)
        for (int i = 1; i < n; i++) {
            // sum+다음인덱스와 다음인덱스 값 중 더 큰 값 선택
            // (다음 인덱스 선택을 위해 i=1부터 시작)
            sum = Math.max(sum + arr[i], arr[i]);
            // 위 선택값과 max 비교
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}