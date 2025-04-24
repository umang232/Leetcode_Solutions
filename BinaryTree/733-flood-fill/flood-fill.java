class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        return dfs(image,sr,sc,color,image[sr][sc]);
    }

    public int[][] dfs(int[][]image, int i,int j,int color, int orig){
        if(i<0 || i>=image.length || j <0 || j >= image[0].length || image[i][j] != orig || image[i][j] == color){
            return image;
        }
        image[i][j] = color;
        dfs(image,i+1,j,color,orig);
        dfs(image,i-1,j,color,orig);
        dfs(image,i,j-1,color,orig);
        dfs(image,i,j+1,color,orig);
        return image;
    }
}