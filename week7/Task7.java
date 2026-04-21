import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        for (int[] p : prerequisites)
            graph.get(p[1]).add(p[0]);

        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (dfs(graph, visited, i))
                return false;
        }
        return true;
    }

    boolean dfs(List<List<Integer>> graph, int[] visited, int i) {
        if (visited[i] == 1) return true;
        if (visited[i] == 2) return false;

        visited[i] = 1;

        for (int nei : graph.get(i)) {
            if (dfs(graph, visited, nei))
                return true;
        }

        visited[i] = 2;
        return false;
    }
}
