package week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Lecture {
    int start;
    int end;

    Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Baekjun_11000 { //강의실배정
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // Lecture의 객체(시작, 종료시간)를 저장하는 배열
        Lecture[] lectures = new Lecture[n];

        // 배열에 Lecture 객체 저장
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 강의 별 인스턴스 생성
            lectures[i] = new Lecture(start, end);
        }

        // 배열을 시작시간 기준 오름차순 정렬
        Arrays.sort(lectures, (a, b) -> {
            if (a.start == b.start) { // 시작시간이 같다면 종료시간 기준 오름차순 정렬
                return Integer.compare(a.end, b.end);
            }
            return Integer.compare(a.start, b.start);
        });

        // 우선순위 큐(자동 오름차순 정렬)를 이용해 가장 빨리 끝나는 강의의 종료시간을 추출한다.
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 첫 강의의 종료시간을 큐에 넣기
        pq.offer(lectures[0].end);

        for (int i = 1; i < n; i++) {
            // 가장 먼저 끝나는 강의가 예정 강의시작시간보다 빨리 끝날 때
            if (pq.peek() <= lectures[i].start) {
                // 큐의 첫 원소 제거 즉, 강의실 비워서 재사용
                pq.poll();
            }
            // n번째 수업의 종료시간 큐에 할당
            pq.offer(lectures[i].end);
        }

        // 큐의 크기(사용한 강의실 수) 출력
        System.out.println(pq.size());
    }
}
