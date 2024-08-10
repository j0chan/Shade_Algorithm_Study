/*
    left=0, right=1부터 시작
    l+r>k : left 이동
    l+r<k : right 이동
    l+r=k : update메서드 호출하여 배열 갱신, left이동
*/

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0,sequence.length -1};

        int left=0, right=1; // 포인터 초기화

        int sum = sequence[0];

        while(left<right) {
            if(sum==k){
                update(left, right, answer); // change 호출해서 결과 변경
                sum = sum-sequence[left++]; // left 우측으로 한 칸 이동
            } else if(sum>k){
                sum = sum-sequence[left++]; // left 우측으로 한 칸 이동
            } else if(right<sequence.length){
                sum = sum+sequence[right++]; // right 우측으로 한 칸 이동
            } else{ // right포인터가 배열 끝에 도달 시
                break; // 루프 종료
            }
        }

        return answer;
    }

    // answer배열을 갱신하는 메서드
    public void update(int left, int right, int[] answer) {
        // 현재 배열 길이 < 기존 저장된 배열 길이
        if((right-1-left)<(answer[1]-answer[0])){
            answer[0] =left;
            answer[1] = right-1;
        }
    }
}
