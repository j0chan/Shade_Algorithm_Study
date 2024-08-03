package week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjun_11870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[n]; // 원본 배열
        int[] sortedArr = new int[n]; // 정렬된 배열
        // hashMap을 통해 압축된 값에 순위를 매핑한다
        HashMap<Integer, Integer> compressionMap = new HashMap<>();

        // 각 배열에 데이터 삽입
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sortedArr[i] = arr[i];
        }

        // 정렬된 배열 정렬하기
        Arrays.sort(sortedArr);

        // 압축된 좌표값 할당
        // 정렬된 배열 첫번째 인덱스부터 0,1,2... 값을 할당한다
        int num = 0;
        for (int i = 0; i < n; i++) {
            // 이미 값이 매핑되어 있지 않다면 새로운 값 매핑
            // if문을 통해 중복된 key값을 제거
            if (!compressionMap.containsKey(sortedArr[i])) {
                // key: sortedArr[i], value: num
                compressionMap.put(sortedArr[i], num);
                num++;
            }
        }

        // 압축된 값으로 원래 배열 대체
        for (int i = 0; i < n; i++) {
            // arr[i]의 value값을 arr[i]에 대체
            arr[i] = compressionMap.get(arr[i]);
        }

        // string builder를 통해 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
}
