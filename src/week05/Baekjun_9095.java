package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    1,2,3을 이용해 더 큰 수를 만드는 원리이므로
    1,2,3을 만드는 경우의 수를 파악하고 점화식을 구한다

    n을 만드는 방법은 n-3, n-2, n-1을 만드는 경우의 수의 합과 같다.
    e.g) 4를 만드는 방법
    1,2,3을 만드는 경우의 수의 합, 즉 1+2+4=7
 */
public class Baekjun_9095 { // 123더하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] arr = new int[12];

        arr[1] = 1; // 1을 만드는 방법 1가지 [1]
        arr[2] = 2; // 2를 만드는 방법 2가지 [1+1], [2]
        arr[3] = 4; // 3을 만드는 방법 4가지 [1+1+1], [2+1], [1+2], [3]

        // 점화식을 이용해 n을 만드는 경우의 수를 배열에 저장
        for (int i = 4; i <= 11; i++) {
            arr[i] = arr[i-3] + arr[i-2] + arr[i-1];
        }

        for (int i = 0; i < t; i++) {
            int input = Integer.parseInt(br.readLine());
            System.out.println(arr[input]);
        }
    }
}