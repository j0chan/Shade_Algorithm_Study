package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjun_1932 { // 정수삼각형
    // input(정수삼각형)을 입력받는 배열
    static int[][] arr;

    // 최대값을 구하기 위해 사용하는 배열
    // int로 선언하면 기본값이 0으로 초기화되어 있으므로, 기본값이 null인 Integer로 선언한다.
    static Integer[][] dp;

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        dp = new Integer[n][n];

        // 정수 삼각형을 입력받는 부분
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");

            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 삼각형의 최하단 값을 dp에 입력
        for (int i = 0; i < n; i++) {
            dp[n-1][i] = arr[n-1][i];
        }

        System.out.println(calc(0, 0));
    }

    // depth는 배열의 행, 삼각형의 세로 / col은 배열의 열, 삼각형의 가로
    public static int calc(int depth, int col) {
        // 삼각형의 최하단에 도달했을 때, 해당 위치 값 반환
        if (depth == n - 1) {
            return dp[depth][col];
        }

        // 해당 위치 값이 null이라면,
        if (dp[depth][col] == null) {
            // 해당 위치에 좌하단 대각선과 우하단 대각선의 위치의 값 중 큰 값 선택하고, (null일 시 재귀 호출)
            // 해당 위치에 값을 더한다.
            dp[depth][col] = Math.max(calc(depth+1, col), calc(depth+1, col+1)) + arr[depth][col];
        }

        // 재귀 호출이 종료되고 dp가 모두 채워지면 최상단 값 리턴
        return dp[depth][col];
    }
}
