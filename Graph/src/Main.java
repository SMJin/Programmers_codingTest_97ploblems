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

    public static int[] graph_34 (int[][] graph, int start, int n) {
        List<Integer> result = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n+1];

        ArrayList<Integer>[] adjList = new ArrayList[n+1];
        for (int i=1; i<n+1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] i : graph) {
            adjList[i[0]].add(i[1]);
            adjList[i[1]].add(i[0]);
        }
        System.out.println(Arrays.toString(Arrays.stream(adjList).toArray()));

        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int ptr = stack.pop();

            System.out.print(ptr + " -> ");

            for (int i= adjList[ptr].size()-1; i>=0; i--) {
                Integer cur = adjList[ptr].get(i);
                if (!visited[cur]) {
                    stack.push(cur);
                    visited[cur] = true;
                }
            }

            result.add(ptr);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
