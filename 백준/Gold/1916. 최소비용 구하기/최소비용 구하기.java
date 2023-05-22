import java.util.*;
import java.io.*;

class Main {
    static class Info{
        int v, d;
        public Info(int v, int d) {
            this.v = v;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(br.readLine());

        List<List<Info>> graph = new ArrayList<>(n+1);
        for(int i=0; i<n+1; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            stk = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());
            int d = Integer.parseInt(stk.nextToken());

            graph.get(s).add(new Info(v, d));
        }
        stk = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(stk.nextToken());
        int end = Integer.parseInt(stk.nextToken());

        System.out.println(dijkstra(graph, start, end));
    }
    public static int dijkstra(List<List<Info>> graph, int start, int end) {
        int[] dist = new int[graph.size()];
        for(int i=0; i<graph.size(); i++){
            if(i==start){
                dist[i]=0;
            }
            else{
                dist[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.d));
        pq.offer(new Info(start, 0));
        while (!pq.isEmpty()) {
            Info edge = pq.poll();
            if (dist[edge.v] < edge.d) {
                continue;
            }
            for (Info node : graph.get(edge.v)) {
                if (dist[node.v] <= dist[edge.v] + node.d) {
                    continue;
                }
                dist[node.v] = dist[edge.v] + node.d;
                pq.offer(new Info(node.v, dist[node.v]));
            }
        }
        return dist[end];
    }
}