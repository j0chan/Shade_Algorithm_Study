package week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  보드판을 담는 배열을 초기화, 값 입력 후
  check함수를 이용해 brute force 방식을 이용해 8*8 체스 판을 생성하는 최소 경우의 수를 찾는다
*/

public class Baekjun_1018 {

    // 8*8 판에서 최대 변경은 64번
    public static int min = 64;
    public static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 보드판 초기화
        arr = new boolean[n][m];

        // 보드판 채우기: W이면 true, B이면 false
        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            for (int j = 0; j < m; j++) {
                if (input.charAt(j) == 'W') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
            }
        }

        // 행, 열별 검사하는 경우의 수
        int checkN = n - 7, checkM = m - 7;

        // 경우의 수 마다 check함수 호출, min값 재조정
        for (int i = 0; i < checkN; i++) {
            for (int j = 0; j < checkM; j++) {
                // check함수를 통해 min값 갱신
                check(i, j);
            }
        }

        // 결과 출력
        System.out.println(min);
    }

    public static void check(int r, int c) {
        // 체스판 크기(8*8)만큼 탐색
        int endR = r + 8;
        int endC = c + 8;
        int count = 0;

        // 현재 기대값(체스판이 올바를경우 예상되는 값)
        boolean now = arr[r][c];

        for (int i = r; i < endR; i++) {
            for (int j = c; j < endC; j++) {
                // 현재 값과 현재 기대값이 다를 경우
                if (arr[i][j] != now) {
                    count++;
                }

                // 다음 칸은 색이 반대
                now = !now;
            }

            // 열 변경 시 색 변경
            now = !now;
        }

        // 만약 반대 색으로 시작했을 경우 64-count를 해주어야 한다.
        // 원래색 시작과 반대색 시작을 비교한다.
        count = Math.min(count, 64 - count);

        // count값과 min값 비교
        min = Math.min(min, count);
    }
}
