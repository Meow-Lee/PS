import java.util.*;

class Solution {
    static class Info implements Comparable<Info> {
        String s;
        int n;
        Info(String s, int n){
            this.s = s;
            this.n = n;
        }
        
        @Override
        public int compareTo(Info o){
            if(this.s.charAt(n) == o.s.charAt(n)){
                return this.s.compareTo(o.s);
            }
            return this.s.charAt(n) - o.s.charAt(n);
        }
    }
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        
        ArrayList<Info> list = new ArrayList<>();
        for(int i=0; i<strings.length; i++){
            list.add(new Info(strings[i], n));
        }
        Collections.sort(list);
        
        for(int i=0; i<list.size(); i++){
            Info info = list.get(i);
            answer[i] = info.s;
        }
        
        return answer;
    }
}