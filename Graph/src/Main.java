import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[][] graph1 = {
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5}
        };
        int[][] graph2 = {
                {1, 2},
                {1, 3},
                {2, 4},
                {2, 5},
                {3, 6},
                {5, 6}
        };
//        System.out.println(Arrays.toString(graph_34(graph1, 1, 5)));
        System.out.println(Arrays.toString(graph_34(graph2, 1, 6)));
    }

    static List<Integer> result;
    static boolean[] visited;
    static ArrayList<Integer>[] adjList;

    public static int[] graph_34 (int[][] graph, int start, int n) {
        result = new ArrayList<>();

//        Stack<Integer> stack = new Stack<>();

        adjList = new ArrayList[n+1];
        for (int i=1; i<n+1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] i : graph) {
            adjList[i[0]].add(i[1]);
//            adjList[i[1]].add(i[0]);
        }

        visited = new boolean[n+1];
        dfs(start);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void dfs(int node) {
        visited[node] = true;
        result.add(node);

        for (int next : adjList[node]) {
            if (!visited[next])
                dfs(next);
        }
    }
}
