package week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjun_11501 { //주식
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        // t번 반복
        for (int i = 0; i < t; i++) {
            // n(일수) 입력받고 크기가 n인 배열 생성
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            // 배열에 값 넣기
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            long max = 0; // 최고가
            long sum = 0; // 총 이익

            // 배열의 뒤부터 탐색해야 최고가 파악이 더 쉽다
            for (int j = arr.length - 1; j >= 0; j--) {
                // 현재 최고가보다 더 높은 주가가 있을 때
                if (max < arr[j]) {
                    max = arr[j];
                }
                // 아니면 sum에 (max-현재가)를 추가
                else {
                    sum = sum+max-arr[j];
                }
            }

            System.out.println(sum);
        }
    }
}