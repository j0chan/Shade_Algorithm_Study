package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    n번째 일때,(n>=3)
    1. n-1개의 타일을 채우면, 1개의 타일이 추가로 필요하고,
    2. n-2개의 타일을 채우면, 2개의 타일이 추가로 필요하다.
 */

public class Baekjun_11726 { // 2xN타일링
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //필요 타일의 개수를 저장하는 배열
        int[] arr = new int[1001];

        // n=1, n=2일 때는 규칙성이 없으므로 따로 설정
        arr[1] = 1;
        arr[2] = 2;

        // down-top 방식으로 문제 해결
        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i-1] + arr[i-2]) % 10007;
        }

        System.out.println(arr[n]);
    }
}
