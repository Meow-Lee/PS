import java.util.*;
import java.io.*;

public class Main {
    static Map<String, Integer> map = new HashMap<>();
    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = 0;
        String str = br.readLine();
        while (true) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.putIfAbsent(str, 1);
            }
            size++;

            str = br.readLine();
            if (str == null || str.length() == 0) {
                break;
            }
        }
        solve();
    }

    static void solve() {
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        for (String key : keySet) {
            double tmp = (double) (map.get(key) * 100) / size;
            System.out.println(key + " " + String.format("%.4f", tmp));
        }
    }
}