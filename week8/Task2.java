import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red, int[][] blue) {
        List<Integer>[] redGraph = new ArrayList[n];
        List<Integer>[] blueGraph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            redGraph[i] = new ArrayList<>();
            blueGraph[i] = new ArrayList<>();
        }

        for (int[] r : red) redGraph[r[0]].add(r[1]);
        for (int[] b : blue) blueGraph[b[0]].add(b[1]);

        int[][] dist = new int[n][2];
        for (int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        q.offer(new int[]{0, 1});
        dist[0][0] = dist[0][1] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0], color = curr[1];

            if (color == 0) {
                for (int nei : blueGraph[node]) {
                    if (dist[nei][1] == Integer.MAX_VALUE) {
                        dist[nei][1] = dist[node][0] + 1;
                        q.offer(new int[]{nei, 1});
                    }
                }
            } else {
                for (int nei : redGraph[node]) {
                    if (dist[nei][0] == Integer.MAX_VALUE) {
                        dist[nei][0] = dist[node][1] + 1;
                        q.offer(new int[]{nei, 0});
                    }
                }
            }
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int min = Math.min(dist[i][0], dist[i][1]);
            res[i] = (min == Integer.MAX_VALUE) ? -1 : min;
        }
        return res;
    }
}
