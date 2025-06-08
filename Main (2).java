import java.util.*;

public class Main {

    static final long mode = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        boolean zeroForn = false;


        List<Integer>[] reds = new List[n + 1];
        List<Integer>[] blues = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            reds[i] = new ArrayList<>();
            blues[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int v = scanner.nextInt();
            int u = scanner.nextInt();
            String c = scanner.next();

            if (c.equals("RED")) {
                reds[v].add(u);
                reds[u].add(v);
            }
            else {
                blues[v].add(u);
                blues[u].add(v);
            }
        }

        boolean[] visitedRed = new boolean[n + 1];

        boolean[] visitedBlue = new boolean[n + 1];

        long totalPaths = pow(n, k);

        long totalUgly = 0;

        for (int i = 1; i <= n; i++) {
            if (!visitedRed[i]) {
                int cs = dfs(i, reds, visitedRed);
                totalUgly = (totalUgly + countUglyPaths(cs, k)) % mode;
            }

            if (!visitedBlue[i]) {
                int cs = dfs(i, blues, visitedBlue);
                totalUgly = (totalUgly + countUglyPaths(cs, k)) % mode;
            }
        }

        if (n==0 || k==0 ){
            System.out.println(0);
        }
        else {
            System.out.println(((totalPaths - totalUgly) % mode + mode) % mode);
        }
    }

    static int dfs(int node, List<Integer>[] l, boolean[] visited) {

        int size = 1;

        visited[node] = true;

        for (int neighbor : l[node]) {
            if (!visited[neighbor]) {
                size += dfs(neighbor, l, visited);
            }
        }
        return size;
    }

    static long countUglyPaths(int cs, int k) {
        return ((pow(cs, k) - cs) % mode + mode) % mode;
    }

    static long pow(long base, int exp) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mode;
            }
            base = (base * base) % mode;
            exp /= 2;
        }
        return result;
    }
}
