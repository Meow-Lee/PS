class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int sum1 = Integer.parseInt(Integer.toString(a) + Integer.toString(b));
        int sum2 = Integer.parseInt(Integer.toString(b) + Integer.toString(a));
        if(sum1>sum2){
            answer=sum1;
        }
        else{
            answer=sum2;
        }
        
        return answer;
    }
}