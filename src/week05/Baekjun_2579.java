package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    #조건
    1. 세 계단 이상 연속해서 밟을 수 없다. (최대 두 계단)
    2. 세 계단 이상 건너 뛸 수 없다. (최대 두 계단)

    따라서
    e.g) 세 번째 계단을 가는 경우의 수
    1. 0 -> 1 -> 3
    2. 0 -> 2 -> 3
    둘 중 큰 값 선택
 */

public class Baekjun_2579 { // 계단오르기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] step = new int[300]; // 각 계단별 점수 저장
        int[] score = new int[300]; // 해당 계단에 도달 시 얻을 수 있는 점수


        for (int i = 1; i <= n; i++) {
            step[i] = Integer.parseInt(br.readLine());

            // 1,2,3번째 계단을 먼저 할당하여 4번째 계단부터 이를 이용하여 최대값을 결정
            score[1] = step[1];
            score[2] = step[1] + step[2];
            score[3] = Math.max(step[1], step[2]) + step[3];
        }

        for (int i = 4; i <= n; i++) {
            /*
                1: n-3번째 계단에 도달하는 최대 점수
                2: n-2번째 계단에 도달하는 최대 점수
                둘 중 더 큰 값에 n번째 계단에 해당하는 점수를 더한다.

                이를 통해 n번째 계단에 도달하는 경우의 수 중 가장 큰 값 결정 가능

                e.g) n=6
                1: 3번째 계단에 할당된 score + 5번째 계단을 밟을 때 얻는 점수
                2: 4번째 계단에 할당된 score
             */
            score[i] = Math.max(score[i - 3] + step[i - 1], score[i - 2]) + step[i];
        }

        System.out.println(score[n]);
    }
}

