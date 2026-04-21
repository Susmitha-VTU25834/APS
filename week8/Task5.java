class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int old = image[sr][sc];
        if (old != color)
            dfs(image, sr, sc, old, color);
        return image;
    }

    void dfs(int[][] img, int i, int j, int old, int color) {
        if (i < 0 || j < 0 || i >= img.length || j >= img[0].length || img[i][j] != old)
            return;

        img[i][j] = color;

        dfs(img, i+1, j, old, color);
        dfs(img, i-1, j, old, color);
        dfs(img, i, j+1, old, color);
        dfs(img, i, j-1, old, color);
    }
}
