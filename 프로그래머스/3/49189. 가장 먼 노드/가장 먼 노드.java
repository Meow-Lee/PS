import java.util.*;

class Solution {
    static class Pair implements Comparable<Pair> {
        int v, cost;
        Pair(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Pair p){
            return this.cost - p.cost;
        }
    }
    static int[] dist;
    static ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
    public int solution(int n, int[][] edge) {
        // 그래프 구성
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        // 무방향 그래프
        for(int[] e : edge){
            int a = e[0];
            int b = e[1];
            
            graph.get(a).add(new Pair(b, 1));
            graph.get(b).add(new Pair(a, 1));
        }
        
        dijkstra(n, 1);
        
        int tmp = 0;
        for(int i=1; i<dist.length; i++){
            tmp = Math.max(tmp, dist[i]);
        }
        
        int ans = 0;
        for(int num : dist){
            if(num == tmp){
                ans++;
            }
        }
        
        return ans;
    }
    
    static void dijkstra(int n, int start){
        boolean[] check = new boolean[n+1];
        dist = new int[n+1];
        
        Arrays.fill(dist, (int)1e9);
        dist[start] = 0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(start, 0));
        
        while(!pq.isEmpty()){
            Pair cur = pq.poll();
            
            if(!check[cur.v]){
                check[cur.v] = true;
            }
            
            for(Pair next : graph.get(cur.v)){
                if(dist[next.v] > dist[cur.v] + next.cost){
                    dist[next.v] = dist[cur.v] + next.cost;
                    
                    pq.offer(new Pair(next.v, dist[next.v]));
                }
            }
        }
    }
}