import java.util.*;

class Solution {
    static ArrayList<Integer> list = new ArrayList<>();
    static int answer = 0;
    public int solution(int[] number) {
        boolean[] visited = new boolean[number.length];
        combination(number, visited, 0, 0, 3);
        return answer;
    }
    
    static void combination(int[] number, boolean[] visited, int count, int idx, int target){
        if(target == count){
            int sum = 0;
            for(int i=0; i<list.size(); i++){
                sum += list.get(i);
            }
            
            if(sum == 0){
                answer++;
            }
            return;
        }
        
        for(int i=idx; i<number.length; i++){
            visited[i] = true;
            list.add(number[i]);
            combination(number, visited, count+1, i+1, target);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
}