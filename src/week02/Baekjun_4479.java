package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjun_4479 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input=br.readLine())!=null) { // input 공백 시 반복 종료
            int n = Integer.parseInt(input);
            int length = (int) Math.pow(3, n); // 초기 집합 길이 설정

            // 초기 집합 길이 만큼 "-"를 sb에 저장
            StringBuilder sb = new StringBuilder("-".repeat(length));

            if (n == 0) { // 예외! input이 0이면 "-" 출력
                System.out.println("-");
            } else { // 0<n<13이면 cantor 호출 후 sb 출력
                cantor(sb, 0, length);
                System.out.println(sb);
            }
        }
    }

    public static void cantor(StringBuilder sb, int start, int length) {
        // 계속 재귀호출하다가 길이가 1이 되면 return
        if (length == 1) {
            return;
        }

        // 부분 길이 설정
        int partLength = length / 3;

        // 가운데 부분을 공백으로 대체
        for (int i = partLength + start; i < partLength * 2 + start; i++) {
            sb.setCharAt(i, ' ');
        }

        cantor(sb, start, partLength); // 앞쪽 1/3부분 재귀 호출
        cantor(sb, start + partLength * 2, partLength); // 뒤쪽 1/3부분 재귀 호출
    }
}
