import java.util.*;
import java.io.*;

class Main {
    static class Info{
        int v, d;
        Info(int v, int d) {
            this.v = v;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        int x = Integer.parseInt(stk.nextToken());

        List<List<Info>> graph = new ArrayList<>(n+1);
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            graph.get(a).add(new Info(b, 1));
        }

        int[] dist = dijkstra(graph, x);
        boolean flag = false;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == k) {
                flag = true;
                System.out.println(i);
            }
        }
        if(!flag){
            System.out.println(-1);
        }
    }

    public static int[] dijkstra(List<List<Info>> graph, int start) {
        int[] dist = new int[graph.size()+1];
        for (int i = 0; i < dist.length; i++) {
            if (i == start) {
                dist[i] = 0;
            }
            else{
                dist[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.d));
        pq.offer(new Info(start, 0));
        while (!pq.isEmpty()) {
            Info cur = pq.poll();
            if (cur.d > dist[cur.v]) {
                continue;
            }
            for (Info node : graph.get(cur.v)) {
                if (dist[node.v] <= node.d + dist[cur.v]) {
                    continue;
                }
                dist[node.v] = node.d + dist[cur.v];
                pq.offer(new Info(node.v, dist[node.v]));
            }
        }
        return dist;
    }
}