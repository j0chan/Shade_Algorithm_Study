package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjun_1182 {
    static int count = 0;
    static int n = 0;
    static int s = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // n, s 입력
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n]; // 길이 n인 배열 초기화

        // 배열에 원소 할당
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        search(0, 0);

        if (s == 0) { // 공집합일 때 1을 빼주어야 함
            count--;
        }

        System.out.println(count);
    }

    public static void search(int depth, int sum) {
        if (depth == n) {
            if (sum == s) { // 요소의 합=s -> count++
                count++;
            }
            return; // 배열의 끝에 도달 시 리턴
        }

        search(depth + 1, sum); // 현재 요소 포함 x
        search(depth + 1, sum + arr[depth]); // 현재 요소 포함
    }
}
