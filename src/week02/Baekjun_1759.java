package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    조건
    1. 출력 string 중 모음 1개 이상 && 자음 2개 이상
    2. 출력 string 길이 = L
 */

public class Baekjun_1759 {
    static int L;
    static int C;
    static String[] arr;
    static String[] mo = {"a", "e", "i", "o", "u"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new String[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr);

        search(0, 0, new StringBuilder());
    }

    public static void search(int depth, int start, StringBuilder sb) {
        if (depth == L) { // 조건 2
            String str = sb.toString();
            if (isPrintable(str)) { // 조건 1
                System.out.println(str); // 조건1,2 동시 만족 시
            }
            return;
        }

        for (int i = start; i < C; i++) {
            sb.append(arr[i]);
            search(depth + 1, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1); // 백트래킹
        }
    }

    public static boolean isPrintable(String str) {
        int moCount = 0; // 모음 개수
        int jaCount = 0; // 자음 개수

        for (int i = 0; i < str.length(); i++) {
            if (Arrays.asList(mo).contains(String.valueOf(str.charAt(i)))) {
                moCount++;
            } else {
                jaCount++;
            }
        }

        // 모음 1개이상, 자음 2개이상이면 true 리턴
        return moCount >= 1 && jaCount >= 2;
    }
}
