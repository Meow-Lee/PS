class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int sum=0, time=1;
        for(int i=0; i<num_list.length; i++){
            sum += num_list[i];
            time *= num_list[i];
        }
        
        if(time < Math.pow(sum, 2)){
            answer = 1;
        }
        return answer;
    }
}