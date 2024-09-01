package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjun_11727 { // 2xN타일링2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];

        // 초기값
        arr[1] = 1;
        arr[2] = 3;

        // n번째는 n-2번째의 2배 값과 n-1번째를 더해서 구한다
        for (int i = 3; i <= n; i++) {
            arr[i] = (2*arr[i-2] + arr[i-1]) % 10007;
        }

        System.out.println(arr[n]);
    }
}
